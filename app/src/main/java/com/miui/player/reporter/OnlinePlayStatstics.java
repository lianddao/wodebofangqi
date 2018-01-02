package com.miui.player.reporter;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.StorageConfig;
import java.lang.ref.WeakReference;

public class OnlinePlayStatstics {
    public static final long MIN_LOOP_TIME = 5000;
    public static final long PLAY_SUCCESS_TIME = 60000;
    static final String TAG = OnlinePlayStatstics.class.getName();
    private AudioLink mAudioLink;
    private Runnable mChecker;
    private Handler mHandler;
    private long mInitTime = SystemClock.uptimeMillis();
    private long mLastPlayTime = -1;
    private long mLinkStartTime;
    private OnlinePlayStatus mLogStatus;

    static class OnlinePlayChecker implements Runnable {
        private final Context mContext;
        private final Handler mHandler;
        private final WeakReference<OnlinePlayStatstics> mStatsticsRef;

        public OnlinePlayChecker(Context context, Handler handler, OnlinePlayStatstics stat) {
            this.mContext = context;
            this.mHandler = handler;
            this.mStatsticsRef = new WeakReference(stat);
        }

        public void run() {
            OnlinePlayStatstics stat = (OnlinePlayStatstics) this.mStatsticsRef.get();
            if (stat != null) {
                long remain = stat.checkPlayStatus(this.mContext);
                Log.e(OnlinePlayStatstics.TAG, "checking " + remain);
                if (remain > 0) {
                    this.mHandler.postDelayed(this, Math.max(OnlinePlayStatstics.MIN_LOOP_TIME, remain));
                }
            }
        }
    }

    public OnlinePlayStatstics(String onlineId) {
        this.mLogStatus = new OnlinePlayStatus(onlineId, 1);
        setTrackType(StorageConfig.META_TYPE_MP3);
        if (onlineId == null) {
            this.mLogStatus.mIsLocal = true;
        }
    }

    public String getOnlineId() {
        return this.mLogStatus.mOnlineId;
    }

    public void setLocal(boolean isLocal) {
        this.mLogStatus.mIsLocal = isLocal;
    }

    public void setTrackInfo(String trackName, String artistName, String albumName) {
        this.mLogStatus.mTrackName = trackName;
        this.mLogStatus.mArtistName = artistName;
        this.mLogStatus.mAlbumName = albumName;
    }

    public void setTrackType(String trackType) {
        this.mLogStatus.mTrackType = trackType != null ? trackType.toLowerCase() : "null";
    }

    public void setFileName(String fileName) {
        this.mLogStatus.mFileName = fileName;
    }

    public void setBitRate(int bitRate) {
        this.mLogStatus.mBitrate = bitRate;
    }

    public void setAudioLink(Context context, AudioLink link) {
        if (this.mAudioLink != null) {
            post(context);
        }
        this.mAudioLink = link;
        this.mLinkStartTime = SystemClock.uptimeMillis();
        this.mLastPlayTime = -1;
        this.mLogStatus = new OnlinePlayStatus(this.mLogStatus.mOnlineId, 1);
        this.mLogStatus.mBitrate = link.mBitrate;
        this.mLogStatus.mURL = link.mURL;
        this.mLogStatus.mError = 1;
    }

    public void markInitTime() {
        long current = SystemClock.uptimeMillis();
        this.mInitTime = current;
        this.mLinkStartTime = current;
    }

    public void markConnectSuccess() {
        this.mLogStatus.mConnectTimeInMs = SystemClock.uptimeMillis() - this.mLinkStartTime;
    }

    public void markBlocked() {
        OnlinePlayStatus onlinePlayStatus = this.mLogStatus;
        onlinePlayStatus.mBufferCount++;
    }

    public void markPlay(Context context) {
        if (this.mLastPlayTime == -1 && context != null) {
            OnlineMusicReporter.postOnlinePlayStatus(context, this.mLogStatus.getShotsnap(2));
        }
        this.mLogStatus.mError = 0;
        this.mLastPlayTime = SystemClock.uptimeMillis();
    }

    public void markPause() {
        if (this.mLastPlayTime > 0) {
            OnlinePlayStatus onlinePlayStatus = this.mLogStatus;
            onlinePlayStatus.mPlayDurationInMs += SystemClock.uptimeMillis() - this.mLastPlayTime;
            this.mLastPlayTime = 0;
        }
    }

    public void setError(int error) {
        this.mLogStatus.mError = error;
    }

    public void setAutoSkip(boolean autoSkip) {
        this.mLogStatus.mAutoSkip = autoSkip;
    }

    public long getTotleDuration() {
        return this.mLogStatus.mTotleDurationInMs;
    }

    public void setTotleDuration(long totleDuration) {
        this.mLogStatus.mTotleDurationInMs = totleDuration;
    }

    public void postSkipStastics(Context context) {
        ApplicationHelper.instance().getDeviceCompat().trackSkipEvent(context, this.mLogStatus);
    }

    public void post(Context context) {
        post(context, this.mLogStatus.mError);
    }

