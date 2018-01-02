package com.songbirdnest.mediaplayer.service;

public class PlayerMetaData {
    private int currentID;
    private String mCurrentAlbum;
    private String mCurrentArtist;
    private int mCurrentDuration;
    private String mCurrentTitle;
    private int songPosition = 0;
    private int trackToken = -1;

    public String getCurrentArtist() {
        return this.mCurrentArtist;
    }

    public void setCurrentArtist(String pCurrentArtist) {
        this.mCurrentArtist = pCurrentArtist;
    }

    public String getCurrentTitle() {
        return this.mCurrentTitle;
    }

    public void setCurrentTitle(String pCurrentTitle) {
        this.mCurrentTitle = pCurrentTitle;
    }

    public String getCurrentAlbum() {
        return this.mCurrentAlbum;
    }

    public void setCurrentAlbum(String pCurrentAlbum) {
        this.mCurrentAlbum = pCurrentAlbum;
    }

    public int getCurrentDuration() {
        return this.mCurrentDuration;
    }

    public void setCurrentDuration(int pCurrentDuration) {
        this.mCurrentDuration = pCurrentDuration;
    }

    public int getTrackToken() {
        return this.trackToken;
    }

    public void setTrackToken(int pTrackToken) {
        this.trackToken = pTrackToken;
    }

    public int getCurrentID() {
        return this.currentID;
    }

    public void setCurrentID(int pCurrentID) {
        this.currentID = pCurrentID;
    }

    public int getSongPosition() {
        return this.songPosition;
    }

    public void setSongPosition(int pSongPosition) {
        this.songPosition = pSongPosition;
    }
}
