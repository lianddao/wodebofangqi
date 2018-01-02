package com.miui.player.plugin.onlinemusic2.baidu.parser;

import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.plugin.onlinemusic2.AudioSearchResult;
import com.miui.player.plugin.onlinemusic2.PageInfo;
import org.json.JSONObject;

public class AudioSearchResultParser implements Parser<AudioSearchResult, JSONObject> {
    private static final String AUDIO_LIST = "song_list";
    private static final String IS_ALBUM = "is_album";
    private static final String IS_ARTIST = "is_artist";
    private static final String KEYWORDS = "query";
    private static final String PAGE_INFO = "pages";

    public AudioSearchResult parse(JSONObject src) {
        String keywords = src.optString("query", null);
        if (keywords == null) {
            return null;
        }
        return new AudioSearchResult(keywords, (PageInfo) Parsers.createParserProxyForObject(PAGE_INFO, new PageInfoParser()).parse(src), (AudioList) Parsers.createParserProxyForArray(AUDIO_LIST, new AudioListParser()).parse(src), src.optBoolean(IS_ARTIST, false), src.optBoolean(IS_ALBUM, false));
    }
}
