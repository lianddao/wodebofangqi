package com.miui.player.util;

public interface Actions {
    public static final String ACTION_AIRKAN_CONNECTED_DEVICE_CHANGED = "com.miui.player.AIRKAN_CONNECTED_DEVICE_CHANGED";
    public static final String ACTION_BROWSER = "com.miui.player.BROWSER";
    public static final String ACTION_CONN_CHANGED_HINT = "com.miui.player.CONN_CHANGED_HINT";
    public static final String ACTION_EQUALIZER = "com.miui.player.EQUALIZER";
    public static final String ACTION_FAVORITE_CHANGED = "com.miui.player.FAVORITE_CHANGED";
    public static final String ACTION_FIND_KTV = "com.miui.player.FIND_KTV";
    public static final String ACTION_FINISH_ALL_ACTIVITY = "com.miui.player.FINISH_ALL_ACTIVITY";
    public static final String ACTION_KTV_CONNECTED = "com.miui.player.KTV_CONNECTED";
    public static final String ACTION_KTV_CONNECT_CHANGED = "com.miui.player.KTV_CONNECT_CHANGED";
    public static final String ACTION_KTV_DISCONNECT = "com.miui.player.KTV_DISCONNECT";
    public static final String ACTION_KTV_PLAYLIST_CHANGED = "com.miui.player.KTV_PLAYLIST_CHANGED";
    public static final String ACTION_KTV_SONG_VOD = "com.miui.player.KTV_SONG_VOD";
    public static final String ACTION_KTV_SONG_VOD_STATE_CHANGED = "com.miui.player.KTV_SONG_VOD_STATE_CHANGED";
    public static final String ACTION_LANDSCAPE_VIEW = "com.miui.player.LANDSCAPE_VIEWER";
    public static final String ACTION_LOCAL_MUSIC_SEARCH = "com.miui.player.LOCAL_SEARCH";
    public static final String ACTION_MEDIA_PROVIDER_CHANGED = "com.miui.player.MEDIA_PROVIDER_CHANGED";
    public static final String ACTION_MUSIC_QUIT = "com.miui.player.QUIT";
    public static final String ACTION_NOWPLAYING_PLAYLIST = "com.miui.player.NOWPLAYING_PLAYLIST";
    public static final String ACTION_ONLINE_DOWNLOAD_COMPLETE = "com.miui.player.DOWNLOAD_COMPLETED";
    public static final String ACTION_PLAYBACK_VIEW = "com.miui.player.PLAYBACK_VIEWER";
    public static final String ACTION_PLAYLIST_SIZE_CHANGED = "com.miui.player.PLAYLIST_SIZE_CHANGED";
    public static final String ACTION_SUSPEND_BAR_VISIBILITY_CHANGED = "com.miui.player.SUSPEND_BAR_VISIBILITY_CHANGED";
    public static final String ACTION_TRACKS_PICKER = "com.miui.player.TRACK_PICKER";
    public static final String ACTION_VOLUME_ALERT = "com.miui.player.VOLUME_ALERT";
    public static final String EXTRA_NEW_DEVICE = "new_device";
    public static final String EXTRA_OLD_DEVICE = "old_device";
    public static final String KEY_AUDIO_COUNT = "audio_count";
    public static final String KEY_AUDIO_LIST_ARTIST = "audio_list_artist";
    public static final String KEY_AUDIO_LIST_CHANNEL = "audio_list_channel";
    public static final String KEY_AUDIO_LIST_DESCRIPTION = "audio_list_description";
    public static final String KEY_AUDIO_LIST_KEY = "audio_list_key";
    public static final String KEY_AUDIO_LIST_SONG_GROUP = "audio_list_song_group";
    public static final String KEY_AUDIO_LIST_TYPE = "audio_list_type";
    public static final String KEY_PLAYLIST_NAME = "playlist_name";
    public static final String KEY_PLAYLIST_ONLINE_ID = "playlist_online_id";
    public static final String KEY_PLAYLIST_TYPE = "playlist_type";
    public static final String MIME_TYPE_ALBUM = "vnd.android.cursor.dir/album";
    public static final String MIME_TYPE_ARTIST = "vnd.android.cursor.dir/artistalbum";
    public static final String MIME_TYPE_FOLDER = "vnd.android.cursor.dir/folder";
    public static final String MIME_TYPE_ONLINE_CATEGORY = "vnd.android.cursor.dir/online_category";
    public static final String MIME_TYPE_ONLINE_PREVIEW_ONLINE_PLAYLIST = "vnd.android.cursor.dir/preview_online_playlist";
    public static final String MIME_TYPE_ONLINE_PREVIEW_SONG_GROUP = "vnd.android.cursor.dir/preview_song_group";
    public static final String MIME_TYPE_ONLINE_PREVIEW_TRACK = "vnd.android.cursor.dir/preview_track";
    public static final String MIME_TYPE_ONLINE_SEARCH_TRACK = "vnd.android.cursor.dir/search_track";
    public static final String MIME_TYPE_PLAYLIST = "vnd.android.cursor.dir/playlist";
    public static final String MIME_TYPE_TRACK = "vnd.android.cursor.dir/track";
    public static final String PACKAGE_NAME = "com.miui.player";
    public static final int TYPE_AUDIO_LIST_ALBUM = 3;
    public static final int TYPE_AUDIO_LIST_ARTIST = 2;
    public static final int TYPE_AUDIO_LIST_BILL = 1;
    public static final int TYPE_AUDIO_LIST_CHANNEL = 4;
    public static final int TYPE_AUDIO_LIST_INVALID = 0;
    public static final int TYPE_AUDIO_LIST_SEARCH = 5;
    public static final int TYPE_AUDIO_LIST_SONG_GROUP = 6;
}
