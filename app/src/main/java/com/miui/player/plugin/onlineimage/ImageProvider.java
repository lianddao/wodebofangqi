package com.miui.player.plugin.onlineimage;

import com.miui.player.meta.ImageSearchInfo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;

public interface ImageProvider {
    public static final int INVALID_TYPE = -1;
    public static final int ONLINE_MUSIC_PLUGIN_BASE_TYPE = 1000;

    ImageSearchInfo getImageSearchInfo();

    int getType();

    boolean requestItem(ImageItemInfo imageItemInfo) throws ClientProtocolException, URISyntaxException, IOException;

    List<ImageItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException;
}
