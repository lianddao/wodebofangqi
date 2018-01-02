package com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123;

import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.xiaomi.music.util.NetworkUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;

abstract class LyricProviderBase implements LyricProvider {
    protected static final String GBK = "gbk";
    protected static final String UTF_8 = "utf-8";
    protected final LyricSearchInfo mSearchInfo;

    protected abstract String getItemUrl(LyricItemInfo lyricItemInfo);

    protected abstract String getListUrl();

    protected abstract LyricContent parseItem(InputStream inputStream);

    protected abstract List<LyricItemInfo> parseList(InputStream inputStream);

    public LyricProviderBase(LyricSearchInfo searchInfo) {
        this.mSearchInfo = searchInfo;
    }

    protected InputStream doRequestList(String url) throws ClientProtocolException, URISyntaxException, IOException {
        return NetworkUtil.doHttpGet(url);
    }

    protected InputStream doRequestItem(String url, Object link) throws ClientProtocolException, URISyntaxException, IOException {
        return NetworkUtil.doHttpGet(url);
    }

    public List<LyricItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException {
        List<LyricItemInfo> list = null;
        String url = getListUrl();
        if (url != null) {
            InputStream is = doRequestList(url);
            if (is != null) {
                try {
                    list = parseList(is);
                    if (is != null) {
                        is.close();
                    }
                } catch (Throwable th) {
                    if (is != null) {
                        is.close();
                    }
                }
            }
        }
        return list;
    }

    public boolean requestItem(LyricItemInfo item) throws ClientProtocolException, URISyntaxException, IOException {
        if (item == null) {
            return false;
        }
        if (item.getContent() != null) {
            return true;
        }
        String url = getItemUrl(item);
        if (url == null) {
            return false;
        }
        InputStream is = doRequestItem(url, item.getLink());
        if (is != null) {
            try {
                LyricContent content = parseItem(is);
                if (content != null) {
                    item.setContent(content);
                    return true;
                } else if (is == null) {
                    return false;
                }
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        } else if (is == null) {
            return false;
        }
        is.close();
        return false;
    }
}
