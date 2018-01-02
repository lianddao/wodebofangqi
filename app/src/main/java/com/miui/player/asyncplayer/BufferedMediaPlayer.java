package com.miui.player.asyncplayer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import android.provider.Downloads.Impl;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.music.download.db.DBConfig.DownloadItemColumns;
import com.baidu.utils.FileUtil;
import com.miui.player.C0329R;
import com.miui.player.asyncplayer.RunnableList.RemovableRunnable;
import com.miui.player.download.DownloadProviderProxy;
import com.miui.player.download.IDownloader;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.MetaManager;
import com.miui.player.reporter.OnlinePlayStatstics;
import com.miui.player.service.ShakeListener;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.Actions;
import com.miui.player.util.FileOperations;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.StorageUtils;
import com.miui.player.util.ThreadManager;
import com.miui.player.util.Utils;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.exceptions.CannotReadException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import miui.os.Build;

public class BufferedMediaPlayer {
    private static final long DEFAULT_REMOTE_MEDIA_DURATION = 300000;
    public static final int FADEOUT_MODE_LONG = 1;
    public static final int FADEOUT_MODE_NONE = 2;
    public static final int FADEOUT_MODE_NORMAL = 0;
    static final int IDX_CURRNENT_BYTE = 0;
    static final int IDX_STATUS = 2;
    static final int IDX_TITLE = 3;
    static final int IDX_TOTAL_BYTES = 1;
    public static final int INVALIDE_SESSION_ID = -1;
    public static final int INVALID_TEMP_FILE_ID = 0;
    private static final int MIN_BYTE_PER_SEC = 2048;
    private static final int ONLINE_MIN_SIZE = 1048576;
    static final String[] ObserverColumns = new String[]{DownloadItemColumns.CURRENT_BYTES, DownloadItemColumns.TOTAL_BYTES, "status", "title"};
    private static final int PLAYER_CACHE_MSEC = 10000;
    private static final int PLAYER_THRESHOLD_BYTES = 524288;
    private static final int STATUS_BUFFER_IN_PROCESS = 1;
    private static final int STATUS_BUFFER_SUCCESS = 2;
    private static final int STATUS_DOWNLOAD_COMPLETED = 4;
    private static final int STATUS_ERROR = 3;
    private static final int STATUS_IDLE = 0;
    static final String TAG = BufferedMediaPlayer.class.getCanonicalName();
    public static final String TEMP_DIR = "data/data/com.android.providers.downloads/cache";
    private static final int[] TEMP_FILE_ID_ARR = new int[]{1, 2};
    public static final String TEMP_MEDIA_NAME = ".CURRENT_MIUI%d.mp3.tmp";
    private static final long TIME_OUT_FOR_DELETE_FILE = 5000;
    public static final int TOGGLE_PAUSE = 1;
    public static final int TOGGLE_PLAY = 2;
    private static final float VOLUME_FADEIN_DEGREE = 0.01f;
    private static final float VOLUME_FADEOUT_DEGREE = 0.03f;
    private static final float VOLUME_FADEOUT_DEGREE_LONG = 0.001f;
    private static final int VOLUME_FADEOUT_INTERVAL_LONG = 10;
    private static final int VOLUME_FADE_INTERVAL = 10;
    private static final int WAIT_LOOP_TIMES = 60;
    private static int sFadeOutMode = 0;
    static OnlinePlayStatstics sGlobalStastics = null;
    static final Object sNextDownloadLock = new Object();
    private static float sVolume = 0.01f;
    int mBitrate = 0;
    final Object mBufferLock = new Object();
    private long mBytesLastSet = 0;
    Context mContext;
    long mCurrentBytes = 0;
    File mCurrentFile;
    final DownloadNextRunnable mDownloadNextRunnable;
    ContentObserver mDownloadObserver;
    Uri mDownloadingUri;
    boolean mInterrupt;
    boolean mIsBlocking;
    private boolean mIsFirst;
    final Object mListenerLock = new Object();
    PlayListenerTask mListenerThread;
    private String mNextMediaId;
    final SafeMediaPlayer mPlayer;
    private RemoteControlInfo mRemoteControlInfo;
    RemoteMediaInfo mRemoteMediaInfo;
    final RunnableList mRunnableList;
    private ShowLinkListener mShowLinkListener;
    OnlinePlayStatstics mStatistics;
    int mStatus;
    final String mTempDir;
    private int mTempId;
    private int mTogglePause;
    long mTotalBytes = 0;

    private class BufferContentObserver extends ContentObserver {
        public BufferContentObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            if (BufferedMediaPlayer.this.mDownloadingUri != null && BufferedMediaPlayer.this.mContext != null && BufferedMediaPlayer.this.mStatus != 0) {
                Cursor c = SqlUtils.query(BufferedMediaPlayer.this.mContext, BufferedMediaPlayer.this.mDownloadingUri, BufferedMediaPlayer.ObserverColumns, null, null, null);
                if (c != null) {
                    int newStatus = BufferedMediaPlayer.this.mStatus;
                    try {
                        if (c.moveToFirst()) {
                            BufferedMediaPlayer.this.mCurrentBytes = c.getLong(0);
                            BufferedMediaPlayer.this.mTotalBytes = c.getLong(1);
                            Utils.debugLog(BufferedMediaPlayer.TAG, "current=%d,  total=%d", Long.valueOf(BufferedMediaPlayer.this.mCurrentBytes), Long.valueOf(BufferedMediaPlayer.this.mTotalBytes));
                            if (BufferedMediaPlayer.this.mCurrentBytes > 0 && BufferedMediaPlayer.this.mTotalBytes < 0) {
                                BufferedMediaPlayer.this.mTotalBytes = BufferedMediaPlayer.DEFAULT_REMOTE_MEDIA_DURATION;
                                Log.e(BufferedMediaPlayer.TAG, "bad total bytes !");
                            }
                            int status = c.getInt(2);
                            if (DownloadProviderProxy.isRawStatusError(status)) {
                                DownloadProviderProxy.unregisterDownloadObserver(BufferedMediaPlayer.this.mContext, this);
                                newStatus = 3;
                            } else if (DownloadProviderProxy.isRawStatusSuccess(status)) {
                                DownloadProviderProxy.unregisterDownloadObserver(BufferedMediaPlayer.this.mContext, this);
                                updateBitrate(c);
                                newStatus = 4;
                            } else if (BufferedMediaPlayer.this.mStatus == 1 && BufferedMediaPlayer.this.mCurrentBytes > 524288) {
                                updateBitrate(c);
                                if (BufferedMediaPlayer.this.mBitrate > 0) {
                                    newStatus = 2;
                                }
                            }
                            BufferedMediaPlayer.this.runOnBufferedPositionChanged(BufferedMediaPlayer.this.getBufferdPercent());
                        }
                        c.close();
                        synchronized (BufferedMediaPlayer.this.mBufferLock) {
                            if (BufferedMediaPlayer.this.mStatus != 0) {
                                BufferedMediaPlayer.this.mStatus = newStatus;
                            }
                        }
                    } catch (Throwable th) {
                        c.close();
                    }
                }
            }
        }

