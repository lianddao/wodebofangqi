package com.xiaomi.music.cloud.model;

public class PlaylistInfo {
    public static final String NAME_FAVORITE = "$miui$";
    public static final String NAME_KTV = "$my_ktv$";
    public static final int TYPE_BILLBOARD = 102;
    public static final int TYPE_FM = 101;
    public static final int TYPE_INVALID = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_PRESET = 1;
    public static final int TYPE_RECOMMEND = 103;
    private final String mCloudId;
    private final long mCreateTime;
    private final String mName;
    private String mPlaylistId;
    private int mType;

    private PlaylistInfo(String cloudId, String name, int type, String playlistId, long createTime) {
        this.mCloudId = cloudId;
        this.mName = name;
        this.mType = type;
        this.mPlaylistId = playlistId;
        this.mCreateTime = createTime;
    }

    public String getCloudId() {
        return this.mCloudId;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }

    public String getOnlineId() {
        return this.mPlaylistId;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void setPlaylistOnlineId(String playlistOnlineId) {
        this.mPlaylistId = playlistOnlineId;
    }

    public static PlaylistInfo create(String cloudId, String name, int type, String playlistId, long createTime) {
        return new PlaylistInfo(cloudId, name, type, playlistId, createTime);
    }
}
