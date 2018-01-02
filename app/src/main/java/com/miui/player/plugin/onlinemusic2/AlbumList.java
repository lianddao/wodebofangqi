package com.miui.player.plugin.onlinemusic2;

import com.xiaomi.music.online.model.MetaList;
import java.util.List;

public class AlbumList extends MetaList<Album> {
    private static final long serialVersionUID = 1;

    public AlbumList(List<Album> albums) {
        super(albums);
    }
}
