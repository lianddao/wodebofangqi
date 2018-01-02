package com.miui.player.plugin.onlinemusic2;

import java.io.Serializable;

public class Channel implements Serializable {
    private static final long serialVersionUID = 1;
    public AudioList mAudioList;
    public ChannelDetail mDetail;
    public final ChannelOutline mOutline;

    public static class ChannelDetail implements Serializable {
        private static final long serialVersionUID = 1;
        public String mArtistId;
        public int mAudioCount;
        public String mURLAvatar;
    }

    public static class ChannelOutline implements Serializable {
        private static final long serialVersionUID = 1;
        public final String mId;
        public final String mTitle;
        public String mURLThumb;

        public ChannelOutline(String id, String title) {
            this.mId = id;
            this.mTitle = title;
        }
    }

    public Channel(ChannelOutline outline) {
        this.mOutline = outline;
    }
}
