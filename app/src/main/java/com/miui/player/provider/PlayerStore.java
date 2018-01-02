package com.miui.player.provider;

import android.content.ContentUris;
import android.net.Uri;

public final class PlayerStore {
    public static final String AUTHORITY = "com.miui.player";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.miui";
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.miui";
    public static final int ID_PROVIDER_BAIDU = 1;
    public static final String ID_PROVIDER_BAIDU_STR = String.valueOf(1);
    public static final String MIUI_CONTENT_AUTHORITY_SLASH = "content://com.miui.player/";
    public static final int NOWPLAYING_PLAYLIST_ID = 0;
    public static final String NOWPLAYING_PLAYLIST_NAME = "nowplaying";
    public static final int ONLINE_AUDIO_ID_BASE = 536870911;
    public static final String TRIGGER_AUDIO_PLAYLIST_CLEANUP = "audio_playlist_cleanup";
    public static final String TRIGGER_NOW_PLAYING_DELETE = "nowplayinglist_delete";
    public static final String TRIGGER_NOW_PLAYING_INSERT = "nowplayinglist_insert";
    public static final String TRIGGER_PLAYLIST_AUDIO_DELETE = "playlist_audio_delete";

    public static class BaiduSyncState {
        public static final String DELETE = "delete";
        public static final String INSERT = "insert";
        public static final String RENAME = "rename";
        public static final String SYNCED = "synced";
    }

    public interface OnlineAudioColumns {
        public static final String ALBUM = "album";
        public static final String ARTIST = "artist";
        public static final String CP_ONLINE_ID = "online_id";
        public static final String DATA = "_data";
        public static final String DATE_ADDED = "date_added";
        public static final String DURATION = "duration";
        public static final String LIST_TYPE = "list_type";
        public static final String MI_ONLINE_ID = "mi_online_id";
        public static final String PROVIDER_ID = "provider_id";
        public static final String TITLE = "title";
    }

    public interface MemberColomns extends OnlineAudioColumns {
        public static final String AUDIO_ID = "audio_id";
        public static final String MI_SYNC_TRACK_ID = "mi_sync_track_id";
        public static final String MI_SYNC_TRACK_STATE = "mi_sync_track_state";
        public static final String MI_SYNC_TRACK_TAG = "mi_sync_track_tag";
        public static final String PLAYLIST_ID = "playlist_id";
        public static final String PLAY_ORDER = "play_order";
        public static final String _ID = "_id";
    }

    public static class MiSyncState {
        public static final int DELETE = 1;
        public static final int INSERT = 0;
        public static final int RENAME = 2;
        public static final int SYNCED = 3;
    }

    public interface MiuiAudioPlaylistView {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "audio_playlist_view";

        public interface Columns extends MemberColomns {
            public static final String BAIDU_PLAYLIST_CLOUD_ID = "playlist_cloud_id";
            public static final String BAIDU_PLAYLIST_STATE = "playlist_sync_state";
            public static final String BAIDU_TRACK_STATE = "sync_state";
            public static final String CP_ONLINE_ID = "online_id";
            public static final String MI_SYNC_PLAYLIST_ID = "mi_sync_playlist_id";
            public static final String MI_SYNC_PLAYLIST_STATE = "mi_sync_playlist_state";
            public static final String MI_SYNC_PLAYLIST_TAG = "mi_sync_playlist_tag";
            public static final String MI_SYNC_TRACK_ID = "mi_sync_track_id";
            public static final String MI_SYNC_TRACK_STATE = "mi_sync_track_state";
            public static final String MI_SYNC_TRACK_TAG = "mi_sync_track_tag";
            public static final String PLAYLIST_NAME = "playlist_name";
            public static final String PLAYLIST_TYPE = "list_type";
        }
    }

    public interface MiuiEqualizer {
        public static final int BAND_COUNT = 5;
        public static final Uri CUSTOM_URI = ContentUris.withAppendedId(EXTERNAL_URI, 0);
        public static final String DATA_DEFAULT_STR = "[0,0,0,0,0]";
        public static final String DEFAULT_SORT_ORDER = "_id";
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final int ID_CUSTOM = 0;
        public static final int ID_INVALIDE = -1;
        public static final String NAME_CUSTOM = "$$custom";
        public static final String TABLE_NAME = "equalizer";

        public interface Columns {
            public static final String DATA = "_data";
            public static final String DATE_ADDED = "data_added";
            public static final String NAME = "name";
            public static final String _ID = "_id";
        }
    }

