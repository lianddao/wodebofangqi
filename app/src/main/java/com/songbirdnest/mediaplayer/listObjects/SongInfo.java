package com.songbirdnest.mediaplayer.listObjects;

public class SongInfo extends ListData {
    int songID;
    String songLength;
    String songPath;
    String songTitle;
    Integer songTotalList;

    public int getSongID() {
        return this.songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongPath() {
        return this.songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public Integer getSongTotalList() {
        return this.songTotalList;
    }

    public void setSongTotalList(Integer songTotalList) {
        this.songTotalList = songTotalList;
    }

    public String getSongTitle() {
        return this.songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongLength() {
        return this.songLength;
    }

    public void setSongLength(String songLength) {
        this.songLength = songLength;
    }
}
