package com.xiaomi.music.cloud.model;

public class PlayStatus {
    public final String mCloudId;
    public final String mOnlineId;
    public final int mSeekPos;

    public PlayStatus(String onlineId, String cloudId, int seekPos) {
        this.mOnlineId = onlineId;
        this.mCloudId = cloudId;
        this.mSeekPos = seekPos;
    }

    public String toString() {
        return String.format("PlayStatus[online id = %s, cloud id = %s, seek = %d]", new Object[]{this.mOnlineId, this.mCloudId, Integer.valueOf(this.mSeekPos)});
    }
}
