package com.miui.player.plugin.onlinelyric;

public class LyricItemInfo {
    private String mAlbum;
    private String mArtist;
    private LyricContent mContent;
    private Object mLink;
    private String mTrack;

    public String getTrack() {
        return this.mTrack;
    }

    public String getArtist() {
        return this.mArtist;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public LyricContent getContent() {
        return this.mContent;
    }

    public Object getLink() {
        return this.mLink;
    }

    public void setTrack(String tr) {
        this.mTrack = tr;
    }

    public void setArtist(String ar) {
        this.mArtist = ar;
    }

    public void setAlbum(String al) {
        this.mAlbum = al;
    }

    public void setContent(LyricContent content) {
        this.mContent = content;
    }

    public void setLink(Object link) {
        this.mLink = link;
    }

    public boolean isValid() {
        return (this.mTrack == null || this.mTrack.length() <= 0 || this.mLink == null) ? false : true;
    }

    public void setContentByByteArray(byte[] content) {
    }
}
