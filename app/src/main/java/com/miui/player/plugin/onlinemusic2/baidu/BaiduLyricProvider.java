package com.miui.player.plugin.onlinemusic2.baidu;

import com.google.android.collect.Maps;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlinelyric.LyricContentFactory;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.plugin.onlinemusic2.baidu.parser.BaiduNetwork;
import com.miui.player.plugin.onlinemusic2.baidu.parser.LyricItemInfoParser;
import com.miui.player.util.Strings;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

public class BaiduLyricProvider implements LyricProvider {
    private final LyricSearchInfo mSearchInfo;

    public BaiduLyricProvider(LyricSearchInfo searchInfo) {
        this.mSearchInfo = searchInfo;
    }

    public boolean requestItem(LyricItemInfo item) throws ClientProtocolException, URISyntaxException, IOException {
        if (item == null) {
            return false;
        }
        if (item.getContent() != null) {
            return true;
        }
        String url = (String) item.getLink();
        if (url == null) {
            return false;
        }
        InputStream is = BaiduNetwork.requestRaw(url);
        if (is == null) {
            return false;
        }
        try {
            byte[] byteArray = StreamHelper.toByteArray(is);
            if (byteArray != null) {
                item.setContent(LyricContentFactory.create(byteArray));
                return true;
            }
            is.close();
            return false;
        } finally {
            is.close();
        }
    }

    public List<LyricItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException {
        List<LyricItemInfo> list = null;
        if (this.mSearchInfo != null && this.mSearchInfo.isValid()) {
            String keyword = Strings.concat(BaiduConstants.QUERY_CONNECTOR, this.mSearchInfo.mTrack, this.mSearchInfo.mArtist);
            Map<String, String> nameValues = Maps.newHashMap();
            nameValues.put("query", keyword);
            Parser<List<LyricItemInfo>, JSONObject> parser = Parsers.createParserProxyForArray("lrcys_list", Parsers.createComposeParserProxy(new LyricItemInfoParser()));
            String tr = this.mSearchInfo.mTrack;
            String ar = this.mSearchInfo.mArtist;
            list = (List) BaiduNetwork.request(BaiduConstants.LYRIC_QUERY, nameValues, parser, null);
            if (list != null) {
                for (LyricItemInfo item : list) {
                    item.setArtist(ar);
                    item.setTrack(tr);
                }
            }
        }
        return list;
    }
}
