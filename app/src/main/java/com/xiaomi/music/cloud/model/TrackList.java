package com.xiaomi.music.cloud.model;

import java.util.List;

public class TrackList extends MetaList<Track> {
    private TrackList(List<Track> items, String tag, boolean lastPage) {
        super(items, tag, lastPage);
    }

    public static TrackList create(List<Track> items, String tag, boolean lastPage) {
        return new TrackList(items, tag, lastPage);
    }
}
