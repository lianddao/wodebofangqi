package com.miui.player.plugin.onlinemusic2;

import com.xiaomi.music.online.model.MetaList;
import java.util.List;

public class ChannelList extends MetaList<Channel> {
    private static final long serialVersionUID = 1;
    public String mLink;
    public String mTitle;

    public ChannelList(List<Channel> content) {
        super(content);
    }
}
