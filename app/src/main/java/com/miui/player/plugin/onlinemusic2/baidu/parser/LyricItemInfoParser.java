package com.miui.player.plugin.onlinemusic2.baidu.parser;

import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import org.json.JSONObject;

public class LyricItemInfoParser implements Parser<LyricItemInfo, JSONObject> {
    private static final String LRC_URL = "lrclink";

    public LyricItemInfo parse(JSONObject src) {
        String url = src.optString(LRC_URL, null);
        if (url == null) {
            return null;
        }
        LyricItemInfo item = new LyricItemInfo();
        item.setLink(url);
        return item;
    }
}
