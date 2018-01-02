package com.xiaomi.music.cloud.model;

public class Track extends CloudObject<TrackInfo> {
    protected Track(TrackInfo info, int status, long syncTag) {
        super(info, status, syncTag);
    }

    public static Track create(TrackInfo info, int status, long syncTag) {
        return new Track(info, status, syncTag);
    }
}
