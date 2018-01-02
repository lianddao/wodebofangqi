package com.xiaomi.music.cloud.impl;

import com.xiaomi.micloudsdk.request.Request;
import com.xiaomi.music.cloud.MusicCloudServerException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.net.ExtendedAuthToken;
import miui.net.exception.MiCloudServerException;
import org.apache.http.client.ClientProtocolException;

public class CloudNetworkUtils {
    public static String postToCloud(String userId, String authToken, String security, String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MusicCloudServerException {
        try {
            return Request.securePost(userId, ExtendedAuthToken.build(authToken, security), url, params);
        } catch (MiCloudServerException e) {
            throw new MusicCloudServerException(e, e.getStatusCode());
        }
    }

    public static String getFromCloud(String userId, String authToken, String security, String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MusicCloudServerException {
        try {
            return Request.secureGet(userId, ExtendedAuthToken.build(authToken, security), url, params);
        } catch (MiCloudServerException e) {
            throw new MusicCloudServerException(e, e.getStatusCode());
        }
    }
}
