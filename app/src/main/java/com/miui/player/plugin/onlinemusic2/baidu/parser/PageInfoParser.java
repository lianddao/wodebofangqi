package com.miui.player.plugin.onlinemusic2.baidu.parser;

import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.onlinemusic2.PageInfo;
import org.json.JSONObject;

public class PageInfoParser implements Parser<PageInfo, JSONObject> {
    private static final String NUM_PER_PAGE = "rn_num";
    private static final String TOTAL = "total";

    public PageInfo parse(JSONObject src) {
        return new PageInfo(src.optInt(TOTAL, 0), src.optInt(NUM_PER_PAGE, 0));
    }
}