    public void post(Context context, int error) {
        if (context != null) {
            if (this.mLastPlayTime > 0) {
                long current = SystemClock.uptimeMillis();
                OnlinePlayStatus onlinePlayStatus = this.mLogStatus;
                onlinePlayStatus.mPlayDurationInMs += current - this.mLastPlayTime;
                this.mLastPlayTime = current;
            }
            this.mLogStatus.mStayTimeInMs = SystemClock.uptimeMillis() - this.mInitTime;
            OnlineMusicReporter.postOnlinePlayStatus(context, this.mLogStatus.getShotsnap(error));
        }
    }

    public long checkPlayStatus(Context context) {
        if (this.mChecker == null) {
            return 0;
        }
        long time = this.mLogStatus.mPlayDurationInMs;
        if (this.mLastPlayTime > 0) {
            time = SystemClock.uptimeMillis() - this.mLastPlayTime;
        }
        long remain = 60000 - time;
        if (remain >= 0) {
            return remain;
        }
        this.mChecker = null;
        post(context, 3);
        return remain;
    }

    public synchronized void startChecking(Context context, Handler handler) {
        Log.e(TAG, "start checking");
        this.mChecker = new OnlinePlayChecker(context, handler, this);
        this.mHandler = handler;
        handler.postDelayed(this.mChecker, 60000);
    }

    public synchronized void stopChecking() {
        Log.e(TAG, "stop checking");
        if (!(this.mHandler == null || this.mChecker == null)) {
            this.mHandler.removeCallbacks(this.mChecker);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void makeLocalStatstics(Context r14, android.net.Uri r15) {
        /*
        r13 = this;
        r12 = r15.getScheme();
        r0 = "content";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x007a;
    L_0x000c:
        r0 = r14.getContentResolver();
        r1 = 4;
        r2 = new java.lang.String[r1];
        r1 = 0;
        r3 = "_data";
        r2[r1] = r3;
        r1 = 1;
        r3 = "title";
        r2[r1] = r3;
        r1 = 2;
        r3 = "artist";
        r2[r1] = r3;
        r1 = 3;
        r3 = "album";
        r2[r1] = r3;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r15;
        r7 = r0.query(r1, r2, r3, r4, r5);
        if (r7 == 0) goto L_0x006f;
    L_0x0031:
        r0 = r7.moveToFirst();	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        if (r0 == 0) goto L_0x006c;
    L_0x0037:
        r0 = 0;
        r10 = r7.getString(r0);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r8 = new java.io.File;	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r8.<init>(r10);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r6 = entagged.audioformats.AudioFileIO.read(r8);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r0 = r6.getBitrate();	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r13.setBitRate(r0);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r0 = r8.getName();	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r13.setFileName(r0);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r0 = com.miui.player.util.FileNameUtils.getFileExtension(r10);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r13.setTrackType(r0);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r0 = 1;
        r0 = r7.getString(r0);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r1 = 2;
        r1 = r7.getString(r1);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r2 = 3;
        r2 = r7.getString(r2);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
        r13.setTrackInfo(r0, r1, r2);	 Catch:{ CannotReadException -> 0x0070, all -> 0x0075 }
    L_0x006c:
        r7.close();
    L_0x006f:
        return;
    L_0x0070:
        r0 = move-exception;
        r7.close();
        goto L_0x006f;
    L_0x0075:
        r0 = move-exception;
        r7.close();
        throw r0;
    L_0x007a:
        r0 = "file";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x006f;
    L_0x0082:
        r8 = new java.io.File;
        r0 = r15.getPath();
        r8.<init>(r0);
        r6 = entagged.audioformats.AudioFileIO.read(r8);	 Catch:{ CannotReadException -> 0x00b8 }
        r0 = r6.getBitrate();	 Catch:{ CannotReadException -> 0x00b8 }
        r13.setBitRate(r0);	 Catch:{ CannotReadException -> 0x00b8 }
        r9 = r6.getName();	 Catch:{ CannotReadException -> 0x00b8 }
        r13.setFileName(r9);	 Catch:{ CannotReadException -> 0x00b8 }
        r0 = com.miui.player.util.FileNameUtils.getFileExtension(r9);	 Catch:{ CannotReadException -> 0x00b8 }
        r13.setTrackType(r0);	 Catch:{ CannotReadException -> 0x00b8 }
        r11 = r6.getTag();	 Catch:{ CannotReadException -> 0x00b8 }
        r0 = r11.getFirstTitle();	 Catch:{ CannotReadException -> 0x00b8 }
        r1 = r11.getFirstArtist();	 Catch:{ CannotReadException -> 0x00b8 }
        r2 = r11.getFirstAlbum();	 Catch:{ CannotReadException -> 0x00b8 }
        r13.setTrackInfo(r0, r1, r2);	 Catch:{ CannotReadException -> 0x00b8 }
        goto L_0x006f;
    L_0x00b8:
        r0 = move-exception;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.reporter.OnlinePlayStatstics.makeLocalStatstics(android.content.Context, android.net.Uri):void");
    }
}
