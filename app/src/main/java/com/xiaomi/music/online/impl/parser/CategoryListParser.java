package com.xiaomi.music.online.impl.parser;

import com.miui.player.meta.MetaManager;
import com.xiaomi.music.online.model.Category;
import com.xiaomi.music.online.model.CategoryList;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.parser.Parsers;
import com.xiaomi.music.util.MusicLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CategoryListParser implements Parser<CategoryList, JSONObject> {
    private static final String TAG = "CategoryListParser";
    CategoryParser mCaregoryParser = new CategoryParser();

    public static class CategoryParser implements Parser<Category, JSONObject> {
        private static final String KEY_DESCRIPTION = "description";
        private static final String KEY_ID = "cid";
        private static final String KEY_NAME = "name";

        public Category parse(JSONObject src) {
            String id = src.optString(KEY_ID, null);
            String name = src.optString("name", null);
            String description = src.optString("description", null);
            if (id == null || name == null) {
                return null;
            }
            return Category.createCategory(id, name, description);
        }
    }

    public CategoryList parse(JSONObject src) {
        List<Category> list = null;
        try {
            list = Parsers.parserArray(src.getJSONArray("list"), this.mCaregoryParser);
        } catch (JSONException e) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e);
        }
        return list != null ? new CategoryList(list) : null;
    }
}
