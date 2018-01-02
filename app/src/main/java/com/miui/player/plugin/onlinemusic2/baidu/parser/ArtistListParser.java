package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.TextUtils;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.Artist;
import com.miui.player.plugin.onlinemusic2.Artist.ArtistDetail;
import com.miui.player.plugin.onlinemusic2.Artist.ArtistOutline;
import com.miui.player.plugin.onlinemusic2.ArtistList;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants.Areas;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants.Genders;
import com.miui.player.util.DateTimeHelper;
import com.miui.player.util.Strings;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArtistListParser implements Parser<ArtistList, JSONArray> {

    public static class ArtistParser implements Parser<Artist, JSONObject> {
        private final ArtistOutlineParser mOutlineParser = new ArtistOutlineParser();

        public static class ArtistDetailParser implements Parser<ArtistDetail, JSONObject> {
            private static final String ALBUM_COUNT = "albums_total";
            private static final String ALIAS_NAME = "aliasname";
            private static final String AUDIO_COUNT = "songs_total";
            private static final String BIRTH = "birth";
            private static final String BLOOD_TYPE = "bloodtype";
            private static final String COMPANY = "company";
            private static final String CONSTELLATION = "constellation";
            private static final String INTRODUCTION = "intro";
            private static final String NICK_NAME = "nick_name";
            private static final String RELATE_ARTIST_IDS = "relate_artist";
            private static final String STATURE = "stature";
            private static final String TRANSLATE_NAME = "translatename";
            private static final String WEIGHT = "weight";
            public String mAlbumCount;
            public String mAliasName;
            public String mAudioCount;
            public Date mBirth;
            public String mBloodType;
            public String mCompany;
            public String mConstellation;
            public String mIntroduction;
            public String mNickName;
            public List<String> mRelateArtistIds;
            public float mStature;
            public String mTranslateName;
            public float mWeight;

            public ArtistDetail parse(JSONObject src) {
                ArtistDetail detail = new ArtistDetail();
                detail.mAliasName = src.optString(ALIAS_NAME, null);
                detail.mTranslateName = src.optString(TRANSLATE_NAME, null);
                detail.mNickName = src.optString(NICK_NAME, null);
                detail.mCompany = src.optString("company", null);
                detail.mIntroduction = src.optString(INTRODUCTION, null);
                detail.mRelateArtistIds = Strings.seperateValues(src.optString(RELATE_ARTIST_IDS, null), ",");
                detail.mAlbumCount = src.optInt("albums_total", 0);
                detail.mAudioCount = src.optInt("songs_total", 0);
                detail.mBirth = DateTimeHelper.fromString(src.optString(BIRTH, null), "yyyy-MM-dd");
                detail.mConstellation = src.optString(CONSTELLATION, null);
                detail.mStature = (float) src.optDouble(STATURE, 0.0d);
                detail.mWeight = (float) src.optDouble(WEIGHT, 0.0d);
                detail.mBloodType = src.optString(BLOOD_TYPE, null);
                return detail;
            }
        }

        public static class ArtistOutlineParser implements Parser<ArtistOutline, JSONObject> {
            private static final String ALBUM_COUNT = "albums_total";
            private static final String AREA = "area";
            private static final String AUDIO_COUNT = "songs_total";
            private static final String AVATAR_BIG = "avatar_big";
            private static final String AVATAR_MID = "avatar_middle";
            private static final String AVATAR_MINI = "avatar_mini";
            private static final String AVATAR_SMALL = "avatar_small";
            private static final String COUNTRY = "country";
            private static final String FIRST_CHAR = "firstchar";
            private static final String GENDER = "gener";
            private static final String ID = "artist_id";
            private static final String TITLE = "name";

            public ArtistOutline parse(JSONObject src) {
                String id = src.optString("artist_id", null);
                String name = src.optString("name", null);
                String firstChar = src.optString(FIRST_CHAR, null);
                if (TextUtils.isEmpty(id) || TextUtils.isEmpty(name)) {
                    return null;
                }
                ArtistOutline outline = new ArtistOutline(id, name, !TextUtils.isEmpty(firstChar) ? firstChar.charAt(0) : BaiduConstants.DEFAULT_FIRST_CHAR);
                outline.mGender = Genders.translateFromBaidu(src.optInt(GENDER, Integer.MAX_VALUE));
                outline.mArea = Areas.translateFromBaidu(src.optInt("area", 0));
                outline.mCountry = src.optString(COUNTRY, null);
                outline.mURLAvatarBig = src.optString(AVATAR_BIG, null);
                outline.mURLAvatarMiddle = src.optString(AVATAR_MID, null);
                outline.mURLAvatarSmall = src.optString(AVATAR_SMALL, null);
                outline.mURLAvatarMini = src.optString(AVATAR_MINI, null);
                outline.mAlbumCount = src.optInt("albums_total", 0);
                outline.mAudioCount = src.optInt("songs_total", 0);
                return outline;
            }
        }

        public Artist parse(JSONObject src) {
            ArtistOutline outline = this.mOutlineParser.parse(src);
            return outline != null ? new Artist(outline) : null;
        }
    }

    public ArtistList parse(JSONArray src) {
        List<Artist> list = Parsers.parserArray(src, new ArtistParser());
        return list != null ? new ArtistList(list) : null;
    }
}
