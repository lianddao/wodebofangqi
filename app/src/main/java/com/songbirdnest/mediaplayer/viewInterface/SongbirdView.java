package com.songbirdnest.mediaplayer.viewInterface;

public interface SongbirdView {
    void changeToAlbum();

    void changeToArtists();

    void changeToDiscover();

    void changeToGenre();

    void changeToPlaylist();

    void changeToPodcast();

    void changeToSong();

    void changeToVideo();

    int getAlbumTotal();

    int getArtistTotal();

    int getGenreTotal();

    int getPlaylistTotal();

    int getPodcastTotal();

    int getSongTotal();

    int getVideoTotal();

    void onDestroy();

    void setAlbumsButtonClick(Listener listener);

    void setAlbumsButtonText(String str, String str2);

    void setArtistButtonClick(Listener listener);

    void setArtistButtonText(String str, String str2);

    void setDiscoverButtonClick(Listener listener);

    void setDiscoverButtonText(String str, String str2);

    void setGenreButtonClick(Listener listener);

    void setGenreButtonText(String str, String str2);

    void setPlaylistsButtonClick(Listener listener);

    void setPlaylistsButtonText(String str, String str2);

    void setPodcastButtonClick(Listener listener);

    void setPodcastButtonText(String str, String str2);

    void setSongButtonClick(Listener listener);

    void setSongButtonText(String str, String str2);

    void setVideoButtonClick(Listener listener);

    void setVideoText(String str, String str2);
}
