package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.text.TextUtils;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import org.json.JSONObject;

public class ImageItemInfoParser implements Parser<ImageItemInfo, JSONObject> {
    private static final String IMA_HEIGHT = "sizeh";
    private static final String IMA_URL = "pic";
    private static final String IMA_WIDTH = "sizew";
    private static final String KEY_WORD = "author";
    private static final int MIN_SIZE = 200;

    public ImageItemInfo parse(JSONObject src) {
        String url = src.optString(IMA_URL, null);
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        int height = src.optInt(IMA_HEIGHT, -1);
        int width = src.optInt(IMA_WIDTH, -1);
        if (height < 200 || width < 200) {
            return null;
        }
        ImageItemInfo item = new ImageItemInfo(url);
        item.mKeyword = src.optString(KEY_WORD, null);
        item.mHeight = height;
        item.mWidth = width;
        return item;
    }
}
