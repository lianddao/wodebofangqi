package com.xiaomi.music.cloud.model;

public class CloudObject<T> {
    public static final int STATUS_DELETE = 1;
    private static final String STATUS_DELETED_STR = "deleted";
    public static final int STATUS_INVALID = -1;
    public static final int STATUS_NORMAL = 0;
    private static final String STATUS_NORMAL_STR = "normal";
    public final T mInfo;
    public final int mStatus;
    public final long mSyncTag;

    protected CloudObject(T info, int status, long syncTag) {
        this.mInfo = info;
        this.mStatus = status;
        this.mSyncTag = syncTag;
    }

    public String toString() {
        return String.format("[status=%d, sync tag=%d, info=%s]", new Object[]{Integer.valueOf(this.mStatus), Long.valueOf(this.mSyncTag), String.valueOf(this.mInfo)});
    }

    public Track asTrack() {
        try {
            return (Track) this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    public Playlist asPlaylist() {
        try {
            return (Playlist) this;
        } catch (ClassCastException e) {
            return null;
        }
    }

    public static int getStatus(String str) {
        if (STATUS_NORMAL_STR.equals(str)) {
            return 0;
        }
        if (STATUS_DELETED_STR.equals(str)) {
            return 1;
        }
        return -1;
    }
}
