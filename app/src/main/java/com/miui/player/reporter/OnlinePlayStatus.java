package com.miui.player.reporter;

public class OnlinePlayStatus {
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_DOWNLOAD_END = 2000;
    public static final int STATUS_DOWNLOAD_FAILED = 1001;
    public static final int STATUS_DOWNLOAD_START = 1000;
    public static final int STATUS_DOWNLOAD_SUCCESS = 1002;
    public static final int STATUS_ERORR_LINK_BLANK = 4;
    public static final int STATUS_ERROR_LINK_FAILED = 5;
    public static final int STATUS_ERROR_OHTER = 6;
    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_PLAY_END = 1000;
    public static final int STATUS_PLAY_FIRST = 0;
    public static final int STATUS_PLAY_START = 2;
    public static final int STATUS_PLAY_SUCCESS = 3;
    public String mAlbumName;
    public String mArtistName;
    public String mAudioFinger;
    public boolean mAutoSkip;
    public int mBitrate;
    public int mBufferCount;
    public long mConnectTimeInMs;
    public int mError;
    public String mFileName;
    public boolean mIsLocal;
    public final String mOnlineId;
    public long mPlayDurationInMs;
    public long mStayTimeInMs;
    public long mTotleDurationInMs;
    public String mTrackName;
    public String mTrackType;
    public String mURL;
    public String mXiaomiId;

    public OnlinePlayStatus(String id, int error) {
        this.mOnlineId = id;
        this.mError = error;
    }

    public OnlinePlayStatus getShotsnap(int error) {
        OnlinePlayStatus snap = new OnlinePlayStatus(this.mOnlineId, error);
        snap.mURL = this.mURL;
        snap.mBitrate = this.mBitrate;
        snap.mAutoSkip = this.mAutoSkip;
        snap.mPlayDurationInMs = this.mPlayDurationInMs;
        snap.mConnectTimeInMs = this.mConnectTimeInMs;
        snap.mStayTimeInMs = this.mStayTimeInMs;
        snap.mBufferCount = this.mBufferCount;
        return snap;
    }
}
