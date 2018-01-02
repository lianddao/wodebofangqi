package com.songbirdnest.mediaplayer.viewInterface;

public interface MiniPlayerView {
    int getCurrentPosition();

    String getCurrentSongArtist();

    String getCurrentSongName();

    int getDuration();

    boolean isPlaying();

    void nextSong();

    void onDestroy();

    void pause();

    void play();

    void previousSong();

    void setFastForward(Listener listener);

    void setPause(Listener listener);

    void setProgressBar(int i);

    void setProgressMax(int i);

    void setRewind(Listener listener);

    void setSongArtistText(String str);

    void setSongChangeListener(Listener listener);

    void setUpdateTimer(Listener listener);
}
