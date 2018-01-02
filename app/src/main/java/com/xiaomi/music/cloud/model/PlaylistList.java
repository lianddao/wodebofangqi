package com.xiaomi.music.cloud.model;

import java.util.List;

public class PlaylistList extends MetaList<Playlist> {
    private PlaylistList(List<Playlist> items, String tag, boolean lastPage) {
        super(items, tag, lastPage);
    }

    public static PlaylistList create(List<Playlist> items, String tag, boolean lastPage) {
        return new PlaylistList(items, tag, lastPage);
    }
}
