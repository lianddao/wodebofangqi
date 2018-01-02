package com.miui.player.plugin.onlinemusic2;

public class AudioSearchResult {
    public final AudioList mAudioList;
    public final boolean mIsAlbum;
    public final boolean mIsArtist;
    public final String mKeywords;
    public final PageInfo mPageInfo;

    public AudioSearchResult(String keywords, PageInfo page, AudioList audioList, boolean isArtist, boolean isAlbum) {
        this.mKeywords = keywords;
        this.mPageInfo = page;
        this.mAudioList = audioList;
        this.mIsArtist = isArtist;
        this.mIsAlbum = isAlbum;
    }
}
