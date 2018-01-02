package com.miui.player.plugin.onlinelyric;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;

public interface LyricProvider {
    boolean requestItem(LyricItemInfo lyricItemInfo) throws ClientProtocolException, URISyntaxException, IOException;

    List<LyricItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException;
}
