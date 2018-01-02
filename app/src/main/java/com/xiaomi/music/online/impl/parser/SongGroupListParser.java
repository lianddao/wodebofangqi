package com.xiaomi.music.online.impl.parser;

import com.miui.player.meta.MetaManager;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.online.model.SongGroupList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import com.xiaomi.music.util.MusicLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SongGroupListParser implements Parser<SongGroupList, JSONObject> {
    public static final String TAG = "SongGroupListParser";
    SongGroupParser mSongGroupParser = new SongGroupParser();

    public static class SongGroupParser implements Parser<SongGroup, JSONObject> {
        private static final String KEY_COUNT = "count";
        private static final String KEY_DESCRIPTION = "description";
        private static final String KEY_ID = "nid";
        private static final String KEY_IMAGE_URL = "url";
        private static final String KEY_INTRO = "intro";
        private static final String KEY_LARGE_IMAGE_URL = "pic_large_url";
        private static final String KEY_NAME = "name";
        private static final String KEY_SUB_TITLE = "subtitle";

        public SongGroup parse(JSONObject src) {
            String id = src.optString(KEY_ID, null);
            String name = src.optString("name", null);
            SongGroup songGroup = null;
            if (!(id == null && name == null)) {
                songGroup = SongGroup.createSongGroup(id, name);
            }
            if (songGroup != null) {
                songGroup.mSubTitle = src.optString(KEY_SUB_TITLE, null);
                songGroup.mDescription = src.optString("description", null);
                songGroup.mImageUrl = src.optString("url", null);
                songGroup.mLargeImageUrl = src.optString(KEY_LARGE_IMAGE_URL, null);
                songGroup.mIntro = src.optString(KEY_INTRO, null);
                songGroup.mCount = src.optInt("count");
                if (songGroup.mCount == 0) {
                    songGroup.mCount = src.optInt("total");
                }
            }
            return songGroup;
        }
    }

    public SongGroupList parse(JSONObject src) {
        List<SongGroup> list = null;
        try {
            list = Parsers.parserArray(src.getJSONArray("list"), this.mSongGroupParser);
        } catch (JSONException e) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e);
        }
        return list != null ? new SongGroupList(list) : null;
    }
}
