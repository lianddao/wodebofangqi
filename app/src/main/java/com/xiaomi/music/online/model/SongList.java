package com.xiaomi.music.online.model;

import java.util.List;

public class SongList extends MetaList<Song> {
    private static final long serialVersionUID = 1;

    public SongList(List<Song> content) {
        super(content);
    }
}
