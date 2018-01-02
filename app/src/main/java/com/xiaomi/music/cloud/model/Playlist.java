package com.xiaomi.music.cloud.model;

public class Playlist extends CloudObject<PlaylistInfo> {
    protected Playlist(PlaylistInfo info, int status, long syncTag) {
        super(info, status, syncTag);
    }

    public static Playlist create(PlaylistInfo info, int status, long syncTag) {
        return new Playlist(info, status, syncTag);
    }
}
