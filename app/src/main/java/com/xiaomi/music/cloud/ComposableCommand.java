package com.xiaomi.music.cloud;

import android.accounts.Account;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.cloud.impl.CloudParsers;
import com.xiaomi.music.cloud.impl.CloudUrls;
import com.xiaomi.music.cloud.impl.MusicCloudUtils;
import com.xiaomi.music.parser.Parser;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ComposableCommand<T> extends CloudCommand<T> {
    static final String TAG = "CloudCommand[ComposableCommand]";

    protected abstract JSONObject getParameters() throws JSONException;

    protected abstract Parser<T, JSONObject> getParser();

    protected abstract String getPath();

    public ComposableCommand(Account account, MusicAuthToken token) {
        super(account, token);
    }

    public Result<T> toResult(JSONObject from) throws JSONException {
        return CloudParsers.parse(from, getParser());
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("path", getPath().substring(CloudUrls.URL_HOST_BASE.length()));
        JSONObject params = getParameters();
        if (params != null) {
            obj.put(CloudJsonTag.TAG_PARAMS, params);
            return obj;
        }
        throw new NullPointerException("parameters must be non null");
    }

    public Result<T> execute() throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        String url = getPath();
        JSONObject json = getParameters();
        ArrayList<NameValuePair> params = null;
        if (json != null) {
            params = Lists.newArrayList();
            Iterator<String> it = json.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                params.add(new BasicNameValuePair(key, json.get(key).toString()));
            }
        }
        String str = MusicCloudUtils.postToCloud(url, params, this.mAccount, this.mToken);
        MusicLog.m399i(TAG, "Raw: " + str);
        Result<T> result = CloudParsers.parse(new JSONObject(str), getParser());
        MusicLog.m399i(TAG, "Result: " + result);
        return result;
    }
}
