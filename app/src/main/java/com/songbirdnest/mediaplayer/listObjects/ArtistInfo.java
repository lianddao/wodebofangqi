package com.songbirdnest.mediaplayer.listObjects;

public class ArtistInfo extends ListData {
    String artistName;
    String songText;

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongText() {
        return this.songText;
    }

    public void setSongText(String songText) {
        this.songText = songText;
    }
}
