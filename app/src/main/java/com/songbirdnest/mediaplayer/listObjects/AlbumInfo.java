package com.songbirdnest.mediaplayer.listObjects;

public class AlbumInfo extends ListData {
    String albumArt;
    String albumArtist;
    String albumKey;
    Integer albumSongTotal;
    String albumTitle;

    public String getAlbumArt() {
        return this.albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    public String getAlbumKey() {
        return this.albumKey;
    }

    public void setAlbumKey(String albumKey) {
        this.albumKey = albumKey;
    }

    public String getAlbumTitle() {
        return this.albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Integer getAlbumSongTotal() {
        return this.albumSongTotal;
    }

    public void setAlbumSongTotal(Integer albumSongTotal) {
        this.albumSongTotal = albumSongTotal;
    }

    public String getAlbumArtist() {
        return this.albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }
}
