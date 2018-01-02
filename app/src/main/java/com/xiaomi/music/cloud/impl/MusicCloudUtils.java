package com.xiaomi.music.cloud.impl;

import android.accounts.Account;
import com.xiaomi.music.Result;
import com.xiaomi.music.cloud.MusicAuthToken;
import com.xiaomi.music.cloud.MusicCloudServerException;
import com.xiaomi.music.cloud.model.MetaList;
import com.xiaomi.music.util.MusicLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.NameValuePair;
import org.json.JSONException;

public class MusicCloudUtils {
    static final String TAG = "MusicCloudUtils";

    public interface RepeatCommand<E, L extends MetaList<E>> {
        Result<L> requestOnce(String str, String str2, int i) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException;
    }

    private MusicCloudUtils() {
    }

    public static String postToCloud(String url, ArrayList<NameValuePair> parameters, Account account, MusicAuthToken token) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException {
        if (parameters == null) {
            parameters = new ArrayList();
        }
        Map<String, String> params = new HashMap();
        Iterator i$ = parameters.iterator();
        while (i$.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) i$.next();
            params.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        return CloudNetworkUtils.postToCloud(account.name, token.getAuthToken(), token.getSecurity(), url, params);
    }

    public static String getFromCloud(String url, ArrayList<NameValuePair> parameters, Account account, MusicAuthToken token) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException {
        if (parameters == null) {
            parameters = new ArrayList();
        }
        Map<String, String> params = new HashMap();
        Iterator i$ = parameters.iterator();
        while (i$.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) i$.next();
            params.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        return CloudNetworkUtils.getFromCloud(account.name, token.getAuthToken(), token.getSecurity(), url, params);
    }

    public static <E, L extends MetaList<E>> Result<L> repeatRequest(String url, RepeatCommand<E, L> cmd, String initTag, int limit, int maxLimitAtOnce) throws IllegalBlockSizeException, BadPaddingException, IOException, MusicCloudServerException, JSONException {
        if (limit <= 0) {
            MusicLog.m404w(TAG, "Bad limit, limit=" + limit);
        }
        int error = -1;
        Result<L> result = null;
        int remain = limit;
        String tag = initTag;
        int i = 0;
        while (remain > 0) {
            Result<L> r = cmd.requestOnce(url, tag, Math.min(remain, maxLimitAtOnce));
            int i2 = i + 1;
            MusicLog.m395d(TAG, "Repeat request: " + i + "  " + result);
            if (r.mErrorCode == 0) {
                if (r.mData == null) {
                    MusicLog.m397e(TAG, "error code is ok, but data is null");
                    error = -1;
                    break;
                }
                error = 0;
                remain -= ((MetaList) r.mData).getItems().size();
                tag = ((MetaList) r.mData).getSyncTag();
                if (result == null) {
                    result = r;
                } else {
                    ((MetaList) result.mData).append((MetaList) r.mData);
                }
                if (((MetaList) r.mData).isLastPage()) {
                    break;
                }
                i = i2;
            } else {
                error = r.mErrorCode;
                break;
            }
        }
        return error == 0 ? result : Result.create(error);
    }
}