        private void updateBitrate(Cursor c) {
            if (BufferedMediaPlayer.this.mBitrate <= 0) {
                String name = c.getString(3);
                if (!TextUtils.isEmpty(name)) {
                    File f = new File(BufferedMediaPlayer.this.mTempDir, name);
                    if (f.exists()) {
                        BufferedMediaPlayer.this.mBitrate = BufferedMediaPlayer.this.getAudioBitRate(f);
                    }
                } else {
                    return;
                }
            }
            if (BufferedMediaPlayer.this.mBitrate > 0 && BufferedMediaPlayer.this.mStatistics != null) {
                BufferedMediaPlayer.this.mStatistics.markConnectSuccess();
            }
        }
    }

    private static class DownloadNextRunnable implements RemovableRunnable {
        Context mContext;
        boolean mGotoDownload = false;
        private ContentObserver mNextContentObserver;
        Uri mNextDownloadUri;
        RemoteMediaInfo mNextInfo;
        private final String mNextTempDir;
        private String mNextTempName;
        final RunnableList mRunnableList;
        private int mTempId;

        class C03421 implements Runnable {
            C03421() {
            }

            public void run() {
                RemoteMediaInfo remoteMediaInfo = DownloadNextRunnable.this.mNextInfo;
                if (remoteMediaInfo != null) {
                    Pair<AudioDetail, List<AudioLink>> audio = BufferedMediaPlayer.getPlayerHelper().requestAudioDetail(DownloadNextRunnable.this.mContext, remoteMediaInfo.mId);
                    if (audio != null) {
                        remoteMediaInfo.mCandidates = (List) audio.second;
                        if (audio.first != null) {
                            BufferedMediaPlayer.getDownloader().updateDB(DownloadNextRunnable.this.mContext, remoteMediaInfo.mId, (AudioDetail) audio.first);
                        }
                        DownloadNextRunnable.this.mRunnableList.add(BufferedMediaPlayer.TAG, new TryNextRunnable(), 0);
                    }
                }
            }
        }

        private class NextContentObserver extends ContentObserver {
            public NextContentObserver(Handler handler) {
                super(handler);
            }

            public void onChange(boolean selfChange) {
                boolean unregister = false;
                Cursor c;
                try {
                    Context context;
                    if (DownloadNextRunnable.this.mGotoDownload && DownloadNextRunnable.this.mNextDownloadUri != null) {
                        c = SqlUtils.query(DownloadNextRunnable.this.mContext, DownloadNextRunnable.this.mNextDownloadUri, null, null, null, null);
                        if (c != null) {
                            if (c.moveToFirst()) {
                                long currentBytes = c.getLong(c.getColumnIndex(DownloadItemColumns.CURRENT_BYTES));
                                int status = c.getInt(c.getColumnIndex(DownloadItemColumns.TOTAL_BYTES));
                                if (DownloadProviderProxy.isRawStatusError(status)) {
                                    DownloadProviderProxy.unregisterDownloadObserver(DownloadNextRunnable.this.mContext, this);
                                    DownloadNextRunnable.this.mRunnableList.add(BufferedMediaPlayer.TAG, new TryNextRunnable(), 0);
                                } else if (DownloadProviderProxy.isRawStatusSuccess(status) || currentBytes > 524288) {
                                    unregister = true;
                                    Utils.debugLog(BufferedMediaPlayer.TAG, "prepare next song success, no need to observe!");
                                }
                            } else {
                                unregister = true;
                            }
                            c.close();
                            if (unregister) {
                                DownloadProviderProxy.unregisterDownloadObserver(DownloadNextRunnable.this.mContext, this);
                            }
                            super.onChange(selfChange);
                            return;
                        } else if (true) {
                            context = DownloadNextRunnable.this.mContext;
                        } else {
                            return;
                        }
                    } else if (true) {
                        context = DownloadNextRunnable.this.mContext;
                    } else {
                        return;
                    }
                    DownloadProviderProxy.unregisterDownloadObserver(context, this);
                } catch (Throwable th) {
                    if (unregister) {
                        DownloadProviderProxy.unregisterDownloadObserver(DownloadNextRunnable.this.mContext, this);
                    }
                }
            }
        }

        class TryNextRunnable implements RemovableRunnable {
            TryNextRunnable() {
            }

            public void run() {
                DownloadNextRunnable.this.tryToDownload();
            }

            public boolean isRemovable() {
                return !DownloadNextRunnable.this.mGotoDownload;
            }
        }

        public DownloadNextRunnable(RunnableList runnableList, String nextTempDir) {
            this.mNextTempDir = nextTempDir;
            this.mRunnableList = runnableList;
        }

        public void initialize(Context context, Handler handler, String nextId, String nextName, int tempId) {
            this.mNextInfo = null;
            this.mTempId = tempId;
            if (!BufferedMediaPlayer.getPlayerHelper().isValidGlobalId(nextId)) {
                this.mNextTempName = nextName;
                this.mContext = context;
                this.mNextContentObserver = new NextContentObserver(handler);
                this.mNextInfo = BufferedMediaPlayer.getPlayerHelper().getRemoteMediaInfo(context, nextId);
            }
            this.mGotoDownload = this.mNextInfo != null;
        }

        public boolean needDownload() {
            if (!this.mGotoDownload) {
                return false;
            }
            RemoteMediaInfo remoteMediaInfo = this.mNextInfo;
            if (remoteMediaInfo == null) {
                return false;
            }
            File localMedia = StorageUtils.findExistFile(new File(StorageConfig.getMp3Dir(false), remoteMediaInfo.mAppointName));
            Uri uri = DownloadProviderProxy.queryRunning(this.mContext, remoteMediaInfo.mId);
            if (localMedia.exists() || uri != null) {
                return false;
            }
            return true;
        }

        public void run() {
            if (needDownload()) {
                ThreadManager.postNetworkRequest(new C03421());
            }
        }

        public boolean isRemovable() {
            return !this.mGotoDownload;
        }

        void tryToDownload() {
            RemoteMediaInfo remoteMediaInfo = this.mNextInfo;
            if (remoteMediaInfo != null) {
                List<AudioLink> candidates = remoteMediaInfo.mCandidates;
                if (candidates != null) {
                    this.mNextDownloadUri = null;
                    synchronized (BufferedMediaPlayer.sNextDownloadLock) {
                        boolean isSuccess = false;
                        OnlinePlayStatstics stat = new OnlinePlayStatstics(remoteMediaInfo.mId);
                        BufferedMediaPlayer.sGlobalStastics = stat;
                        while (!isSuccess && !candidates.isEmpty() && this.mGotoDownload) {
                            AudioLink link = (AudioLink) candidates.get(0);
                            if (link != null) {
                                stat.setAudioLink(this.mContext, link);
                                this.mNextDownloadUri = DownloadProviderProxy.start(this.mContext, link, DownloadProviderProxy.wrapPlayingTag(remoteMediaInfo.mId, this.mTempId), remoteMediaInfo.mDetails, this.mNextTempName, this.mNextTempDir, null, false, 5000);
                                Utils.debugLog(BufferedMediaPlayer.TAG, "prepare candidates " + this.mNextDownloadUri);
                                isSuccess = DownloadProviderProxy.registerDownloadObserver(this.mContext, this.mNextDownloadUri, true, this.mNextContentObserver);
                            }
                            candidates.remove(0);
                        }
                    }
                }
            }
        }

        public void abort() {
            if (this.mGotoDownload) {
                detach();
                BufferedMediaPlayer.deleteRecord(this.mContext, this.mNextTempName, this.mRunnableList);
            }
        }

        public void detach() {
            if (this.mGotoDownload) {
                this.mGotoDownload = false;
                if (this.mNextContentObserver != null) {
                    DownloadProviderProxy.unregisterDownloadObserver(this.mContext, this.mNextContentObserver);
                }
            }
        }
    }

    public interface OnBlockingChangedListener {
        void onBlockingChanged(boolean z);
    }

    public interface OnBufferedPositionChangedListener {
        void onBufferedPositionChanged(float f);
    }

    public interface OnDownloadCompletedListener {
        void onDownloadCompleted(Context context, String str, String str2, String str3);
    }

    class PlayListenerTask extends Thread {
        PlayListenerTask() {
        }

        public void run() {
            while (BufferedMediaPlayer.this.mStatus != 4 && BufferedMediaPlayer.this.mStatus != 0 && BufferedMediaPlayer.this.mStatus != 3) {
                synchronized (BufferedMediaPlayer.this.mListenerLock) {
                    boolean isBuffered = BufferedMediaPlayer.this.hasBuffered(BufferedMediaPlayer.this.getCurrentPosition() + BufferedMediaPlayer.PLAYER_CACHE_MSEC);
                    boolean isPlaying = BufferedMediaPlayer.this.mPlayer.isPlaying();
                    if (!isBuffered && isPlaying) {
                        Log.i(BufferedMediaPlayer.TAG, "blocked because of network");
                        BufferedMediaPlayer.this.mIsBlocking = true;
                        BufferedMediaPlayer.this.runOnBlockingChanged();
                        BufferedMediaPlayer.this.mPlayer.pause();
                        if (BufferedMediaPlayer.this.mStatistics != null) {
                            BufferedMediaPlayer.this.mStatistics.markPause();
                        }
                        if (BufferedMediaPlayer.this.mStatistics != null) {
                            BufferedMediaPlayer.this.mStatistics.markBlocked();
                        }
                    } else if (BufferedMediaPlayer.this.mIsBlocking && isBuffered) {
                        Log.i(BufferedMediaPlayer.TAG, "unblocked from network");
                        BufferedMediaPlayer.this.mIsBlocking = false;
                        BufferedMediaPlayer.this.runOnBlockingChanged();
                        BufferedMediaPlayer.this.mPlayer.start();
                        if (BufferedMediaPlayer.this.mStatistics != null) {
                            BufferedMediaPlayer.this.mStatistics.markPlay(BufferedMediaPlayer.this.mContext);
                        }
                    }
                }
                BufferedMediaPlayer.this.tryToChangeDataSource(2000);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.e(BufferedMediaPlayer.TAG, MetaManager.UNKNOWN_STRING, e);
                }
            }
            BufferedMediaPlayer.this.tryToChangeDataSource(1000);
            if (BufferedMediaPlayer.this.mIsBlocking) {
                BufferedMediaPlayer.this.mIsBlocking = false;
                BufferedMediaPlayer.this.runOnBlockingChanged();
                if (BufferedMediaPlayer.this.mStatus != 0) {
                    BufferedMediaPlayer.this.mPlayer.start();
                    if (BufferedMediaPlayer.this.mStatistics != null) {
                        BufferedMediaPlayer.this.mStatistics.markPlay(BufferedMediaPlayer.this.mContext);
                    }
                }
            }
            synchronized (BufferedMediaPlayer.this.mListenerLock) {
                if (BufferedMediaPlayer.this.mStatus == 4 && !BufferedMediaPlayer.isRemoveAfterPlay(BufferedMediaPlayer.this.mContext) && BufferedMediaPlayer.this.mCurrentFile != null && BufferedMediaPlayer.this.mCurrentBytes > FileUtil.ONE_MB) {
                    String appointName = BufferedMediaPlayer.this.mRemoteMediaInfo.mAppointName;
                    BufferedMediaPlayer.this.setDownloadSuccess(BufferedMediaPlayer.this.mContext, appointName);
                    int bitRate = BufferedMediaPlayer.this.getAudioBitRate(BufferedMediaPlayer.this.mCurrentFile);
                    Log.d(BufferedMediaPlayer.TAG, "bitRate:" + bitRate);
                    File dst = new File(StorageConfig.getMp3Dir(StorageConfig.getMusicType(bitRate), true), appointName);
                    if (!dst.exists()) {
                        BufferedMediaPlayer.copyFile(BufferedMediaPlayer.this.mCurrentFile, dst);
                        BufferedMediaPlayer.this.runOnDownloadCompleted(BufferedMediaPlayer.this.mRemoteMediaInfo);
                    }
                }
            }
            BufferedMediaPlayer.this.runOnBufferedPositionChanged(BufferedMediaPlayer.this.getBufferdPercent());
            if (BufferedMediaPlayer.this.mStatus == 4 && BufferedMediaPlayer.this.needPrepare()) {
                BufferedMediaPlayer.this.mRunnableList.add(BufferedMediaPlayer.TAG, BufferedMediaPlayer.this.mDownloadNextRunnable, 5000);
            }
            BufferedMediaPlayer.this.mListenerThread = null;
        }
    }

    public static class RemoteControlInfo {
        public final OnBlockingChangedListener mBlockingChangedListener;
        public final OnBufferedPositionChangedListener mBufferedPositionChangedListener;
        public final OnDownloadCompletedListener mDownloadCompletedListener;
        public final Handler mHandler;

        public RemoteControlInfo(Handler handler, OnDownloadCompletedListener downloadCompletedListener, OnBlockingChangedListener blockingChangedListener, OnBufferedPositionChangedListener bufferedPositionChangedListener) {
            this.mHandler = handler;
            this.mDownloadCompletedListener = downloadCompletedListener;
            this.mBlockingChangedListener = blockingChangedListener;
            this.mBufferedPositionChangedListener = bufferedPositionChangedListener;
        }

        public boolean isValid() {
            return this.mHandler != null;
        }
    }

    static class SafeMediaPlayer extends PlayerProxy {
        private Uri mCurrentUri;

        public SafeMediaPlayer(String dir, String[] nameArr) {
            Set<String> set = null;
            if (nameArr != null) {
                set = new HashSet(nameArr.length);
                for (String str : nameArr) {
                    set.add(new File(dir, str).getAbsolutePath());
                }
            }
            setFFMPEGExcludeFilePathSet(set);
        }

        public void setDataSourceAndPrepare(Context context, Uri uri) throws IOException {
            super.setDataSourceAndPrepare(context, uri);
            this.mCurrentUri = uri;
        }

        public void release() {
            this.mCurrentUri = null;
            super.release();
        }

        public void reset() {
            this.mCurrentUri = null;
            super.reset();
        }

        public int getDuration() {
            if (this.mCurrentUri != null) {
                try {
                    return super.getDuration();
                } catch (Exception e) {
                }
            }
            return 1;
        }

        public int getCurrentPosition() {
            if (this.mCurrentUri != null) {
                try {
                    return super.getCurrentPosition();
                } catch (Exception e) {
                }
            }
            return 0;
        }

        public boolean isPlaying() {
            if (this.mCurrentUri != null) {
                try {
                    return super.isPlaying();
                } catch (Exception e) {
                }
            }
            return false;
        }

        public String getPath(Context context) {
            Uri uri = SqlUtils.translateToFileUri(context, this.mCurrentUri);
            if (uri == null || !"file".equals(uri.getScheme())) {
                return null;
            }
            return uri.getPath();
        }
    }

    public interface ShowLinkListener {
        void onLinkChanged(String str);
    }

    public BufferedMediaPlayer(RunnableList runnableList) {
        this.mRunnableList = runnableList;
        this.mTempDir = TEMP_DIR;
        this.mDownloadNextRunnable = new DownloadNextRunnable(this.mRunnableList, this.mTempDir);
        this.mPlayer = new SafeMediaPlayer(this.mTempDir, getTempFileNameArr());
    }

    public void setTempId(int id, boolean isFirst) {
        assertId(id);
        this.mTempId = id;
        this.mIsFirst = isFirst;
    }

    public int getNextId() {
        int i = 0;
        while (i < TEMP_FILE_ID_ARR.length && this.mTempId != TEMP_FILE_ID_ARR[i]) {
            i++;
        }
        i++;
        if (i >= TEMP_FILE_ID_ARR.length) {
            i = 0;
        }
        return TEMP_FILE_ID_ARR[i];
    }

    public void prepareDirectly(Context context, RemoteControlInfo remoteControlInfo, Uri uri, String nextMediaId) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        resetMediaInfo(context);
        this.mRemoteControlInfo = remoteControlInfo;
        this.mNextMediaId = nextMediaId;
        this.mContext = context;
        if (this.mStatistics == null) {
            this.mStatistics = new OnlinePlayStatstics(null);
            this.mStatistics.makeLocalStatstics(context, uri);
        }
        if (remoteControlInfo != null && remoteControlInfo.isValid()) {
            this.mDownloadNextRunnable.initialize(context, remoteControlInfo.mHandler, nextMediaId, getTempFileName(getNextId()), getNextId());
        }
        this.mStatus = 1;
        this.mPlayer.setDataSourceAndPrepare(context, uri);
        this.mBytesLastSet = 2147483647L;
        this.mStatus = 2;
        if (needPrepare()) {
            this.mRunnableList.add(TAG, this.mDownloadNextRunnable, 5000);
        }
    }

    public void prepareWithBuffer(Context context, RemoteControlInfo remoteControlInfo, RemoteMediaInfo remoteMediaInfo, String nextMediaId) throws IOException, InterruptedException {
        if (remoteControlInfo == null || !remoteControlInfo.isValid() || remoteMediaInfo == null || !remoteMediaInfo.isValid()) {
            throw new IllegalArgumentException(TAG + "  prepareRemote  ");
        }
        this.mStatistics = null;
        String appointName = remoteMediaInfo.mAppointName;
        File localMedia = findExistFile(getMp3DirList(StorageConfig.getMusicType(PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_TRACK_BIT_RATE).intValue())), appointName);
        Uri storageUri = DownloadProviderProxy.queryRunning(context, remoteMediaInfo.mId);
        Uri cacheUri = null;
        if (localMedia.exists() && storageUri == null) {
            prepareDirectly(context, remoteControlInfo, Uri.fromFile(localMedia), nextMediaId);
            Utils.debugLog(TAG, "track has been downloaded completed, local play !");
            return;
        }
        String name = getTempFileName(this.mTempId);
        if (!this.mIsFirst) {
            OnlinePlayStatstics readyStastics = sGlobalStastics;
            sGlobalStastics = null;
            if (readyStastics == null || !TextUtils.equals(readyStastics.getOnlineId(), remoteMediaInfo.mId)) {
                this.mStatistics = new OnlinePlayStatstics(remoteMediaInfo.mId);
            } else {
                this.mStatistics = readyStastics;
                this.mStatistics.markInitTime();
            }
            this.mStatistics.startChecking(context, remoteControlInfo.mHandler);
            localMedia = getFile(this.mTempDir, name);
            if (localMedia != null) {
                cacheUri = DownloadProviderProxy.queryRunning(context, name);
            }
            if (localMedia != null && cacheUri == null) {
                boolean renamed = false;
                if (!isRemoveAfterPlay(context) && localMedia.length() > FileUtil.ONE_MB) {
                    int localBitRate = getAudioBitRate(localMedia);
                    Log.d(TAG, "localBitRate:" + localBitRate);
                    File file = new File(StorageConfig.getMp3Dir(StorageConfig.getMusicType(localBitRate), true), appointName);
                    if (!file.exists()) {
                        localMedia = copyFile(localMedia, file);
                        renamed = true;
                    }
                    setDownloadSuccess(context, appointName);
                }
                try {
                    prepareDirectly(context, remoteControlInfo, Uri.fromFile(localMedia), nextMediaId);
                    if (renamed) {
                        runOnDownloadCompleted(remoteMediaInfo);
                    }
                    Utils.debugLog(TAG, "track has been prepared success, local play");
                    this.mStatistics.markConnectSuccess();
                    return;
                } catch (Exception e) {
                    if (renamed) {
                        localMedia.delete();
                    }
                }
            }
        }
        resetMediaInfo(context);
        this.mContext = context;
        if (this.mStatistics == null) {
            this.mStatistics = new OnlinePlayStatstics(remoteMediaInfo.mId);
            this.mStatistics.startChecking(context, remoteControlInfo.mHandler);
        }
        Pair<AudioDetail, List<AudioLink>> audio = getPlayerHelper().requestAudioDetail(context, remoteMediaInfo.mId);
        if (audio == null || audio.second == null) {
            this.mStatistics.setError(4);
            postStastics();
            throw new IOException("online play failed ! maybe no candidate exists");
        }
        AudioLink link;
        String showlink = null;
        if (audio.first != null) {
            getDownloader().updateDB(context, remoteMediaInfo.mId, (AudioDetail) audio.first);
            int resourceType = ((AudioDetail) audio.first).mResourceType;
            if ((resourceType == 2 || resourceType == 3) && !((List) audio.second).isEmpty()) {
                showlink = ((AudioLink) ((List) audio.second).get(0)).mShowLink;
            }
        }
        if (this.mShowLinkListener != null) {
            this.mShowLinkListener.onLinkChanged(showlink);
        }
        List<AudioLink> candidates = audio.second;
        remoteMediaInfo.mCandidates = candidates;
        this.mRemoteMediaInfo = remoteMediaInfo;
        this.mRemoteControlInfo = remoteControlInfo;
        this.mNextMediaId = nextMediaId;
        this.mDownloadObserver = new BufferContentObserver(remoteControlInfo.mHandler);
        this.mDownloadNextRunnable.initialize(context, remoteControlInfo.mHandler, nextMediaId, getTempFileName(getNextId()), getNextId());
        int len = candidates.size();
        int currentTryIdx = 0;
        boolean isSuccess = false;
        if (cacheUri != null) {
            this.mDownloadingUri = cacheUri;
            Utils.debugLog(TAG, "track is preparing");
        } else {
            while (currentTryIdx < len && this.mDownloadingUri == null) {
                link = (AudioLink) candidates.get(currentTryIdx);
                if (link != null) {
                    this.mStatistics.setAudioLink(this.mContext, link);
                    this.mDownloadingUri = DownloadProviderProxy.start(context, link, DownloadProviderProxy.wrapPlayingTag(remoteMediaInfo.mId, this.mTempId), this.mRemoteMediaInfo.mDetails, name, this.mTempDir, null, false, 5000);
                }
                currentTryIdx++;
            }
            Utils.debugLog(TAG, "track isnot prepared");
        }
        if (this.mDownloadingUri != null) {
            isSuccess = downloadAndPrepare();
        }
        for (currentTryIdx++; currentTryIdx < len && !isSuccess; currentTryIdx++) {
            link = (AudioLink) candidates.get(currentTryIdx);
            if (link != null) {
                this.mStatistics.setAudioLink(this.mContext, link);
                this.mDownloadingUri = DownloadProviderProxy.start(context, link, DownloadProviderProxy.wrapPlayingTag(remoteMediaInfo.mId, this.mTempId), this.mRemoteMediaInfo.mDetails, name, this.mTempDir, null, false, 5000);
                if (this.mDownloadingUri != null) {
                    isSuccess = downloadAndPrepare();
                }
            }
        }
        if (this.mStatus == 0) {
            this.mStatus = 3;
        }
        if (this.mStatus == 3) {
            postStastics();
            throw new IOException(TAG + " download remote media failed!");
        }
    }

    private static File getFile(String dir, String name) {
        File file = new File(dir, name);
        return file.exists() ? file : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean downloadAndPrepare() throws InterruptedException {
        /*
        r11 = this;
        r6 = 0;
        r9 = 1;
        r5 = 0;
        r10 = 3;
        r3 = 0;
        r11.mBitrate = r5;
        r11.mTotalBytes = r6;
        r11.mCurrentBytes = r6;
        r11.mStatus = r9;
        r11.mIsBlocking = r9;
        r11.runOnBlockingChanged();
        r6 = r11.mContext;
        r7 = r11.mDownloadingUri;
        r8 = r11.mDownloadObserver;
        r6 = com.miui.player.download.DownloadProviderProxy.registerDownloadObserver(r6, r7, r9, r8);
        if (r6 != 0) goto L_0x0022;
    L_0x001f:
        r11.mStatus = r10;
    L_0x0021:
        return r5;
    L_0x0022:
        r4 = 0;
        r2 = 0;
    L_0x0024:
        r6 = 60;
        if (r2 < r6) goto L_0x0032;
    L_0x0028:
        r6 = r11.mCurrentBytes;
        r8 = (long) r2;
        r6 = r6 / r8;
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x007b;
    L_0x0032:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);
        r6 = r11.mStatus;
        r7 = 2;
        if (r6 == r7) goto L_0x0041;
    L_0x003c:
        r6 = r11.mStatus;
        r7 = 4;
        if (r6 != r7) goto L_0x00b3;
    L_0x0041:
        r6 = r11.mTempDir;
        r7 = r11.mTempId;
        r7 = getTempFileName(r7);
        r1 = getFile(r6, r7);
        if (r1 == 0) goto L_0x00b1;
    L_0x004f:
        r6 = r11.mTotalBytes;	 Catch:{ Exception -> 0x00ad }
        r11.ensureFileSpace(r1, r6);	 Catch:{ Exception -> 0x00ad }
        r6 = r11.mPlayer;	 Catch:{ Exception -> 0x00ad }
        r7 = r11.mContext;	 Catch:{ Exception -> 0x00ad }
        r8 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x00ad }
        r6.setDataSourceAndPrepare(r7, r8);	 Catch:{ Exception -> 0x00ad }
        r6 = r11.mCurrentBytes;	 Catch:{ Exception -> 0x00ad }
        r11.mBytesLastSet = r6;	 Catch:{ Exception -> 0x00ad }
    L_0x0063:
        r6 = r11.mStatus;
        if (r6 == r10) goto L_0x00b3;
    L_0x0067:
        r11.mCurrentFile = r1;
        r11.mIsBlocking = r5;
        r11.runOnBlockingChanged();
        r5 = new com.miui.player.asyncplayer.BufferedMediaPlayer$PlayListenerTask;
        r5.<init>();
        r11.mListenerThread = r5;
        r5 = r11.mListenerThread;
        r5.start();
        r3 = 1;
    L_0x007b:
        if (r3 != 0) goto L_0x00c9;
    L_0x007d:
        r11.mStatus = r10;
        r5 = r11.mContext;
        r6 = r11.mDownloadObserver;
        com.miui.player.download.DownloadProviderProxy.unregisterDownloadObserver(r5, r6);
        r5 = r11.mContext;
        r6 = r11.mDownloadingUri;
        com.miui.player.download.DownloadProviderProxy.deleteByUri(r5, r6);
        if (r4 == 0) goto L_0x00bf;
    L_0x008f:
        r11.postStastics();
        r5 = new java.lang.InterruptedException;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = TAG;
        r6 = r6.append(r7);
        r7 = " user interrupt prepare";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r5.<init>(r6);
        throw r5;
    L_0x00ad:
        r0 = move-exception;
        r11.mStatus = r10;
        goto L_0x0063;
    L_0x00b1:
        r11.mStatus = r10;
    L_0x00b3:
        r4 = r11.mInterrupt;
        r6 = r11.mStatus;
        if (r6 == r10) goto L_0x007b;
    L_0x00b9:
        if (r4 != 0) goto L_0x007b;
    L_0x00bb:
        r2 = r2 + 1;
        goto L_0x0024;
    L_0x00bf:
        r5 = r11.mStatistics;
        if (r5 == 0) goto L_0x00c9;
    L_0x00c3:
        r5 = r11.mStatistics;
        r6 = 5;
        r5.setError(r6);
    L_0x00c9:
        r5 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.asyncplayer.BufferedMediaPlayer.downloadAndPrepare():boolean");
    }

    public boolean isPreparing() {
        return this.mStatus == 1;
    }

    public void interrupt() {
        this.mInterrupt = true;
    }

    public void togglePause(int type) {
        this.mTogglePause = type;
    }

    public int getCurrentPosition() {
        try {
            return this.mPlayer.getCurrentPosition();
        } catch (Exception e) {
            return 0;
        }
    }

    public float getBufferdPercent() {
        if (this.mDownloadingUri == null) {
            return ShakeListener.ACCELATION_FACTOR_X;
        }
        if (this.mTotalBytes > 0) {
            return ((float) this.mCurrentBytes) / ((float) this.mTotalBytes);
        }
        return 0.0f;
    }

    public int getDuration() {
        int duration = 1;
        if (this.mDownloadingUri == null || this.mCurrentFile != null) {
            try {
                duration = this.mPlayer.getDuration();
            } catch (Exception e) {
            }
        }
        return duration;
    }

    public String getPlayingFilePath() {
        Context context = this.mContext;
        return context != null ? this.mPlayer.getPath(context) : null;
    }

    public boolean isPlaying() {
        return this.mIsBlocking || this.mPlayer.isPlaying();
    }

    public boolean isBlocking() {
        return this.mIsBlocking;
    }

    public void setOnCompletionListener(final OnCompletionListener l) {
        this.mPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if (!(BufferedMediaPlayer.this.mStatistics == null || BufferedMediaPlayer.this.mContext == null)) {
                    BufferedMediaPlayer.this.mStatistics.setAutoSkip(true);
                }
                if (l != null) {
                    l.onCompletion(mp);
                }
            }
        });
    }

    public void setOnErrorListener(OnErrorListener l) {
        this.mPlayer.setOnErrorListener(l);
    }

    public void seekTo(int msec) {
        synchronized (this.mListenerLock) {
            if (hasBuffered(msec + PLAYER_CACHE_MSEC)) {
                if (needChangeDataSource(this.mContext) && isPlaybackMarkReached((long) msec)) {
                    changeDataSource(this.mCurrentFile, msec);
                }
                this.mPlayer.seekTo(msec);
            }
        }
    }

    public void start() {
        synchronized (this.mListenerLock) {
            if (!this.mIsBlocking && hasBuffered(getCurrentPosition() + PLAYER_CACHE_MSEC)) {
                this.mPlayer.start();
                if (this.mStatistics != null) {
                    this.mStatistics.markPlay(this.mContext);
                    if (this.mStatistics.getTotleDuration() <= 0) {
                        this.mStatistics.setTotleDuration((long) getDuration());
                    }
                }
                fadeIn();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fadeIn() {
        /*
        r7 = this;
        r6 = 2;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r7.mListenerLock;
        monitor-enter(r2);
        r1 = r7.mContext;	 Catch:{ all -> 0x0042 }
        r1 = isFadeEffectActive(r1);	 Catch:{ all -> 0x0042 }
        if (r1 != 0) goto L_0x0019;
    L_0x000e:
        r1 = r7.mPlayer;	 Catch:{ all -> 0x0042 }
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.setVolume(r3, r4);	 Catch:{ all -> 0x0042 }
        monitor-exit(r2);	 Catch:{ all -> 0x0042 }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r7.mPlayer;	 Catch:{ all -> 0x0042 }
        r3 = sVolume;	 Catch:{ all -> 0x0042 }
        r4 = sVolume;	 Catch:{ all -> 0x0042 }
        r1.setVolume(r3, r4);	 Catch:{ all -> 0x0042 }
        r1 = 2;
        r7.mTogglePause = r1;	 Catch:{ all -> 0x0042 }
        r0 = 0;
    L_0x0026:
        r1 = sVolume;	 Catch:{ all -> 0x0042 }
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 >= 0) goto L_0x0031;
    L_0x002c:
        r1 = r7.mTogglePause;	 Catch:{ all -> 0x0042 }
        if (r1 == r6) goto L_0x0045;
    L_0x0030:
        r0 = 1;
    L_0x0031:
        if (r0 != 0) goto L_0x0040;
    L_0x0033:
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        sVolume = r1;	 Catch:{ all -> 0x0042 }
        r1 = r7.mPlayer;	 Catch:{ all -> 0x0042 }
        r3 = sVolume;	 Catch:{ all -> 0x0042 }
        r4 = sVolume;	 Catch:{ all -> 0x0042 }
        r1.setVolume(r3, r4);	 Catch:{ all -> 0x0042 }
    L_0x0040:
        monitor-exit(r2);	 Catch:{ all -> 0x0042 }
        goto L_0x0018;
    L_0x0042:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0042 }
        throw r1;
    L_0x0045:
        r1 = r7.mPlayer;	 Catch:{ all -> 0x0042 }
        r3 = sVolume;	 Catch:{ all -> 0x0042 }
        r4 = sVolume;	 Catch:{ all -> 0x0042 }
        r1.setVolume(r3, r4);	 Catch:{ all -> 0x0042 }
        r3 = 10;
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x005c }
    L_0x0053:
        r1 = sVolume;	 Catch:{ all -> 0x0042 }
        r3 = 1008981770; // 0x3c23d70a float:0.01 double:4.9850323E-315;
        r1 = r1 + r3;
        sVolume = r1;	 Catch:{ all -> 0x0042 }
        goto L_0x0026;
    L_0x005c:
        r1 = move-exception;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.asyncplayer.BufferedMediaPlayer.fadeIn():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fadeOut() {
        /*
        r8 = this;
        r7 = 1;
        r4 = r8.mListenerLock;
        monitor-enter(r4);
        r3 = sFadeOutMode;	 Catch:{ all -> 0x0021 }
        r5 = 2;
        if (r3 != r5) goto L_0x000e;
    L_0x0009:
        r3 = 0;
        sFadeOutMode = r3;	 Catch:{ all -> 0x0021 }
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
    L_0x000d:
        return;
    L_0x000e:
        r3 = r8.mContext;	 Catch:{ all -> 0x0021 }
        r3 = isFadeEffectActive(r3);	 Catch:{ all -> 0x0021 }
        if (r3 != 0) goto L_0x0024;
    L_0x0016:
        r3 = r8.mPlayer;	 Catch:{ all -> 0x0021 }
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3.setVolume(r5, r6);	 Catch:{ all -> 0x0021 }
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
        goto L_0x000d;
    L_0x0021:
        r3 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
        throw r3;
    L_0x0024:
        r3 = 1;
        r8.mTogglePause = r3;	 Catch:{ all -> 0x0021 }
        r2 = 0;
        r0 = 1022739087; // 0x3cf5c28f float:0.03 double:5.053002475E-315;
        r1 = 10;
        r3 = sFadeOutMode;	 Catch:{ all -> 0x0021 }
        if (r3 != r7) goto L_0x0039;
    L_0x0031:
        r3 = 0;
        sFadeOutMode = r3;	 Catch:{ all -> 0x0021 }
        r0 = 981668463; // 0x3a83126f float:0.001 double:4.85008663E-315;
        r1 = 10;
    L_0x0039:
        r3 = sVolume;	 Catch:{ all -> 0x0021 }
        r5 = 0;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x0045;
    L_0x0040:
        r3 = r8.mTogglePause;	 Catch:{ all -> 0x0021 }
        if (r3 == r7) goto L_0x0057;
    L_0x0044:
        r2 = 1;
    L_0x0045:
        if (r2 != 0) goto L_0x0055;
    L_0x0047:
        r3 = 1008981770; // 0x3c23d70a float:0.01 double:4.9850323E-315;
        sVolume = r3;	 Catch:{ all -> 0x0021 }
        r3 = r8.mPlayer;	 Catch:{ all -> 0x0021 }
        r5 = sVolume;	 Catch:{ all -> 0x0021 }
        r6 = sVolume;	 Catch:{ all -> 0x0021 }
        r3.setVolume(r5, r6);	 Catch:{ all -> 0x0021 }
    L_0x0055:
        monitor-exit(r4);	 Catch:{ all -> 0x0021 }
        goto L_0x000d;
    L_0x0057:
        r3 = r8.mPlayer;	 Catch:{ all -> 0x0021 }
        r5 = sVolume;	 Catch:{ all -> 0x0021 }
        r6 = sVolume;	 Catch:{ all -> 0x0021 }
        r3.setVolume(r5, r6);	 Catch:{ all -> 0x0021 }
        r5 = (long) r1;
        java.lang.Thread.sleep(r5);	 Catch:{ InterruptedException -> 0x006a }
    L_0x0064:
        r3 = sVolume;	 Catch:{ all -> 0x0021 }
        r3 = r3 - r0;
        sVolume = r3;	 Catch:{ all -> 0x0021 }
        goto L_0x0039;
    L_0x006a:
        r3 = move-exception;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.asyncplayer.BufferedMediaPlayer.fadeOut():void");
    }

    public static long getLongFadeOutTime() {
        return 9990;
    }

    public void pause() {
        synchronized (this.mListenerLock) {
            this.mIsBlocking = false;
            runOnBlockingChanged();
            fadeOut();
            this.mPlayer.pause();
            if (this.mStatistics != null) {
                this.mStatistics.markPause();
            }
        }
    }

    public void reset(boolean stopNextDownload) {
        this.mBytesLastSet = 0;
        synchronized (this.mBufferLock) {
            this.mStatus = 0;
        }
        if (this.mDownloadObserver != null) {
            DownloadProviderProxy.unregisterDownloadObserver(this.mContext, this.mDownloadObserver);
            this.mDownloadObserver = null;
        }
        if (this.mDownloadingUri != null) {
            DownloadProviderProxy.deleteByUri(this.mContext, this.mDownloadingUri);
            this.mDownloadingUri = null;
        }
        fadeOut();
        this.mPlayer.reset();
        if (stopNextDownload && getPlayerHelper().isValidGlobalId(this.mNextMediaId)) {
            cancelPrepare(true);
        } else {
            this.mDownloadNextRunnable.detach();
        }
        if (this.mContext != null && this.mStatistics != null) {
            postStastics();
        }
    }

    public void release(Context context, boolean stopNextDownload) {
        reset(stopNextDownload);
        int id = this.mPlayer.getAudioSessionId();
        this.mPlayer.release();
        if (id != -1) {
            Intent i = new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
            i.putExtra("android.media.extra.AUDIO_SESSION", id);
            i.putExtra("android.media.extra.PACKAGE_NAME", context.getPackageName());
            context.sendBroadcast(i);
        }
    }

    public void setAudioStreamType(int streamtype) {
        this.mPlayer.setAudioStreamType(streamtype);
    }

    public void cancelPrepare(boolean abort) {
        this.mNextMediaId = null;
        if (abort) {
            this.mDownloadNextRunnable.abort();
        } else {
            this.mDownloadNextRunnable.detach();
        }
    }

    void changeDataSource(File dst, int msec) {
        if (dst != null) {
            synchronized (this.mListenerLock) {
                try {
                    ensureFileSpace(dst, this.mTotalBytes);
                    boolean isPlaying = this.mPlayer.isPlaying();
                    int pos = this.mPlayer.getCurrentPosition();
                    this.mPlayer.reset();
                    this.mPlayer.setDataSourceAndPrepare(this.mContext, Uri.fromFile(dst));
                    Log.i(TAG, "change data source as " + dst);
                    this.mBytesLastSet = this.mCurrentBytes;
                    if (msec < 0 || this.mPlayer.getDuration() < msec) {
                        this.mPlayer.seekTo(pos);
                    } else {
                        this.mPlayer.seekTo(msec);
                    }
                    if (isPlaying) {
                        this.mPlayer.start();
                    }
                } catch (IllegalArgumentException e) {
                } catch (SecurityException e2) {
                } catch (IllegalStateException e3) {
                } catch (IOException e4) {
                }
            }
        }
    }

    private void ensureFileSpace(File f, long space) throws IOException {
        Throwable th;
        if (f.length() < space) {
            RandomAccessFile raf = null;
            try {
                RandomAccessFile raf2 = new RandomAccessFile(f, "rw");
                try {
                    raf2.setLength(space);
                    if (raf2 != null) {
                        raf2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    raf = raf2;
                    if (raf != null) {
                        raf.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (raf != null) {
                    raf.close();
                }
                throw th;
            }
        }
    }

    boolean hasBuffered(int msec) {
        if (this.mBitrate <= 0 || this.mCurrentFile == null) {
            return true;
        }
        if ((this.mTotalBytes <= 0 || this.mCurrentBytes != this.mTotalBytes) && getBufferdPercent() * ((float) getDuration()) <= ((float) msec)) {
            return false;
        }
        return true;
    }

    private void resetMediaInfo(Context context) {
        deleteRecord(context, getTempFileName(getNextId()), this.mRunnableList);
        this.mRemoteMediaInfo = null;
        this.mNextMediaId = null;
        this.mDownloadingUri = null;
        this.mCurrentFile = null;
        this.mStatus = 0;
        this.mTotalBytes = 0;
        this.mCurrentBytes = 0;
        this.mBitrate = 0;
        this.mIsBlocking = false;
        this.mInterrupt = false;
        this.mListenerThread = null;
    }

    void postStastics() {
        OnlinePlayStatstics stat = this.mStatistics;
        if (stat != null) {
            stat.post(this.mContext);
            stat.postSkipStastics(this.mContext);
            stat.stopChecking();
            this.mStatistics = null;
        }
    }

    void runOnDownloadCompleted(RemoteMediaInfo mediaInfo) {
        if (this.mRemoteControlInfo != null && mediaInfo != null) {
            final OnDownloadCompletedListener l = this.mRemoteControlInfo.mDownloadCompletedListener;
            final String id = mediaInfo.mId;
            final String appointName = mediaInfo.mAppointName;
            final String details = mediaInfo.mDetails;
            this.mRemoteControlInfo.mHandler.post(new Runnable() {
                public void run() {
                    if (l != null) {
                        l.onDownloadCompleted(BufferedMediaPlayer.this.mContext, id, appointName, details);
                    }
                    BufferedMediaPlayer.this.mContext.sendBroadcast(new Intent(Actions.ACTION_ONLINE_DOWNLOAD_COMPLETE));
                }
            });
        }
    }

    void runOnBlockingChanged() {
        if (this.mRemoteControlInfo != null) {
            final OnBlockingChangedListener l = this.mRemoteControlInfo.mBlockingChangedListener;
            if (l != null) {
                this.mRemoteControlInfo.mHandler.post(new Runnable() {
                    public void run() {
                        l.onBlockingChanged(BufferedMediaPlayer.this.mIsBlocking);
                    }
                });
            }
        }
    }

    void runOnBufferedPositionChanged(final float bufferedPer) {
        if (this.mRemoteControlInfo != null) {
            final OnBufferedPositionChangedListener l = this.mRemoteControlInfo.mBufferedPositionChangedListener;
            if (l != null) {
                this.mRemoteControlInfo.mHandler.post(new Runnable() {
                    public void run() {
                        l.onBufferedPositionChanged(bufferedPer);
                    }
                });
            }
        }
    }

    void setDownloadSuccess(Context context, String appointName) {
        synchronized (this.mListenerLock) {
            final String[] args = new String[]{Uri.fromFile(new File(this.mTempDir, appointName)).toString()};
            String where = "hint = ?";
            final ContentValues cv = new ContentValues();
            cv.put("status", Integer.valueOf(200));
            final ContentResolver res = context.getContentResolver();
            if (this.mRemoteControlInfo == null || isTempFileName(appointName)) {
                res.update(Impl.CONTENT_URI, cv, "hint = ?", args);
            } else {
                this.mRemoteControlInfo.mHandler.post(new Runnable() {
                    public void run() {
                        res.update(Impl.CONTENT_URI, cv, "hint = ?", args);
                    }
                });
            }
        }
    }

    static void deleteRecord(Context context, String appointName, RunnableList runnableList) {
        try {
            runnableList.remove(TAG);
            DownloadProviderProxy.deleteByAppointName(context, appointName);
        } catch (Exception e) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
        }
    }

    boolean needPrepare() {
        return getPlayerHelper().isValidGlobalId(this.mNextMediaId) && this.mStatus != 0 && this.mDownloadNextRunnable.needDownload();
    }

    static File copyFile(File srcFile, File dstFile) {
        if (dstFile.exists()) {
            dstFile.delete();
        }
        FileOperations.copyFile(srcFile.getAbsolutePath(), dstFile.getAbsolutePath());
        return dstFile;
    }

    static boolean isRemoveAfterPlay(Context context) {
        return (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_PLAY_AND_DOWNLOAD) && Utils.isExternalStorageMounted()) ? false : true;
    }

    private static boolean isFadeEffectActive(Context context) {
        if (context == null) {
            return true;
        }
        if (!PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FADE_EFFECT_ACTIVE) || PreferenceCache.IS_LPA_DECODE) {
            return false;
        }
        return true;
    }

    private static void assertId(int id) {
        int[] arr$ = TEMP_FILE_ID_ARR;
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            if (arr$[i$] != id) {
                i$++;
            } else {
                return;
            }
        }
        throw new IllegalStateException("bad temp file id " + id);
    }

    static boolean isTempFileName(String fileName) {
        String[] tempArr = getTempFileNameArr();
        for (String equals : tempArr) {
            if (equals.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    private static String getTempFileName(int id) {
        assertId(id);
        return String.format(TEMP_MEDIA_NAME, new Object[]{Integer.valueOf(id)});
    }

    public static String[] getTempFileNameArr() {
        String[] ret = new String[TEMP_FILE_ID_ARR.length];
        for (int i = 0; i < TEMP_FILE_ID_ARR.length; i++) {
            ret[i] = getTempFileName(TEMP_FILE_ID_ARR[i]);
        }
        return ret;
    }

    public static int getDefaultTempId() {
        return TEMP_FILE_ID_ARR[0];
    }

    public static void setUp(RunnableList runnableList) {
        runnableList.remove(TAG);
    }

    public static void toggleFadeOutMode(int mode) {
        if (mode < 0 || mode > 2) {
            throw new IllegalArgumentException("bad mode for fade out mode");
        }
        sFadeOutMode = mode;
    }

    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    static boolean needChangeDataSource(Context context) {
        if (Build.IS_MITHREE_TDSCDMA) {
            return true;
        }
        return context != null ? context.getResources().getBoolean(C0329R.bool.need_change_data_source) : false;
    }

    boolean isPlaybackMarkReached(long current) {
        if (this.mBytesLastSet >= this.mTotalBytes) {
            return false;
        }
        if (this.mCurrentBytes >= this.mTotalBytes || current >= (this.mBytesLastSet * ((long) getDuration())) / this.mTotalBytes) {
            return true;
        }
        return false;
    }

    void tryToChangeDataSource(long diff) {
        if (needChangeDataSource(this.mContext)) {
            File f = this.mCurrentFile;
            if (isPlaybackMarkReached(((long) getCurrentPosition()) + diff)) {
                changeDataSource(f, -1);
            }
        }
    }

    static IDownloader getDownloader() {
        return ApplicationHelper.instance().getDownloader();
    }

    static IPlayerHelper getPlayerHelper() {
        return ApplicationHelper.instance().getPlayerHelper();
    }

    private int getAudioBitRate(File file) {
        int bitRate = 128;
        try {
            bitRate = AudioFileIO.read(file).getBitrate();
        } catch (CannotReadException e) {
            e.printStackTrace();
        }
        return bitRate;
    }

    private static ArrayList<String> getMp3DirList(String type) {
        ArrayList<String> leafPathList = new ArrayList();
        if (StorageConfig.META_TYPE_MP3.equals(type)) {
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3_UHD));
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3_HD));
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3));
        } else if (StorageConfig.META_TYPE_MP3_HD.equals(type)) {
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3_UHD));
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3_HD));
        } else if (StorageConfig.META_TYPE_MP3_UHD.equals(type)) {
            leafPathList.add(getLeafPath(StorageConfig.META_TYPE_MP3_UHD));
        }
        ArrayList<String> result = new ArrayList();
        Iterator i$ = leafPathList.iterator();
        while (i$.hasNext()) {
            result.addAll(StorageUtils.getAllSdcardFilePath((String) i$.next()));
        }
        return result;
    }

    private static String getLeafPath(String filename) {
        return StorageUtils.getLeafPath(StorageConfig.getMp3Dir(filename, false).getAbsolutePath());
    }

    private static File findExistFile(ArrayList<String> dirList, String appointName) {
        File file = null;
        Iterator i$ = dirList.iterator();
        while (i$.hasNext()) {
            file = new File((String) i$.next(), appointName);
            if (file.exists()) {
                return file;
            }
        }
        return file;
    }

    public void setShowLinkListener(ShowLinkListener listener) {
        this.mShowLinkListener = listener;
    }
}
