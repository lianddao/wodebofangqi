package com.miui.player.ffmpeg;

import android.media.AudioTrack;
import android.media.AudioTrack.OnPlaybackPositionUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.baidu.voicerecognition.android.VoiceRecognitionClient;
import com.miui.player.util.ServiceActions.In;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.MusicLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FFMPEGPlayer {
    private static final int BYTE_PER_FRAME = 2;
    public static final int ERROR_READ = 3;
    public static final int ERROR_WRITE = 4;
    private static final int PCM_DATA_DENO = 2;
    private static final int PCM_ENCODING = 2;
    public static final int READ_EOF = 2;
    private static final int REFILL_DENO = 8;
    public static final int SUCCESS = 0;
    private static final String TAG = "com.miui.player.ffmpeg.FFMPEGPlayer";
    public static final int YIELD = 1;
    private long mAlreadyPlayedByte = 0;
    private int mAudioSessionId = 0;
    private int mCachedPosition = 0;
    OnCompletionListener mCompletionListener;
    private final ExecutorService mDecodeThreadPool = Executors.newSingleThreadExecutor();
    OnErrorListener mErrorListener;
    private Handler mExternalHandler;
    private int mFrameSize = -1;
    private final Object mListenerLock = new Object();
    private byte[] mPCMData = null;
    private PCMProvider mPCMProvider;
    private final HandlerThread mPCMThread = new HandlerThread(TAG, -16);
    private AudioTrack mPCMTrack;
    OnPreparedListener mPreparedListener;
    private int mRefillMark = 0;
    private boolean mSeeking = false;
    private final int mStreamType;

    class C03491 implements Runnable {
        C03491() {
        }

        public void run() {
            FFMPEGPlayer.this.mPreparedListener.onPrepared(null);
        }
    }

    class C03513 implements Runnable {
        C03513() {
        }

        public void run() {
            FFMPEGPlayer.this.mCompletionListener.onCompletion(null);
        }
    }

    private static class PCMUpdateListener implements OnPlaybackPositionUpdateListener {
        private final WeakReference<FFMPEGPlayer> mPlayerRef;

        public PCMUpdateListener(FFMPEGPlayer player) {
            this.mPlayerRef = new WeakReference(player);
        }

        public void onMarkerReached(AudioTrack track) {
            FFMPEGPlayer player = (FFMPEGPlayer) this.mPlayerRef.get();
            if (player != null) {
                player.onMarkerReached(track);
            }
        }

        public void onPeriodicNotification(AudioTrack track) {
        }
    }

    private FFMPEGPlayer(int streamType, int audioSessionId) {
        this.mStreamType = streamType;
        this.mAudioSessionId = audioSessionId;
        Looper looper = Looper.myLooper();
        if (looper != null) {
            this.mExternalHandler = new Handler(looper);
        } else {
            looper = Looper.getMainLooper();
            if (looper != null) {
                this.mExternalHandler = new Handler(looper);
            } else {
                this.mExternalHandler = null;
            }
        }
        this.mPCMThread.start();
        while (!this.mPCMThread.isAlive()) {
            Thread.yield();
        }
    }

    public synchronized void setDataSource(File file) throws IOException {
        reset();
        this.mPCMProvider = createPCMProvider(file, this.mDecodeThreadPool);
    }

    public synchronized void prepare() throws IOException, IllegalArgumentException {
        Utils.debugLog(TAG, "prepare");
        openPCMProvider();
        openPCMTrack();
        this.mPCMTrack.setPlaybackPositionUpdateListener(new PCMUpdateListener(this), new Handler(this.mPCMThread.getLooper()));
        if (this.mPreparedListener != null) {
            if (this.mExternalHandler != null) {
                this.mExternalHandler.post(new C03491());
            } else {
                this.mPreparedListener.onPrepared(null);
            }
        }
    }

    public synchronized boolean start() {
        boolean z = false;
        synchronized (this) {
            Utils.debugLog(TAG, "start");
            if (this.mPCMTrack == null) {
                Log.e(TAG, "Start failed because PCM track is null");
            } else {
                try {
                    openPCMProvider();
                    if (this.mPCMTrack.getPlayState() == 1) {
                        this.mPCMTrack.setNotificationMarkerPosition(this.mRefillMark);
                        Log.d(TAG, "fill with silence before starting playback " + this.mRefillMark);
                        byte[] rawData = new byte[getAudioTrackBufferSize()];
                        Arrays.fill(rawData, (byte) 0);
                        this.mPCMTrack.write(rawData, 0, rawData.length);
                    }
                    this.mPCMTrack.play();
                    z = true;
                } catch (IOException e) {
                    Log.e(TAG, "Start failed because PCM provider open failed");
                }
            }
        }
        return z;
    }

    public void seekTo(int msec) {
        if (msec >= 0 && msec < getDuration()) {
            synchronized (this) {
                if (this.mPCMProvider != null) {
                    synchronized (this.mListenerLock) {
                        if (this.mPCMProvider.seek(msec) == 0) {
                            this.mCachedPosition = msec;
                            this.mSeeking = true;
                            this.mAlreadyPlayedByte = 0;
                        }
                    }
                }
            }
        }
    }

    public int getCurrentPosition() {
        return this.mCachedPosition;
    }

    public synchronized int getDuration() {
        int duration;
        if (this.mPCMProvider != null) {
            duration = this.mPCMProvider.getDuration();
        } else {
            duration = -1;
        }
        return duration;
    }

    public synchronized boolean isPlaying() {
        boolean z;
        z = this.mPCMTrack != null && this.mPCMTrack.getPlayState() == 3;
        return z;
    }

    public synchronized void pause() {
        if (this.mPCMTrack != null) {
            this.mPCMTrack.pause();
        }
    }

    public synchronized void stop() {
        Utils.debugLog(TAG, In.CMDSTOP);
        if (this.mPCMTrack != null && this.mPCMTrack.getState() == 1) {
            this.mPCMTrack.stop();
        }
    }

    public synchronized void reset() {
        Utils.debugLog(TAG, "reset");
        closePCMTrack();
        releasePCMProvider();
    }

    public synchronized void release() {
        reset();
        this.mPCMThread.quit();
        this.mDecodeThreadPool.shutdown();
        this.mPCMData = null;
        Utils.debugLog(TAG, "release ffmpeg player");
    }

    public synchronized void setVolume(float leftVolume, float rightVolume) {
        if (this.mPCMTrack != null) {
            this.mPCMTrack.setStereoVolume(leftVolume, rightVolume);
        }
    }

    public synchronized void setOnErrorListener(OnErrorListener l) {
        this.mErrorListener = l;
    }

    public synchronized void setOnCompletionListener(OnCompletionListener l) {
        this.mCompletionListener = l;
    }

    public synchronized void setOnPreparedListener(OnPreparedListener l) {
        this.mPreparedListener = l;
    }

    private void openPCMTrack() {
        closePCMTrack();
        synchronized (this.mListenerLock) {
            int len = getAudioTrackBufferSize();
            int channelConfig = getChannelConfig(this.mPCMProvider.getChannels());
            int sampleRate = this.mPCMProvider.getSampleRate();
            boolean createSuccess = false;
            for (int i = 0; i < 10 && !createSuccess; i++) {
                MusicLog.m395d(TAG, "Try to create AudioTrack, times=" + i);
                if (i > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                if (this.mAudioSessionId == 0) {
                    this.mPCMTrack = new AudioTrack(this.mStreamType, sampleRate, channelConfig, 2, len, 1);
                    this.mAudioSessionId = this.mPCMTrack.getAudioSessionId();
                } else {
                    this.mPCMTrack = new AudioTrack(this.mStreamType, sampleRate, channelConfig, 2, len, 1, this.mAudioSessionId);
                }
                if (this.mPCMTrack.getState() == 1) {
                    createSuccess = true;
                } else {
                    createSuccess = false;
                }
            }
            if (createSuccess) {
                MusicLog.m395d(TAG, "New AudioTrack, sessionId=" + this.mAudioSessionId + " status" + this.mPCMTrack.getState());
                this.mFrameSize = (this.mPCMTrack.getChannelCount() * this.mPCMTrack.getPlaybackRate()) * 2;
            } else {
                throw new IllegalArgumentException("Create AudioTrack failed");
            }
        }
    }

    private void closePCMTrack() {
        if (this.mPCMTrack != null) {
            this.mPCMTrack.setPlaybackPositionUpdateListener(null);
            if (this.mPCMTrack.getState() == 1) {
                this.mPCMTrack.stop();
            }
            synchronized (this.mListenerLock) {
                this.mPCMTrack.release();
                this.mPCMTrack = null;
            }
            this.mFrameSize = -1;
        }
    }

    private void openPCMProvider() throws IOException {
        if (this.mPCMProvider == null) {
            throw new IllegalStateException("com.miui.player.ffmpeg.FFMPEGPlayer Open PCM provider failed because it is null");
        }
        synchronized (this.mListenerLock) {
            if (this.mPCMProvider.isClosed()) {
                int ret = this.mPCMProvider.open();
                if (ret != 0) {
                    throw new IOException("com.miui.player.ffmpeg.FFMPEGPlayer Open PCM provider failed with ret=" + ret);
                }
                this.mAlreadyPlayedByte = 0;
                this.mCachedPosition = 0;
                this.mSeeking = false;
            }
            int len = getAudioTrackBufferSize();
            if (this.mPCMData == null || this.mPCMData.length != len / 2) {
                this.mPCMData = new byte[(len / 2)];
                this.mRefillMark = (AudioTrack.getMinBufferSize(this.mPCMProvider.getSampleRate(), getChannelConfig(this.mPCMProvider.getChannels()), 2) * 8) - 1;
            }
        }
    }

    private void closePCMProvider() {
        if (this.mPCMProvider != null) {
            synchronized (this.mListenerLock) {
                if (!this.mPCMProvider.isClosed()) {
                    this.mPCMProvider.close();
                }
            }
        }
    }

    private void releasePCMProvider() {
        if (this.mPCMProvider != null) {
            synchronized (this.mListenerLock) {
                if (!this.mPCMProvider.isClosed()) {
                    this.mPCMProvider.close();
                }
                this.mPCMProvider.release();
                this.mPCMProvider = null;
                this.mPCMData = null;
                this.mAlreadyPlayedByte = 0;
                this.mCachedPosition = 0;
                this.mSeeking = false;
            }
        }
    }

    private int getAudioTrackBufferSize() {
        if (this.mPCMProvider == null || this.mPCMProvider.isClosed()) {
            return 0;
        }
        return Math.max(AudioTrack.getMinBufferSize(this.mPCMProvider.getSampleRate(), getChannelConfig(this.mPCMProvider.getChannels()), 2) * 32, VoiceRecognitionClient.ERROR_NETWORK);
    }

    private synchronized void onError(final int error) {
        if (this.mErrorListener != null) {
            if (this.mExternalHandler != null) {
                this.mExternalHandler.post(new Runnable() {
                    public void run() {
                        if (!FFMPEGPlayer.this.mErrorListener.onError(null, error, 0)) {
                            FFMPEGPlayer.this.onCompletion();
                        }
                    }
                });
            } else if (!this.mErrorListener.onError(null, error, 0)) {
                onCompletion();
            }
        }
    }

    private synchronized void onCompletion() {
        stop();
        closePCMProvider();
        if (this.mCompletionListener != null) {
            if (this.mExternalHandler != null) {
                this.mExternalHandler.post(new C03513());
            } else {
                this.mCompletionListener.onCompletion(null);
            }
        }
    }

    void onMarkerReached(AudioTrack track) {
        int ret = 1;
        synchronized (this.mListenerLock) {
            if (track == this.mPCMTrack && track != null) {
                if (this.mPCMProvider == null || this.mPCMProvider.isClosed()) {
                    ret = 3;
                    Log.e(TAG, " Read failed because PCM provider is invalid");
                } else {
                    try {
                        Arrays.fill(this.mPCMData, (byte) 0);
                        if (this.mPCMProvider.read(this.mPCMData) >= 0) {
                            ret = 0;
                        } else {
                            ret = 2;
                        }
                    } catch (IOException e) {
                        ret = 3;
                        Log.e(TAG, " Read failed " + e.toString());
                    }
                }
                if (ret == 0) {
                    if (this.mPCMTrack.write(this.mPCMData, 0, this.mPCMData.length) < 0) {
                        ret = 4;
                    }
                    this.mAlreadyPlayedByte += (long) this.mPCMData.length;
                    this.mSeeking = false;
                }
                if (ret == 0) {
                    switch (this.mPCMTrack.getPlayState()) {
                        case 1:
                            ret = 1;
                            break;
                        case 2:
                            this.mPCMTrack.setNotificationMarkerPosition(this.mRefillMark);
                            ret = 1;
                            break;
                        case 3:
                            this.mPCMTrack.setNotificationMarkerPosition(this.mRefillMark);
                            break;
                        default:
                            break;
                    }
                }
            }
            Log.w(TAG, "Overdue track in thread " + Thread.currentThread());
        }
        synchronized (this) {
            if (!(this.mFrameSize <= 0 || this.mPCMTrack == null || this.mPCMProvider == null || this.mPCMProvider.isClosed() || this.mSeeking)) {
                this.mCachedPosition = this.mPCMProvider.getBaseFramePosition() + ((int) ((this.mAlreadyPlayedByte * 1000) / ((long) this.mFrameSize)));
            }
        }
        switch (ret) {
            case 1:
                Thread.yield();
                return;
            case 2:
                onCompletion();
                return;
            case 3:
            case 4:
                onError(ret);
                return;
            default:
                return;
        }
    }

    private static int getChannelConfig(int channel) {
        switch (channel) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 4:
                return 204;
            default:
                return 1;
        }
    }

    private static PCMProvider createPCMProvider(File file, ExecutorService executor) throws IOException {
        return new BufferedPCMProvider(new FFMPEGProvider(file), executor);
    }

    public static FFMPEGPlayer createFFMPEGPlayer(int streamType, int audioSessionId) {
        if (FFMPEGProvider.isNativeInitSuccess()) {
            return new FFMPEGPlayer(streamType, audioSessionId);
        }
        return null;
    }
}
