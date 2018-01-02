package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.Html;
import android.text.TextUtils;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.Audio.AudioOutline;
import com.miui.player.meta.Audio.AudioStatistics;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.util.DateTimeHelper;
import com.miui.player.util.Strings;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioListParser implements Parser<AudioList, JSONArray> {
    static final String TAG = AudioListParser.class.getName();

    public static class AudioParser implements Parser<Audio, JSONObject> {
        private final AudioDetailParser mDetailParser = new AudioDetailParser();
        private final AudioOutlineParser mOutlineParser = new AudioOutlineParser();

        public static class AudioDetailParser implements Parser<AudioDetail, JSONObject> {
            private static final String ALBUM_ID = "album_id";
            private static final String ALBUM_NO = "album_no";
            private static final String ALBUM_TITLE = "album_title";
            private static final String ALL_ARTIST_IDS = "all_artist_id";
            private static final String ALL_ARTIST_NAME = "author";
            private static final String ALL_ARTIST_NAME_BAK = "artist";
            private static final String AREA = "area";
            private static final String ARTIST_ID = "artist_id";
            private static final String COMPOSE = "compose";
            private static final String COUNTRY = "country";
            private static final String DURATION = "file_duration";
            private static final String GENERE = "style";
            private static final String LANGUAGE = "language";
            private static final String LRC_LINK = "lrclink";
            private static final String PIC_BIG = "pic_big";
            private static final String PIC_HUGE = "pic_huge";
            private static final String PIC_PREMIUM = "pic_premium";
            private static final String PIC_RADIO = "pic_radio";
            private static final String PIC_SMALL = "pic_small";
            private static final String PUBLISH_TIME = "publishtime";
            private static final String RESOURCE_TYPE = "resource_type";
            private static final String SONGWRITING = "songwirting";
            private static final String SONG_ID = "song_id";

            public static class AudioStatisticsParser implements Parser<AudioStatistics, JSONObject> {
                private static final String DOWNLOAD_NUM = "download_num";
                private static final String FAVORITE_NUM = "favorites_num";
                private static final String HOT = "hot";
                private static final String IS_GENUINE = "isgenuine";
                private static final String IS_HOT = "is_hot";
                private static final String IS_NEW = "is_new";
                private static final String LISTEN_NUM = "listen_nums";
                private static final String RANK = "rank";
                private static final String RANK_CHANGE = "rank_change";
                private static final String RECOMMEND_NUM = "recommend_num";
                private static final String TOTAL_LISTEN_NUM = "total_listen_nums";
                public int mDownloadNum;
                public int mFavoriteNum;
                public int mHot;
                public boolean mIsGenuine;
                public boolean mIsHot;
                public boolean mIsNew;
                public int mListenNum;
                public int mRank;
                public int mRankChange;
                public int mRecommendNum;
                public int mTotalListenNum;

                public AudioStatistics parse(JSONObject src) {
                    boolean z;
                    boolean z2 = true;
                    AudioStatistics statistics = new AudioStatistics();
                    this.mIsNew = src.optInt(IS_NEW, 0) > 0;
                    if (src.optInt(IS_HOT, 0) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mIsHot = z;
                    this.mHot = src.optInt(HOT, 0);
                    this.mRank = src.optInt(RANK, 0);
                    this.mRankChange = src.optInt(RANK_CHANGE, 0);
                    if (src.optInt(IS_GENUINE, 0) <= 0) {
                        z2 = false;
                    }
                    this.mIsGenuine = z2;
                    this.mFavoriteNum = src.optInt(FAVORITE_NUM);
                    this.mDownloadNum = src.optInt(DOWNLOAD_NUM, 0);
                    this.mRecommendNum = src.optInt(RECOMMEND_NUM, 0);
                    this.mListenNum = src.optInt(LISTEN_NUM, 0);
                    this.mTotalListenNum = src.optInt(TOTAL_LISTEN_NUM, 0);
                    return statistics;
                }
            }

            public AudioDetail parse(JSONObject src) {
                AudioDetail detail = new AudioDetail();
                detail.mDurationInSec = src.optLong(DURATION, 0);
                detail.mArtistName = AudioListParser.getRawString(src.optString(ALL_ARTIST_NAME, null));
                if (detail.mArtistName == null) {
                    detail.mArtistName = AudioListParser.getRawString(src.optString("artist", null));
                }
                detail.mAllArtistNames = Strings.seperateValues(detail.mArtistName, ",");
                detail.mArtistId = src.optString("artist_id", null);
                detail.mArtistIds = Strings.seperateValues(src.optString(ALL_ARTIST_IDS, null), ",");
                detail.mAlbumName = AudioListParser.getRawString(src.optString("album_title", null));
                detail.mAlbumId = src.optString("album_id", null);
                detail.mAlbumNO = src.optInt(ALBUM_NO, 0);
                detail.mPulishTime = DateTimeHelper.fromString(src.optString(PUBLISH_TIME, null), "yyyy-MM-dd");
                detail.mGenre = Strings.seperateValues(src.optString(GENERE, null), ",");
                detail.mLanguage = src.optString("language", null);
                detail.mCountry = src.optString(COUNTRY, null);
                detail.mCompose = src.optString(COMPOSE, null);
                detail.mSongWriting = src.optString(SONGWRITING, null);
                detail.mArea = src.optInt("area", 0);
                detail.mURLPictureBig = src.optString(PIC_BIG, null);
                detail.mURLPictureSmall = src.optString(PIC_SMALL, null);
                detail.mURLPictureRadio = src.optString(PIC_RADIO, null);
                detail.mURLPicturePremium = src.optString(PIC_PREMIUM, null);
                detail.mURLPictureHuge = src.optString(PIC_HUGE, null);
                detail.mURLLrc = src.optString(LRC_LINK, null);
                detail.mResourceType = src.optInt(RESOURCE_TYPE);
                detail.mCpId = Integer.toString(1);
                detail.mCpSongId = src.optString("song_id", null);
                detail.mStatistics = new AudioStatisticsParser().parse(src);
                return detail;
            }
        }

        public static class AudioLinkListParser implements Parser<List<AudioLink>, JSONObject> {
            private static final String FILE_LINKS = "url";

            public static class AudioLinkParser implements Parser<AudioLink, JSONObject> {
                private static final String BITRATE = "file_bitrate";
                private static final String EXTENSION = "file_extension";
                private static final String FILE_DURATION = "file_duration";
                private static final String FILE_ID = "song_file_id";
                private static final String LINK = "file_link";
                private static final String SHOW_LINK = "show_link";
                private static final String SIZE = "file_size";

                public AudioLink parse(JSONObject src) {
                    int bitrate = src.optInt(BITRATE, -1);
                    if (bitrate < 0) {
                        return null;
                    }
                    String url = src.optString(LINK, null);
                    if (url == null) {
                        return null;
                    }
                    AudioLink audioLink = new AudioLink(url, bitrate);
                    audioLink.mExtension = src.optString(EXTENSION, null);
                    audioLink.mSizeInByte = src.optLong(SIZE, 0);
                    audioLink.mDurationInSec = src.optLong(FILE_DURATION, 0);
                    audioLink.mFileId = src.optString(FILE_ID, null);
                    audioLink.mShowLink = src.optString(SHOW_LINK, null);
                    return audioLink;
                }
            }

            public List<AudioLink> parse(JSONObject src) {
                try {
                    return Parsers.parserArray(src.getJSONArray("url"), new AudioLinkParser());
                } catch (JSONException e) {
                    return null;
                }
            }
        }

        public static class AudioOutlineParser implements Parser<AudioOutline, JSONObject> {
            private static final String AUDIO_ID = "song_id";
            private static final String AUDIO_ID_BAK = "songid";
            private static final String AUDIO_TITLE = "title";

            public AudioOutline parse(JSONObject src) {
                String id = src.optString("song_id", null);
                if (id == null) {
                    id = src.optString("songid", null);
                }
                String title = AudioListParser.getRawString(src.optString("title", null));
                if (id == null || TextUtils.getTrimmedLength(id) <= 0 || TextUtils.isEmpty(title)) {
                    return null;
                }
                return new AudioOutline(id, title);
            }
        }

        public Audio parse(JSONObject src) {
            AudioOutline outline = this.mOutlineParser.parse(src);
            if (outline == null) {
                return null;
            }
            Audio audio = new Audio(outline);
            audio.mDetail = this.mDetailParser.parse(src);
            return audio;
        }
    }

    public AudioList parse(JSONArray src) {
        List<Audio> list = Parsers.parserArray(src, new AudioParser());
        return list != null ? new AudioList(list) : null;
    }

    static String getRawString(String src) {
        return src != null ? Html.fromHtml(src).toString() : null;
    }
}
