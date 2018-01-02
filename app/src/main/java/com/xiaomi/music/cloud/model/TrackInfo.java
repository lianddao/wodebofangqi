package com.xiaomi.music.cloud.model;

public class TrackInfo {
    public static final int STATUS_DELETE = 1;
    public static final int STATUS_NORMAL = 0;
    private final long mAddTime;
    private final String mCloudId;
    private final String mPlaylistCloudId;
    private final String mTrackId;

    private TrackInfo(String cloudId, String trackId, String playlistCloudId, long addTime) {
        this.mCloudId = cloudId;
        this.mTrackId = trackId;
        this.mAddTime = addTime;
        this.mPlaylistCloudId = playlistCloudId;
    }

    public String getCloudId() {
        return this.mCloudId;
    }

    public String getOnlineId() {
        return this.mTrackId;
    }

    public long getAddTime() {
        return this.mAddTime;
    }

    public String getPlaylistCloudId() {
        return this.mPlaylistCloudId;
    }

    public static TrackInfo create(String cloudId, String trackId, String playlistCloudId, long addTime) {
        return new TrackInfo(cloudId, trackId, playlistCloudId, addTime);
    }
}
