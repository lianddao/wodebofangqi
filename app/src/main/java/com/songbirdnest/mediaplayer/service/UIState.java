package com.songbirdnest.mediaplayer.service;

public class UIState {
    public static final int PHOTOSTREAM_OFF = 2;
    public static final int PHOTOSTREAM_ON = 1;
    private String backToListActivity = "";
    private String backToListToken = "";
    private int mPhotostreamState = 2;

    public String getBackToListActivity() {
        return this.backToListActivity;
    }

    public void setBackToListActivity(String backToListActivity) {
        this.backToListActivity = backToListActivity;
    }

    public String getBackToListToken() {
        return this.backToListToken;
    }

    public void setBackToListToken(String backToListToken) {
        this.backToListToken = backToListToken;
    }

    public boolean isPhotostreamOn() {
        if (this.mPhotostreamState == 1) {
            return true;
        }
        return false;
    }

    public void setPhotostreamState(int pState) {
        this.mPhotostreamState = pState;
    }

    public int getPhotostreamState() {
        return this.mPhotostreamState;
    }
}