    public interface MiuiNowPlayingAudio {
        public static final String DEFAULT_SORT_ORDER = "play_order";
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "nowplaying_audio_view";

        public interface Columns extends MemberColomns {
        }
    }

    public interface MiuiPlaylists {
        public static final int BILLBOARD_PLAYLIST = 102;
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri("playlists");
        public static final int FM_PLAYLIST = 101;
        public static final int HISTORY_LIST = -3;
        public static final String NAME_FAVORITE = "$miui$";
        public static final String NAME_HISTORY = "$$history";
        public static final String NAME_KTV = "$my_ktv$";
        public static final String NAME_NOWPLAYING = "nowplaying";
        public static final int NORMAL_PLAYLIST = 0;
        public static final int NOW_PLAYING_LIST = -2;
        public static final int PRESET_PLAYLIST = 1;
        public static final int RECOMMEND_PLAYLIST = 103;
        public static final String TABLE_NAME = "playlists";

        public static final class Columns {
            public static final String BAIDU_CLOUD_ID = "cloud_id";
            public static final String BAIDU_SYNC_STATE = "sync_state";
            public static final String DATE_ADDED = "date_added";
            public static final String DATE_MODIFIED = "date_modified";
            public static final String FOLDER_PATH = "folder_path";
            public static final String LIST_TYPE = "list_type";
            public static final String MI_ONLINE_LIST_ID = "mi_online_list_id";
            public static final String MI_SYNC_PLAYLIST_ID = "mi_sync_playlist_id";
            public static final String MI_SYNC_PLAYLIST_STATE = "mi_sync_playlist_state";
            public static final String MI_SYNC_PLAYLIST_TAG = "mi_sync_playlist_tag";
            public static final String NAME = "name";
            public static final String VISIBLE = "visible";
            public static final String _ID = "_id";
        }

        public static class Members {
            public static final String DEFAULT_SORT_ORDER = "date_added DESC";
            public static final String TABLE_NAME = "members";

            public interface Columns extends MemberColomns {
                public static final String BAIDU_SYNC_STATE = "sync_state";
            }

            public static Uri getMembersUri(long playlistId) {
                return Uri.parse("content://com.miui.player/playlists_audio_map/" + playlistId + "/" + TABLE_NAME);
            }
        }
    }

    public interface MiuiPlaylistsAudioMap {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "playlists_audio_map";

        public static final class Columns implements MemberColomns {
            public static final String BAIDU_SYNC_STATE = "sync_state";
        }
    }

    public interface OnlineAudioDetail {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "online_audio_detail";

        public interface Columns {
            public static final String ALBUM_ID = "album_id";
            public static final String ALBUM_URL = "album_url";
            public static final String ARTIST_ID = "artist_id";
            public static final String CP_ONLINE_ID = "online_id";
            public static final String LYRIC_URL = "lyric_url";
            public static final String MI_ONLINE_ID = "mi_online_id";
            public static final String PROVIDER_ID = "provider_id";
            public static final String TIME_LAST_MODIFIED = "time_last_modified";
            public static final String _ID = "_id";
        }
    }

    public interface OnlineDownloading {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "online_downloading";

        public interface Columns {
            public static final String AUDIO_LINK = "link";
            public static final String BITRATE = "bitrate";
            public static final String DESCRIPTION = "description";
            public static final String DOWNLOAD_ID = "download_id";
            public static final String ONLINE_ID = "online_id";
            public static final String TIME_LAST_MODIFIED = "time_last_modified";
            public static final String _ID = "_id";
        }
    }

    public interface Search {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri("search");
        public static final String TABLE_NAME = "search";
    }

    public interface Statistics {
        public static final Uri EXTERNAL_URI = PlayerStore.getContentUri(TABLE_NAME);
        public static final String TABLE_NAME = "statistics";

        public interface Columns {
            public static final String AUDIO_ID = "audio_id";
            public static final String DATA = "_data";
            public static final String DATE_ADDED = "data_added";
            public static final String DATE_LAST_MODIFIED = "data_last_modified";
            public static final String ID3_CORRECTED = "id3_corrected";
            public static final String PLAYED_COUNT = "played_count";
            public static final String _ID = "_id";
        }
    }

    public static Uri getContentUri(String tableName) {
        return Uri.parse(MIUI_CONTENT_AUTHORITY_SLASH + tableName);
    }
}
