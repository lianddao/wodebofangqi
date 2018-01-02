package com.miui.player.asyncplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.audiofx.Equalizer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.miui.player.asyncplayer.BufferedMediaPlayer.RemoteControlInfo;
import com.miui.player.asyncplayer.BufferedMediaPlayer.ShowLinkListener;
import com.miui.player.asyncplayer.PlayerStub.AsyncPrepareListener;
import com.miui.player.asyncplayer.PlayerStub.PrepareInfo;
import com.miui.player.asyncplayer.RunnableList.RemovableRunnable;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AsyncMusicPlayer implements RunnableList, PlayerStub {
    private static final int ADD_RUNNABLE = 7;
    private static final int DATA_SET = 1;
    private static final int MODE_CHANGE = 6;
    private static final int ON_COMPLETION = 100;
    private static final int ON_ERROR = 101;
    private static final int ON_EXCEPTION = 102;
    private static final int ON_SEEKED = 104;
    private static final int ON_SUCCESS = 103;
    private static final int PAUSE = 5;
    private static final int RELEASE = 9;
    private static final int REMOVE_RUNNABLE = 8;
    private static final int SEEK = 4;
    private static final int START = 2;
    private static final int STOP = 3;
    private short[] mBandLevels;
    final LinkedList<Command> mCmdQueue = new LinkedList();
    OnCompletionListener mCompletionListener;
    final AsyncPrepareListener mDataSourceStarter;
    private Equalizer mEqualizer;
    private final Object mEqualizerLock = new Object();
    OnErrorListener mErrorListener;
    final Handler mHandler = new C03341();
    private long mLastDuration = 1;
    private long mLastPosition = 0;
    int mNextId = 0;
    private final OnCompletionListener mOnCompletionListenerAsync = new C03352();
    private final OnErrorListener mOnErrorListenerAsync = new C03363();
    final BufferedMediaPlayer mPlayer;
    private boolean mReleased = false;
    final RemoteControlInfo mRemoteControlInfo;
    private int mSessionId = -1;
    private int mState = 3;
    String mTag;
    WorkThread mThread;

    class C03341 extends Handler {
        C03341() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    if (AsyncMusicPlayer.this.mCompletionListener != null) {
                        AsyncMusicPlayer.this.mCompletionListener.onCompletion((MediaPlayer) msg.obj);
                        return;
                    }
                    return;
                case 101:
                    if (AsyncMusicPlayer.this.mErrorListener != null) {
                        ErrorMessage errMsg = msg.obj;
                        AsyncMusicPlayer.this.mErrorListener.onError(errMsg.mp, errMsg.what, errMsg.extra);
                        return;
                    }
                    return;
                case 102:
                    MessageObj objFailed = msg.obj;
                    AsyncMusicPlayer.this.mDataSourceStarter.onPrepareFailed(objFailed.path, objFailed.extra, objFailed.exception);
                    return;
                case 103:
                    MessageObj objSuc = msg.obj;
                    AsyncMusicPlayer.this.mDataSourceStarter.onPrepareSuccess(objSuc.path, objSuc.extra);
                    return;
                case 104:
                    AsyncMusicPlayer.this.mDataSourceStarter.onSeeked(msg.arg1);
                    return;
                default:
                    throw new IllegalArgumentException("undefined msg = " + msg.what);
            }
        }
    }

    class C03352 implements OnCompletionListener {
        C03352() {
        }

        public void onCompletion(MediaPlayer mp) {
            Message msg = AsyncMusicPlayer.this.mHandler.obtainMessage(100);
            msg.obj = mp;
            AsyncMusicPlayer.this.mHandler.sendMessage(msg);
        }
    }

    class C03363 implements OnErrorListener {
        C03363() {
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            Message msg = AsyncMusicPlayer.this.mHandler.obtainMessage(101);
            msg.obj = new ErrorMessage(mp, what, extra);
            AsyncMusicPlayer.this.mHandler.sendMessage(msg);
            return true;
        }
    }

    static final class Command {
        int code;
        Object extra;
        String path;

        Command() {
        }

        public String toString() {
            return "{ code=" + this.code + " path=" + this.path + " }";
        }
    }

    private class ErrorMessage {
        final int extra;
        final MediaPlayer mp;
        final int what;

        public ErrorMessage(MediaPlayer mpA, int whatA, int extraA) {
            this.mp = mpA;
            this.what = whatA;
            this.extra = extraA;
        }
    }

    private class MessageObj {
        public final Exception exception;
        public final Object extra;
        public final String path;

        public MessageObj(String pathA, Object extraA, Exception tagA) {
            this.path = pathA;
            this.extra = extraA;
            this.exception = tagA;
        }
    }

    class RunnableInfo {
        public final RemovableRunnable runnable;
        public final long time;

        public RunnableInfo(RemovableRunnable r, long d) {
            this.runnable = r;
            this.time = System.currentTimeMillis() + d;
        }
    }

    private final class WorkThread extends Thread {
        WorkThread() {
            super("AsyncPlayer-" + AsyncMusicPlayer.this.mTag);
        }

        public void run() {
            while (true) {
                Command cmd;
                synchronized (AsyncMusicPlayer.this.mCmdQueue) {
                    cmd = AsyncMusicPlayer.this.popNextUsableCommand();
                }
                Utils.debugLog(AsyncMusicPlayer.this.mTag, "get next command " + cmd.code);
                switch (cmd.code) {
                    case 1:
                        AsyncMusicPlayer.this.startSound(cmd);
                        break;
                    case 2:
                        if (!(AsyncMusicPlayer.this.mPlayer == null || AsyncMusicPlayer.this.mPlayer.isPlaying())) {
                            AsyncMusicPlayer.this.mPlayer.start();
                            break;
                        }
                    case 3:
                        if (AsyncMusicPlayer.this.mPlayer != null) {
                            boolean stopNextDownload = ((Boolean) cmd.extra).booleanValue();
                            AsyncMusicPlayer.this.mPlayer.reset(stopNextDownload);
                            if (stopNextDownload) {
                                AsyncMusicPlayer.this.mNextId = 0;
                                break;
                            }
                        }
                        break;
                    case 4:
                        if (AsyncMusicPlayer.this.mPlayer != null) {
                            Integer pos = cmd.extra;
                            if (pos.intValue() < 0) {
                                pos = Integer.valueOf(0);
                            } else if (pos.intValue() > AsyncMusicPlayer.this.mPlayer.getDuration()) {
                                pos = Integer.valueOf(AsyncMusicPlayer.this.mPlayer.getDuration());
                            }
                            AsyncMusicPlayer.this.mPlayer.seekTo(pos.intValue());
                            AsyncMusicPlayer.this.mHandler.sendMessage(AsyncMusicPlayer.this.mHandler.obtainMessage(104, pos.intValue(), 0));
                            break;
                        }
                        break;
                    case 5:
                        if (AsyncMusicPlayer.this.mPlayer != null && AsyncMusicPlayer.this.mPlayer.isPlaying()) {
                            AsyncMusicPlayer.this.mPlayer.pause();
                            break;
                        }
                    case 6:
                        if (AsyncMusicPlayer.this.mPlayer != null) {
                            AsyncMusicPlayer.this.mPlayer.cancelPrepare(true);
                            AsyncMusicPlayer.this.mNextId = 0;
                            break;
                        }
                        break;
                    case 7:
                        RunnableInfo info = cmd.extra;
                        RemovableRunnable rr = info.runnable;
                        if (!rr.isRemovable()) {
                            if (info.time >= System.currentTimeMillis()) {
                                try {
                                    sleep(200);
                                    synchronized (AsyncMusicPlayer.this.mCmdQueue) {
                                        AsyncMusicPlayer.this.doRemoveRunnable(cmd.path);
                                        AsyncMusicPlayer.this.enqueueLocked(cmd);
                                    }
                                    break;
                                } catch (InterruptedException e) {
                                    break;
                                }
                            }
                            rr.run();
                            break;
                        }
                        break;
                    case 8:
                        String name = cmd.path;
                        synchronized (AsyncMusicPlayer.this.mCmdQueue) {
                            AsyncMusicPlayer.this.doRemoveRunnable(name);
                        }
                        break;
                    case 9:
                        AsyncMusicPlayer.this.releaseAll(cmd.extra);
                        break;
                }
                synchronized (AsyncMusicPlayer.this.mCmdQueue) {
                    if (AsyncMusicPlayer.this.mCmdQueue.size() == 0) {
                        AsyncMusicPlayer.this.mThread = null;
                        return;
                    }
                }
            }
        }
    }

    public void add(String name, RemovableRunnable r, long delay) {
        Utils.debugLog(this.mTag, "add runnable name=%s, delay=%d, current=%d", name, Long.valueOf(delay), Long.valueOf(System.currentTimeMillis()));
        Command cmd = new Command();
        cmd.code = 7;
        cmd.path = name;
        cmd.extra = new RunnableInfo(r, delay);
        synchronized (this.mCmdQueue) {
            doRemoveRunnable(name);
            enqueueLocked(cmd);
        }
    }

    public void remove(String name) {
        Utils.debugLog(this.mTag, "remove runnable name ", name);
        Command cmd = new Command();
        cmd.code = 8;
        cmd.path = name;
        synchronized (this.mCmdQueue) {
            enqueueLocked(cmd);
        }
    }

    void doRemoveRunnable(String name) {
        Iterator<Command> i = this.mCmdQueue.iterator();
        while (i.hasNext()) {
            Command c = (Command) i.next();
            if (c.code == 8 || (c.code == 7 && name.equals(c.path))) {
                i.remove();
            }
        }
    }

    void startSound(Command cmd) {
        Exception exception = null;
        boolean isFirst = false;
        try {
            int id;
            if (this.mNextId == 0) {
                BufferedMediaPlayer.setUp(this);
                id = BufferedMediaPlayer.getDefaultTempId();
                isFirst = true;
            } else {
                id = this.mNextId;
            }
            this.mPlayer.cancelPrepare(false);
            this.mPlayer.reset(false);
            this.mPlayer.setTempId(id, isFirst);
            updateEqualizerSessionId(this.mPlayer.getAudioSessionId());
            prepareAsync(cmd.path, cmd.extra);
            this.mNextId = this.mPlayer.getNextId();
            Message msg = this.mHandler.obtainMessage(103);
            msg.obj = new MessageObj(cmd.path, cmd.extra, null);
            this.mHandler.sendMessage(msg);
        } catch (Exception e) {
            exception = e;
        } catch (Exception e2) {
            exception = e2;
        } catch (Exception e22) {
            exception = e22;
        } catch (Exception e222) {
            exception = e222;
        } catch (Exception e2222) {
            exception = e2222;
        }
        if (exception != null) {
            this.mNextId = 0;
            msg = this.mHandler.obtainMessage(102);
            msg.obj = new MessageObj(cmd.path, cmd.extra, exception);
            this.mHandler.sendMessage(msg);
            exception.printStackTrace();
        }
    }

    Command popNextUsableCommand() {
        Command firstCmd = (Command) this.mCmdQueue.removeFirst();
        if (firstCmd.code == 3 || firstCmd.code == 6) {
            return firstCmd;
        }
        int size = this.mCmdQueue.size();
        if (size == 0) {
            return firstCmd;
        }
        int firstCode = firstCmd.code;
        Command priorityCmd = null;
        int stopAndMetaChangeIdx = -1;
        int modeChangeIdx = -1;
        int stopOrStartIdx = -1;
        int priorityIdx = -1;
        ListIterator<Command> iter = this.mCmdQueue.listIterator(size);
        int i = size;
        while (iter.hasPrevious()) {
            Command cmd = (Command) iter.previous();
            int code = cmd.code;
            if (code == 3 && ((Boolean) cmd.extra).booleanValue()) {
                stopAndMetaChangeIdx = i;
                break;
            }
            if (code == 6) {
                modeChangeIdx = i;
            } else if (code == 3 || code == 1) {
                stopOrStartIdx = i;
            }
            i--;
        }
        if (stopAndMetaChangeIdx > -1) {
            priorityIdx = stopAndMetaChangeIdx;
        } else if (modeChangeIdx > -1) {
            if (!(firstCode == 3 || firstCode == 1)) {
                priorityIdx = modeChangeIdx;
            }
        } else if (stopOrStartIdx > -1) {
            priorityIdx = stopOrStartIdx;
        }
        if (priorityIdx > -1) {
            iter = this.mCmdQueue.listIterator(priorityIdx);
            priorityCmd = (Command) iter.previous();
            iter.remove();
            while (iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }
        }
        if (priorityCmd == null) {
            priorityCmd = firstCmd;
        }
        return priorityCmd;
    }

    public AsyncMusicPlayer(String tag, AsyncPrepareListener starter, RemoteControlInfo remoteControlInfo) {
        if (tag != null) {
            this.mTag = tag;
        } else {
            this.mTag = "AsyncPlayer";
        }
        this.mDataSourceStarter = starter;
        this.mRemoteControlInfo = remoteControlInfo;
        this.mPlayer = new BufferedMediaPlayer(this);
        this.mPlayer.setOnErrorListener(this.mOnErrorListenerAsync);
        this.mPlayer.setOnCompletionListener(this.mOnCompletionListenerAsync);
    }

    public void setOnCompletionListener(OnCompletionListener l) {
        this.mCompletionListener = l;
    }

    public void setOnErrorListener(OnErrorListener l) {
        this.mErrorListener = l;
    }

    public void prepare(String path, PrepareInfo extra) {
        Command cmd = new Command();
        cmd.code = 1;
        cmd.path = path;
        cmd.extra = extra;
        synchronized (this.mCmdQueue) {
            enqueueLocked(cmd);
            this.mState = 1;
        }
    }

    public void release() {
        Command cmd = new Command();
        cmd.code = 9;
        cmd.extra = MusicApplication.getApplication();
        synchronized (this.mCmdQueue) {
            enqueueLocked(cmd);
            this.mReleased = true;
        }
    }

    public void start() {
        Command cmd = new Command();
        cmd.code = 2;
        synchronized (this.mCmdQueue) {
            if (this.mPlayer != null) {
                this.mPlayer.togglePause(2);
            }
            enqueueLocked(cmd);
            this.mState = 2;
        }
    }

    public void changeMode(int oldMode, int newMode) {
        if (newMode == 1 || oldMode == 1) {
            Command cmd = new Command();
            cmd.code = 6;
            synchronized (this.mCmdQueue) {
                enqueueLocked(cmd);
            }
        }
    }

    public void pause() {
        Command cmd = new Command();
        cmd.code = 5;
        synchronized (this.mCmdQueue) {
            if (this.mPlayer != null) {
                this.mPlayer.togglePause(1);
            }
            enqueueLocked(cmd);
            this.mState = 5;
        }
    }

    public boolean isInitialized() {
        return this.mState != 3;
    }

    public boolean isPrepared() {
        return this.mState == 2 || this.mState == 5;
    }

    public void stop(boolean permanent, boolean orderChanged) {
        synchronized (this.mCmdQueue) {
            if (this.mPlayer != null) {
                this.mPlayer.interrupt();
                this.mPlayer.togglePause(1);
            }
            if (this.mState != 3) {
                Command cmd = new Command();
                cmd.code = 3;
                cmd.extra = Boolean.valueOf(orderChanged);
                enqueueLocked(cmd);
                this.mState = 3;
            }
        }
    }

    public void seek(long pos) {
        synchronized (this.mCmdQueue) {
            Command cmd = new Command();
            cmd.code = 4;
            cmd.extra = Integer.valueOf((int) pos);
            enqueueLocked(cmd);
            this.mLastPosition = pos;
        }
    }

    public long duration() {
        synchronized (this.mCmdQueue) {
            try {
                if (this.mPlayer != null) {
                    this.mLastDuration = (long) this.mPlayer.getDuration();
                } else {
                    this.mLastDuration = 1;
                }
            } catch (Exception e) {
            }
        }
        return this.mLastDuration;
    }

    public long position() {
        synchronized (this.mCmdQueue) {
            try {
                if (this.mPlayer != null) {
                    this.mLastPosition = (long) this.mPlayer.getCurrentPosition();
                } else {
                    this.mLastPosition = 0;
                }
            } catch (Exception e) {
            }
        }
        return this.mLastPosition;
    }

    public boolean isBlocking() {
        boolean isBlocking;
        synchronized (this.mCmdQueue) {
            if (this.mPlayer != null) {
                isBlocking = this.mPlayer.isBlocking();
            } else {
                isBlocking = false;
            }
        }
        return isBlocking;
    }

    public float getBufferedPercent() {
        try {
            synchronized (this.mCmdQueue) {
                if (this.mPlayer != null) {
                    float bufferdPercent = this.mPlayer.getBufferdPercent();
                    return bufferdPercent;
                }
            }
        } catch (Exception e) {
        }
        return 0.0f;
    }

    public String getPath() {
        try {
            synchronized (this.mCmdQueue) {
                if (this.mPlayer != null) {
                    String playingFilePath = this.mPlayer.getPlayingFilePath();
                    return playingFilePath;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean adjustVolume(boolean raise) {
        return false;
    }

    void releaseAll(Context context) {
        synchronized (this.mEqualizerLock) {
            if (this.mEqualizer != null) {
                releaseEqualzier(this.mEqualizer);
                this.mEqualizer = null;
            }
        }
        synchronized (this.mCmdQueue) {
            this.mPlayer.release(context, true);
        }
    }

    void updateEqualizerSessionId(int sessionId) {
        synchronized (this.mEqualizerLock) {
            if (this.mSessionId != sessionId) {
                this.mSessionId = sessionId;
                if (this.mEqualizer != null) {
                    releaseEqualzier(this.mEqualizer);
                    this.mEqualizer = null;
                    Utils.debugLog(this.mTag, "release equalizer for update session id!");
                }
                if (this.mBandLevels != null) {
                    updateEqualizerBands(this.mBandLevels);
                }
            }
        }
    }

    private static Equalizer createEqualizer(int sessionId) {
        try {
            return new Equalizer(0, sessionId);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static void releaseEqualzier(Equalizer equalizer) {
        String device = Build.DEVICE;
        if ("ace".equals(device) || "vision".equals(device)) {
            equalizer.setEnabled(false);
        } else {
            equalizer.release();
        }
    }

    public void updateEqualizerBands(short[] levels) {
        synchronized (this.mCmdQueue) {
            int sessionId = this.mPlayer.getAudioSessionId();
        }
        synchronized (this.mEqualizerLock) {
            this.mBandLevels = levels;
            if (levels != null) {
                if (this.mEqualizer == null && sessionId != -1) {
                    this.mEqualizer = createEqualizer(sessionId);
                    if (this.mEqualizer != null) {
                        this.mEqualizer.setEnabled(true);
                        Utils.debugLog(this.mTag, "%s=%d", "create equalizer ", Integer.valueOf(sessionId));
                    }
                }
                if (this.mEqualizer != null) {
                    setBands(this.mEqualizer, levels, this.mTag);
                }
            } else if (this.mEqualizer != null) {
                releaseEqualzier(this.mEqualizer);
                this.mEqualizer = null;
                Utils.debugLog(this.mTag, "release equalizer from user!");
            }
        }
    }

    public int getAudioSessionId() {
        int audioSessionId;
        synchronized (this.mCmdQueue) {
            audioSessionId = this.mPlayer.getAudioSessionId();
        }
        return audioSessionId;
    }

    private static void setBands(Equalizer eq, short[] bands, String tag) {
        for (short i = (short) 0; i < bands.length; i = (short) (i + 1)) {
            try {
                eq.setBandLevel(i, bands[i]);
            } catch (Exception e) {
                Log.e(tag, String.format("setBandLevel failed, band=%d, level=%d", new Object[]{Short.valueOf(i), Short.valueOf(bands[i])}), e);
            }
        }
    }

    void enqueueLocked(Command cmd) {
        if (!this.mReleased) {
            this.mCmdQueue.add(cmd);
            if (this.mThread == null) {
                this.mThread = new WorkThread();
                this.mThread.start();
            }
        }
    }

    private void prepareAsync(String path, Object extra) throws IllegalArgumentException, IOException, OnlinePlayDeniedException, InterruptedException {
        Context context = MusicApplication.getApplication();
        BufferedMediaPlayer mp = this.mPlayer;
        PrepareInfo prepareInfo = (PrepareInfo) extra;
        RemoteControlInfo info = this.mRemoteControlInfo;
        IPlayerHelper helper = ApplicationHelper.instance().getPlayerHelper();
        if (helper.isOnlineAudio(path)) {
            RemoteMediaInfo remoteMediaInfo = helper.getRemoteMediaInfo(context, path);
            if (remoteMediaInfo == null) {
                throw new IOException("Fail to find uri, path=" + path);
            }
            boolean onlineAllow = !NetworkUtil.isActiveNetworkMetered(context) || PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_LISTEN_TO_MUSIC_OTHER);
            if (onlineAllow || localExists(context, mp, remoteMediaInfo.mAppointName)) {
                mp.prepareWithBuffer(context, info, remoteMediaInfo, prepareInfo.mNextAudioId);
            } else {
                throw new OnlinePlayDeniedException("online play not allow");
            }
        }
        Uri uri = helper.getLocalUriToPlay(path);
        if (uri == null) {
            throw new IOException("Fail to find uri, path=" + path);
        }
        mp.prepareDirectly(context, info, uri, prepareInfo.mNextAudioId);
        mp.seekTo((int) prepareInfo.mStartPosition);
        mp.setAudioStreamType(3);
    }

    private static boolean localExists(Context context, BufferedMediaPlayer mp, String appointName) {
        return new File(StorageConfig.getMp3Dir(false), appointName).exists();
    }

    public void setShowLinkLister(ShowLinkListener listener) {
        this.mPlayer.setShowLinkListener(listener);
    }
}
