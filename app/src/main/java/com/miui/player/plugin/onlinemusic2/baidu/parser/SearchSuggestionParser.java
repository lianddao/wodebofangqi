package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.TextUtils;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.onlinemusic2.SearchSuggestion;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchSuggestionParser implements Parser<SearchSuggestion, JSONObject> {
    private static final String KEYWORDS = "query";
    private static final String SUGGESTION_LIST = "suggestion_list";

    public SearchSuggestion parse(JSONObject src) {
        ArrayList<String> suggestions = null;
        String keywords = src.optString("query", null);
        if (keywords != null) {
            JSONArray array = src.optJSONArray(SUGGESTION_LIST);
            if (array != null) {
                suggestions = new ArrayList();
                int count = array.length();
                for (int i = 0; i < count; i++) {
                    try {
                        String name = array.getString(i);
                        if (!TextUtils.isEmpty(name)) {
                            suggestions.add(name);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
        if (keywords == null || suggestions == null) {
            return null;
        }
        return new SearchSuggestion(keywords, suggestions);
    }
}
