package com.miui.player.plugin.onlinemusic2;

import com.miui.player.meta.Audio;
import com.xiaomi.music.online.model.MetaList;
import java.util.List;

public class AudioList extends MetaList<Audio> {
    private static final long serialVersionUID = 1;
    public String mLink;
    public String mTitle;

    public AudioList(List<Audio> content) {
        super(content);
    }
}
