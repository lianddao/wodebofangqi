package com.miui.player.plugin.onlinemusic2;

import com.xiaomi.music.online.model.MetaList;
import java.util.List;

public class ArtistList extends MetaList<Artist> {
    private static final long serialVersionUID = 1;

    public ArtistList(List<Artist> artists) {
        super(artists);
    }
}
