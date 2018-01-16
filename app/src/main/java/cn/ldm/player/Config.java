package cn.ldm.player;

/**
 * 应用程序范围内的常量。
 */
public final class Config {

    private Config() {}

    /**
     * My personal Last.fm API key, please use your own.
     */
    public static final String LASTFM_API_KEY = "0bec3f7ec1f914d7c960c12a916c8fb3";

    /**
     * Used to distinguish album art from artist images
     */
    public static final String ALBUM_ART_SUFFIX = "album";

    /**
     * The ID of an artist, album, genre, or playlist passed to the profile
     * activity
     */
    public static final String ID = "id";

    /**
     * The name of an artist, album, genre, or playlist passed to the profile
     * activity
     */
    public static final String NAME = "name";

    /**
     * The name of an artist passed to the profile activity
     */
    public static final String ARTIST_NAME = "artist_name";

    /**
     * The year an album was released passed to the profile activity
     */
    public static final String ALBUM_YEAR = "album_year";

    /**
     * number of songs in a album or track list
     */
    public static final String SONG_COUNT = "song_count";

    /**
     * The MIME type passed to a the profile activity
     */
    public static final String MIME_TYPE = "mime_type";

    /**
     * Play from search intent
     */
    public static final String PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";

    /**
     * The smart playlist type
     */
    public static final String SMART_PLAYLIST_TYPE = "smart_playlist_type";

    /**
     * Number of search results to show at the top level search
     */
    public static final int SEARCH_NUM_RESULTS_TO_GET = 3;

    /**
     * 智能播放列表类型
     */
    public static enum SmartPlaylistType {
        LastAdded(-1, R.string.playlist_last_added),
        RecentlyPlayed(-2, R.string.playlist_recently_played),
        TopTracks(-3, R.string.playlist_top_tracks);

        public long mId;
        public int mTitleId;

        SmartPlaylistType(long id, int titleId) {
            mId = id;
            mTitleId = titleId;
        }

        public static SmartPlaylistType getTypeById(long id) {
            for (SmartPlaylistType type : SmartPlaylistType.values()) {
                if (type.mId == id) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 这有助于识别 ID 来自何处。主要用于确定用户点击歌曲的轨迹(艺术家/专辑/播放列表)
     */
    public static enum IdType {
        NA(0),
        Artist(1),
        Album(2),
        Playlist(3);

        public final int mId;

        IdType(final int id) {
            mId = id;
        }

        public static IdType getTypeById(int id) {
            for (IdType type : values()) {
                if (type.mId == id) {
                    return type;
                }
            }
            return NA;
        }
    }
}
