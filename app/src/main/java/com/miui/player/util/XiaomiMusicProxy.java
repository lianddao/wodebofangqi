package com.miui.player.util;

import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.ui.base.MusicApplication;
import com.xiaomi.music.cloud.AccountUtils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class XiaomiMusicProxy {
    private static final String API_MIUI_HOST = "http://api.music.xiaomi.net/start";
    private static final String KEY_ACCOUNT = "account";
    public static final String KEY_ALBUM_NAME = "album_name";
    private static final String KEY_ALBUM_URL = "album_url";
    public static final String KEY_ARTIST_NAME = "artist_name";
    private static final String KEY_AVATAR_URL = "avatar_url";
    public static final String KEY_BIT_RATE = "bit_rate";
    private static final String KEY_CONTENT = "content";
    public static final String KEY_HAS_ALBUM_ART = "has_album_ART";
    public static final String KEY_HAS_AVATAR = "has_avatar";
    public static final String KEY_HAS_LYRIC = "has_lyric";
    private static final String KEY_ID = "id";
    public static final String KEY_IMEI = "imei";
    private static final String KEY_LOG_TYPE = "log_type";
    private static final String KEY_LYRIC_URL = "lyric_url";
    public static final String KEY_ONLINE_ID = "online_id";
    private static final String KEY_REQUEST_CONTENT = "request_content";
    private static final String KEY_S = "s";
    public static final String KEY_TIME_STAMP = "time_stamp";
    public static final String KEY_TRACK_NAME = "track_name";
    public static final String KEY_TRACK_TYPE = "track_type";
    private static final String KEY_VALUE = "value";
    public static final int LOG_META_CHANGED = 1;
    public static final int LOG_NETWORK_STATE_CHANGED = 2;
    public static final int LOG_STARTING_PLAYING = 0;
    private static final int REQUEST_ALBUM = 1;
    private static final int REQUEST_BOTH = 3;
    private static final int REQUEST_LYRIC = 2;
    private static final int REQUEST_NONE = 0;

    public static void postLog(final String trackName, final String albumName, final String artistName, final String log) {
        ThreadManager.postNetworkRequest(new Runnable() {
            public void run() {
                List<NameValuePair> params = new ArrayList();
                String idValue = null;
                try {
                    JSONStringer stringer = new JSONStringer().object().key("album_name").value(albumName).key("artist_name").value(artistName).key("track_name").value(trackName).key(XiaomiMusicProxy.KEY_REQUEST_CONTENT).value(0).key(XiaomiMusicProxy.KEY_LOG_TYPE).value(0);
                    String accountName = AccountUtils.getAccountName(MusicApplication.getApplication());
                    if (accountName != null) {
                        stringer.key("account").value(accountName);
                    }
                    idValue = stringer.endObject().toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                params.add(new BasicNameValuePair("id", idValue));
                params.add(new BasicNameValuePair(XiaomiMusicProxy.KEY_VALUE, new String(Base64.encodeBase64(log.getBytes()))));
                params.add(new BasicNameValuePair("s", SaltUtil.getKeyFromParams(params)));
                try {
                    NetworkUtil.doHttpPost(MusicApplication.getApplication(), XiaomiMusicProxy.API_MIUI_HOST, params);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                } catch (ClientProtocolException e3) {
                    e3.printStackTrace();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    public static String requestAlbumArt(ImageSearchInfo info) {
        List<NameValuePair> params = new ArrayList();
        String idValue = null;
        try {
            JSONStringer stringer = new JSONStringer().object().key("album_name").value(info.mAlbumName).key("artist_name").value(info.mArtistName).key("track_name").value(info.mTrackName).key(KEY_REQUEST_CONTENT).value(1).key(KEY_LOG_TYPE).value(1);
            String accountName = AccountUtils.getAccountName(MusicApplication.getApplication());
            if (accountName != null) {
                stringer.key("account").value(accountName);
            }
            idValue = stringer.endObject().toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.add(new BasicNameValuePair("id", idValue));
        params.add(new BasicNameValuePair("s", SaltUtil.getKeyFromParams(params)));
        String albumUrl = null;
        try {
            String result = NetworkUtil.doHttpPost(MusicApplication.getApplication(), API_MIUI_HOST, params);
            if (result != null) {
                albumUrl = new JSONObject(result).getJSONObject("content").optString("album_url", null);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (ClientProtocolException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        return albumUrl;
    }
}
