package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.TextUtils;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.Album;
import com.miui.player.plugin.onlinemusic2.Album.AlbumOutline;
import com.miui.player.plugin.onlinemusic2.Album.AlbumOutline.AlbumDetail;
import com.miui.player.plugin.onlinemusic2.Album.AlbumStatistics;
import com.miui.player.plugin.onlinemusic2.AlbumList;
import com.miui.player.util.DateTimeHelper;
import com.miui.player.util.Strings;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AlbumListParser implements Parser<AlbumList, JSONArray> {

    public static class AlbumParser implements Parser<Album, JSONObject> {
        private final AlbumDetailParser mDetailParser = new AlbumDetailParser();
        private final AlbumOutlineParser mOutlineParser = new AlbumOutlineParser();

        public static class AlbumDetailParser implements Parser<AlbumDetail, JSONObject> {
            private static final String GENERE = "styles";
            private static final String INTRODUCTION = "info";
            private static final String LANGAGE = "language";
            private static final String PRODUCE_COMPANY = "produce_company";
            private static final String PUBLISH_COMPANY = "publishcompany";
            private static final String PUBLISH_TIME = "publishtime";

            public static class AlbumStasticsParser implements Parser<AlbumStatistics, JSONObject> {
                private static final String FAVORITE_NUM = "favorites_num";
                private static final String HOT = "hot";
                private static final String IS_HOT = "is_hot";
                private static final String IS_NEW = "is_new";
                private static final String IS_RECOMMEND = "is_recommend";
                private static final String LISTEN_NUM = "listen_nums";
                private static final String NEW_HOT = "new_hot";
                private static final String RECOMMEND_NUM = "recommend_num";
                private static final String TOTAL_LISTEN_NUM = "total_listen_nums";
                private static final String ZHUOYUE_BUY_URL = "zhuoyue_buyurl";
                private static final String ZHUOYUE_FLAG = "zhuoyue_flag";
                private static final String ZHUOYUE_PRICE = "zhuoyue_price";
                public int mFavoriteNum;
                public int mHot;
                public boolean mIsHot;
                public boolean mIsNew;
                public boolean mIsRecommend;
                public int mListenNum;
                public int mNewHot;
                public int mRecommendNum;
                public int mTotalListenNum;
                public String mZhuoyueBuyURL;
                public int mZhuoyueFlag;
                public float mZhuoyuePrice;

                public AlbumStatistics parse(JSONObject src) {
                    boolean z;
                    boolean z2 = true;
                    AlbumStatistics statistics = new AlbumStatistics();
                    statistics.mIsNew = src.optInt(IS_NEW, 0) == 1;
                    if (src.optInt(IS_HOT, 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    statistics.mIsHot = z;
                    statistics.mNewHot = src.optInt(NEW_HOT, 0);
                    statistics.mHot = src.optInt(HOT, 0);
                    if (src.optInt(IS_RECOMMEND, 0) != 1) {
                        z2 = false;
                    }
                    statistics.mIsRecommend = z2;
                    statistics.mRecommendNum = src.optInt(RECOMMEND_NUM, 0);
                    statistics.mFavoriteNum = src.optInt(FAVORITE_NUM, 0);
                    statistics.mListenNum = src.optInt(LISTEN_NUM, 0);
                    statistics.mTotalListenNum = src.optInt(TOTAL_LISTEN_NUM, 0);
                    statistics.mZhuoyueFlag = src.optInt(ZHUOYUE_FLAG, 0);
                    statistics.mZhuoyuePrice = (float) src.optDouble(ZHUOYUE_PRICE, 0.0d);
                    statistics.mZhuoyueBuyURL = src.optString(ZHUOYUE_BUY_URL, null);
                    return statistics;
                }
            }

            public AlbumDetail parse(JSONObject src) {
                AlbumDetail detail = new AlbumDetail();
                detail.mGenre = Strings.seperateValues(src.optString(GENERE, null), ",");
                detail.mIntroduction = src.optString("info", null);
                detail.mPublishTime = DateTimeHelper.fromString(src.optString(PUBLISH_TIME, null), "yyyy-MM-dd");
                detail.mPublishCompany = src.optString(PUBLISH_COMPANY, null);
                detail.mProduceCompany = src.optString(PRODUCE_COMPANY, null);
                detail.mLanguage = src.optString("language", null);
                detail.mStatistics = new AlbumStasticsParser().parse(src);
                return detail;
            }
        }

        public static class AlbumOutlineParser implements Parser<AlbumOutline, JSONObject> {
            private static final String ARTIST_ID = "all_artist_id";
            private static final String ARTIST_NAME = "author";
            private static final String AUDIO_COUNT = "songs_total";
            private static final String ID = "album_id";
            private static final String IMAGE = "image_url";
            private static final String IMAGE_BAK = "pic_radio";
            private static final String PICTURE_BIG = "pic_big";
            private static final String PICTURE_SMALL = "pic_small";
            private static final String TITLE = "title";

            public AlbumOutline parse(JSONObject src) {
                String id = src.optString("album_id", null);
                String title = src.optString("title", null);
                if (TextUtils.isEmpty(id) || TextUtils.isEmpty(title)) {
                    return null;
                }
                AlbumOutline outline = new AlbumOutline(id, title);
                outline.mArtistId = src.optString(ARTIST_ID, null);
                outline.mArtistIds = Strings.seperateValues(outline.mArtistId, ",");
                outline.mArtistName = src.optString(ARTIST_NAME, null);
                outline.mArtistNames = Strings.seperateValues(outline.mArtistName, ",");
                outline.mAudioCount = src.optInt("songs_total", 0);
                outline.mURLImage = src.optString(IMAGE, null);
                if (outline.mURLImage == null) {
                    outline.mURLImage = src.optString(IMAGE_BAK, null);
                }
                outline.mURLPictureBig = src.optString(PICTURE_BIG, null);
                outline.mURLPictureSmall = src.optString(PICTURE_SMALL, null);
                return outline;
            }
        }

        public Album parse(JSONObject src) {
            AlbumOutline outline = this.mOutlineParser.parse(src);
            if (outline == null) {
                return null;
            }
            Album album = new Album(outline);
            album.mDetail = this.mDetailParser.parse(src);
            return album;
        }
    }

    public AlbumList parse(JSONArray src) {
        List<Album> list = Parsers.parserArray(src, new AlbumParser());
        return list != null ? new AlbumList(list) : null;
    }
}
