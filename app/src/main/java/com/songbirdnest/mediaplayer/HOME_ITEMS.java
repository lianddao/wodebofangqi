package com.songbirdnest.mediaplayer;

import com.songbirdnest.mediaplayer.activities.ContentBrowser;

public enum HOME_ITEMS {
    ;
    
    protected int iconResourceId;
    protected String intentViewValue;
    protected boolean isVisible;
    protected int mainTextResourceId;
    protected int secondaryTextResourceId;
    protected Class viewClass;

    static {
        boolean z;
        String str = "FRIENDS_VIEW";
        String str2 = "Friends";
        if (Utils.getFriendsVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        FRIENDS_VIEW = new HOME_ITEMS(str, 0, C0116R.drawable.home_icon_discover, C0116R.string.discover_header, C0116R.string.discover_secondary, str2, z);
        PLAYLISTS_VIEW = new HOME_ITEMS("PLAYLISTS_VIEW", 1, C0116R.drawable.home_icon_playlists, C0116R.string.playlist_header, 0, Constants.CONTENT_VIEW_PLAYLIST_LIST, true);
        ARTISTS_VIEW = new HOME_ITEMS("ARTISTS_VIEW", 2, C0116R.drawable.home_icon_artists, C0116R.string.artist_header, 0, Constants.CONTENT_VIEW_ARTIST_LIST, true);
        SONGS_VIEW = new HOME_ITEMS("SONGS_VIEW", 3, C0116R.drawable.home_icon_songs, C0116R.string.songs_header, 0, Constants.CONTENT_VIEW_SONG_LIST, true);
        ALBUMS_VIEW = new HOME_ITEMS("ALBUMS_VIEW", 4, C0116R.drawable.home_icon_albums, C0116R.string.album_header, 0, Constants.CONTENT_VIEW_ALBUM_LIST, true);
        GENRE_VIEW = new HOME_ITEMS("GENRE_VIEW", 5, C0116R.drawable.home_icon_genres, C0116R.string.genre_header, 0, Constants.CONTENT_VIEW_GENRE_LIST, true);
        PODCASTS_VIEW = new HOME_ITEMS("PODCASTS_VIEW", 6, C0116R.drawable.home_icon_podcasts, C0116R.string.podcast_header, 0, Constants.CONTENT_VIEW_PODCAST_LIST, Utils.getPodcastVisibility() == 0);
        VIDEOS_VIEW = new HOME_ITEMS("VIDEOS_VIEW", 7, C0116R.drawable.home_icon_video, C0116R.string.video_header, 0, Constants.CONTENT_VIEW_VIDEO_LIST, true);
        SEARCH_VIEW = new HOME_ITEMS("SEARCH_VIEW", 8, C0116R.drawable.home_icon_search, C0116R.string.search_header, 0, "Search", true);
        $VALUES = new HOME_ITEMS[]{FRIENDS_VIEW, PLAYLISTS_VIEW, ARTISTS_VIEW, SONGS_VIEW, ALBUMS_VIEW, GENRE_VIEW, PODCASTS_VIEW, VIDEOS_VIEW, SEARCH_VIEW};
    }

    private HOME_ITEMS(int iconResourceId, int mainTextResourceId, int secondaryTextResourceId, String intentViewValue, boolean pIsVisible) {
        this.iconResourceId = iconResourceId;
        this.mainTextResourceId = mainTextResourceId;
        this.secondaryTextResourceId = secondaryTextResourceId;
        this.intentViewValue = intentViewValue;
        this.viewClass = ContentBrowser.class;
        this.isVisible = pIsVisible;
    }
}
