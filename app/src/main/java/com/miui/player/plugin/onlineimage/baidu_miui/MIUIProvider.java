package com.miui.player.plugin.onlineimage.baidu_miui;

import android.util.Log;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlineimage.ImageItemInfo;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;

public class MIUIProvider implements ImageProvider {
    private static final String ALBUM_URL = "http://xshare.api.xiaomi.com/xShare?do=mp3.cover.search&album=%s&artist=%s";
    private static final String TAG = MIUIProvider.class.getName();
    private final ImageSearchInfo mSearchInfo;

    public MIUIProvider(ImageSearchInfo info) {
        this.mSearchInfo = info;
    }

    public ArrayList<ImageItemInfo> requestList() throws ClientProtocolException, URISyntaxException, IOException {
        ImageSearchInfo info = this.mSearchInfo;
        InputStream is = NetworkUtil.doHttpGet(String.format(ALBUM_URL, new Object[]{NetworkUtil.encode(info.mAlbumName), NetworkUtil.encode(info.mArtistName)}));
        if (is != null) {
            try {
                JSONArray data = StreamHelper.toJSONObject(is).getJSONArray("data");
                int len = data.length();
                if (len > 0) {
                    ArrayList<ImageItemInfo> arrayList = new ArrayList(len);
                    for (int i = 0; i < len; i++) {
                        String imageURL = data.getString(i);
                        if (imageURL != null && imageURL.startsWith("http")) {
                            arrayList.add(new ImageItemInfo(imageURL));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean requestItem(ImageItemInfo item) throws ClientProtocolException, URISyntaxException, IOException {
        IOException e;
        String str;
        String str2;
        if (item.mInputStream != null) {
            return true;
        }
        InputStream is = null;
        try {
            is = NetworkUtil.doHttpGet(item.mURL);
            if (is != null) {
                item.mInputStream = is;
                if (is == null) {
                    return true;
                }
                try {
                    is.close();
                    return true;
                } catch (IOException e2) {
                    Log.e(TAG, MetaManager.UNKNOWN_STRING, e2);
                    return true;
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e2 = e3;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e2);
                    return false;
                }
            }
            return false;
        } catch (ClientProtocolException e4) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e4);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e5) {
                    e2 = e5;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e2);
                    return false;
                }
            }
        } catch (URISyntaxException e6) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e6);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e7) {
                    e2 = e7;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e2);
                    return false;
                }
            }
        } catch (IOException e22) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e22);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e8) {
                    e22 = e8;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e22);
                    return false;
                }
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e222) {
                    Log.e(TAG, MetaManager.UNKNOWN_STRING, e222);
                }
            }
        }
    }

    public ImageSearchInfo getImageSearchInfo() {
        return this.mSearchInfo;
    }

    public int getType() {
        return 1;
    }
}
