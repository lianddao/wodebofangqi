package com.miui.player.plugin.onlinemusic2.baidu;

import com.google.android.collect.Maps;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.miui.player.plugin.onlinemusic2.baidu.parser.BaiduNetwork;
import com.miui.player.plugin.onlinemusic2.baidu.parser.ImageItemInfoParser;
import com.miui.player.util.Strings;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;

public class BaiduImageProvider implements ImageProvider {
    private static final String TAG = BaiduImageProvider.class.getName();
    private final ImageSearchInfo mSearchInfo;

    public BaiduImageProvider(ImageSearchInfo searchInfo) {
        this.mSearchInfo = searchInfo;
    }

    public boolean requestItem(ImageItemInfo item) throws ClientProtocolException, URISyntaxException, IOException {
        if (item == null) {
            return false;
        }
        if (item.mInputStream != null) {
            return true;
        }
        InputStream is = BaiduNetwork.requestRaw(item.mURL);
        if (is == null) {
            return false;
        }
        try {
            item.mInputStream = is;
            return true;
        } finally {
            is.close();
        }
    }

    public List<ImageItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException {
        if (this.mSearchInfo == null || !this.mSearchInfo.isValid()) {
            return null;
        }
        String keyword;
        if (this.mSearchInfo.mSearchType == 0) {
            keyword = this.mSearchInfo.mArtistName;
        } else if (this.mSearchInfo.mSearchType != 1) {
            return null;
        } else {
            keyword = Strings.concat(BaiduConstants.QUERY_IMAGE_CONNECTOR, this.mSearchInfo.mAlbumName, this.mSearchInfo.mArtistName);
        }
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("query", keyword);
        nameValues.put("type", Integer.toString(this.mSearchInfo.mSearchType));
        return (List) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/search/photo?", nameValues, Parsers.createParserProxyForArray("photolist", Parsers.createComposeParserProxy(new ImageItemInfoParser())), null);
    }

    public int getType() {
        return 1000;
    }

    public ImageSearchInfo getImageSearchInfo() {
        return this.mSearchInfo;
    }
}
