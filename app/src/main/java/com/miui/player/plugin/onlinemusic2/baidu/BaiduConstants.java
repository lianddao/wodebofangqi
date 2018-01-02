package com.miui.player.plugin.onlinemusic2.baidu;

public interface BaiduConstants {
    public static final String ACCESS_TOKEN_URL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=MuVYUgPWGzqWBC1goWapvp5Z&client_secret=2Ktr9G0D88Nkw1WVFnERyvtnAweGtGs3&scope=music_media_basic,music_search_basic";
    public static final String ALBUM_DETAIL = "http://openapi.baidu.com/rest/2.0/music/album/info?";
    public static final String ALBUM_LIST = "http://openapi.baidu.com/rest/2.0/music/plaza/recommendalbum?";
    public static final String ALBUM_LIST_OF_ARTIST = "http://openapi.baidu.com/rest/2.0/music/artist/albumlist?";
    public static final String API_KEY = "MuVYUgPWGzqWBC1goWapvp5Z";
    public static final String APPLICATION_ID = "299409";
    public static final String ARTIST_DETAIL = "http://openapi.baidu.com/rest/2.0/music/artist/info?";
    public static final String ARTIST_LIST = "http://openapi.baidu.com/rest/2.0/music/artist/artistlist?";
    public static final String AUDIO_DETAIL = "http://openapi.baidu.com/rest/2.0/music/song/info?";
    public static final String AUDIO_DETAIL_LOGINED = "https://openapi.baidu.com/rest/2.0/music/song/getInfos?";
    public static final String AUDIO_LIST_OF_ARTIST = "http://openapi.baidu.com/rest/2.0/music/artist/songlist?";
    public static final String AUDIO_QUERY = "http://openapi.baidu.com/rest/2.0/music/search/common?";
    public static final String AUDIO_SUGGESTION_QUERY = "http://openapi.baidu.com/rest/2.0/music/search/suggestion?";
    public static final String BILL_DETAIL = "http://openapi.baidu.com/rest/2.0/music/billboard/billlist?";
    public static final String BILL_LIST = "http://openapi.baidu.com/rest/2.0/music/billboard/catalog?";
    public static final String CHANNEL_DETAIL = "http://openapi.baidu.com/rest/2.0/music/radio/songlist?";
    public static final String CHANNEL_LIST = "http://openapi.baidu.com/rest/2.0/music/radio/catalog?";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final char DEFAULT_FIRST_CHAR = '#';
    public static final String HOST = "http://openapi.baidu.com/rest/2.0/music/";
    public static final String HOSTS = "https://openapi.baidu.com/rest/2.0/music/";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_ALBUM_ID = "albumid";
    public static final String KEY_AREA = "area";
    public static final String KEY_ARTIST_ID = "artistid";
    public static final String KEY_AUDIO_ID = "songid";
    public static final String KEY_BAIDU_ACCESS_TOKEN = "baidu_access_token";
    public static final String KEY_BAIDU_SESSION_KEY = "baidu_session_key";
    public static final String KEY_BAIDU_SESSION_SECRET = "baidu_session_secret";
    public static final String KEY_BILL_ID = "type";
    public static final String KEY_BIT_RATE = "bit";
    public static final String KEY_CHANNEL_ID = "channelid";
    public static final String KEY_IMAGE_TYPE = "type";
    public static final String KEY_ORDER = "order";
    public static final String KEY_PAGE_NO = "page_no";
    public static final String KEY_PAGE_SIZE = "page_size";
    public static final String KEY_QUERY = "query";
    public static final String KEY_SESSION_KEY = "session_key";
    public static final String KEY_SESSION_SECRET = "session_secret";
    public static final String LYRIC_QUERY = "http://openapi.baidu.com/rest/2.0/music/search/lyrics?";
    public static final String ORDER_BY_HOT = "2";
    public static final String PHOTO_QUERY = "http://openapi.baidu.com/rest/2.0/music/search/photo?";
    public static final int PHOTO_TYPE_ALBUM = 1;
    public static final int PHOTO_TYPE_AVATAR = 0;
    public static final String QUERY_CONNECTOR = "$$$";
    public static final String QUERY_IMAGE_CONNECTOR = "$$";
    public static final String SCOPE_ALL = "music_media_basic,music_media_premium,music_musicdata_basic,music_search_basic";
    public static final String SCOPE_MEDIA_BASE = "music_media_basic";
    public static final String SCOPE_MEDIA_PREMIUM = "music_media_premium";
    public static final String SCOPE_MUSIC_DATA_BASE = "music_musicdata_basic";
    public static final String SCOPE_SEARCH_BASE = "music_search_basic";
    public static final String SECRET_KEY = "2Ktr9G0D88Nkw1WVFnERyvtnAweGtGs3";
    public static final String SEPERATOR = ",";
    public static final String STASTICS_LOG = "http://tinglog.baidu.com/v.gif?pid=10000&appkey=MuVYUgPWGzqWBC1goWapvp5Z&imei=%s&type=%s";
    public static final String TYPE_CONNECTOR = ",";

    public static class Areas {
        public static int translateFromBaidu(int src) {
            switch (src) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 4;
                case 4:
                    return 3;
                default:
                    return 5;
            }
        }
    }

    public static class Genders {
        public static int translateFromBaidu(int src) {
            switch (src) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                default:
                    return 0;
            }
        }
    }

    public static class OrderBys {
        public static int translateToBaidu(int src) {
            switch (src) {
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }
}
