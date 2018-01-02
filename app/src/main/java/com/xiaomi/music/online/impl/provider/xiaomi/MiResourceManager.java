package com.xiaomi.music.online.impl.provider.xiaomi;

import android.content.Context;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.ResourceManager;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import com.xiaomi.music.online.model.ResourceSearchResult.Builder;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.SaltUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MiResourceManager implements ResourceManager {
    private static final String API_MIUI_HOST = "http://api.music.xiaomi.net/start";
    private static final String KEY_ALBUM_NAME = "album_name";
    private static final String KEY_ALBUM_URL = "album_url";
    private static final String KEY_ARTIST_NAME = "artist_name";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_ID = "id";
    private static final String KEY_LOG_TYPE = "log_type";
    private static final String KEY_LYRIC_URL = "lyric_url";
    private static final String KEY_REQUEST_CONTENT = "request_content";
    private static final String KEY_S = "s";
    private static final String KEY_STATUS = "status";
    private static final String KEY_TRACK_NAME = "track_name";
    private static final int LOG_META_CHANGED = 1;
    private static final int REQUEST_ALBUM = 1;
    private static final int REQUEST_BOTH = 3;
    private static final int REQUEST_LYRIC = 2;
    private static final int REQUEST_NONE = 0;
    private static final MiResourceManager sMiResourceManager = new MiResourceManager();

    private static class ResourceSearchResultParser implements Parser<Result<List<ResourceSearchResult>>, JSONObject> {
        private final ResourceSearchInfo mSearchInfo;

        public ResourceSearchResultParser(ResourceSearchInfo searchInfo) {
            this.mSearchInfo = searchInfo;
        }

        public Result<List<ResourceSearchResult>> parse(JSONObject from) {
            int errorCode = -1;
            List<ResourceSearchResult> data = null;
            if (!(from == null || from.optString("status", null) == null)) {
                JSONObject content = from.optJSONObject("content");
                if (content != null) {
                    errorCode = 1;
                    Builder builder = new Builder(this.mSearchInfo.mSearchType);
                    builder.setAlbumId(this.mSearchInfo.mAlbumId).setArtistId(this.mSearchInfo.mArtistId).setAlbumUrl(content.optString("album_url", null)).setLyricUrl(content.optString("lyric_url", null));
                    data = Lists.newArrayList();
                    data.add(builder.build());
                }
            }
            return Result.create(errorCode, data);
        }
    }

    private MiResourceManager() {
    }

    public static MiResourceManager instance() {
        return sMiResourceManager;
    }

    public int getId() {
        return 2;
    }

    public Result<List<ResourceSearchResult>> search(Context context, ResourceSearchInfo searchInfo) {
        return new ResourceSearchResultParser(searchInfo).parse(request(context, searchInfo));
    }

    public static JSONObject request(Context context, ResourceSearchInfo info) {
        List<NameValuePair> params = new ArrayList();
        String idValue = null;
        try {
            idValue = new JSONStringer().object().key("album_name").value(info.mAlbumName).key("artist_name").value(info.mArtistName).key("track_name").value(info.mTrackName).key(KEY_REQUEST_CONTENT).value(3).key(KEY_LOG_TYPE).value(1).endObject().toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.add(new BasicNameValuePair("id", idValue));
        params.add(new BasicNameValuePair("s", SaltUtil.getKeyFromParams(params)));
        try {
            String result = NetworkUtil.doHttpPost(context, API_MIUI_HOST, params);
            if (result != null) {
                return new JSONObject(result);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return null;
    }
}
