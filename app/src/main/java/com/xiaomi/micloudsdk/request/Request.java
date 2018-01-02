package com.xiaomi.micloudsdk.request;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.music.log.LogHelper;
import com.miui.player.meta.MetaManager;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import com.xiaomi.micloudsdk.utils.CloudUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.net.ExtendedAuthToken;
import miui.net.exception.MiCloudServerException;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class Request {
    private static final String COM_XIAOMI = "com.xiaomi";
    private static final int HTTP_URL_LENGTH_LIMIT = 1024;
    private static final int MAX_FILTER_TAG_COUNT = 100;
    private static final String PARAM_SYNC_FILTER_TAG = "filterTag";
    private static final String PARAM_SYNC_SIGNATURE = "signature";
    private static final String SERVICE_MICLOUD = "micloud";
    private static Context sContext;
    private static String sRegion;
    private static RequestEnv sRequestEnv = new DefaultRequestEnv();

    public interface RequestEnv {
        String getAccountName();

        void invalidateAuthToken();

        ExtendedAuthToken queryAuthToken();
    }

    public static class DefaultRequestEnv implements RequestEnv {
        private ExtendedAuthToken mExtendedAuthToken;

        public ExtendedAuthToken queryAuthToken() {
            try {
                Account account = CloudUtils.getXiaomiAccount();
                if (account == null) {
                    Log.e(CloudRequestHelper.MICLOUD_TAG, "no account in system");
                    return null;
                }
                String token = ((Bundle) AccountManager.get(Request.getContext()).getAuthToken(account, "micloud", true, null, null).getResult()).getString("authtoken");
                if (token == null) {
                    return null;
                }
                this.mExtendedAuthToken = ExtendedAuthToken.parse(token);
                return this.mExtendedAuthToken;
            } catch (IOException e) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "IOException when getting service token", e);
                return null;
            } catch (OperationCanceledException e2) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "OperationCanceledException when getting service token", e2);
                return null;
            } catch (AuthenticatorException e3) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "AuthenticatorException when getting service token", e3);
                return null;
            } catch (NullPointerException e4) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "NullPointerException when getting service token", e4);
                return null;
            }
        }

        public void invalidateAuthToken() {
            if (this.mExtendedAuthToken != null) {
                AccountManager.get(Request.getContext()).invalidateAuthToken(Request.COM_XIAOMI, this.mExtendedAuthToken.toPlain());
            }
        }

        public String getAccountName() {
            Account account = CloudUtils.getXiaomiAccount();
            if (account != null) {
                return account.name;
            }
            Log.e(CloudRequestHelper.MICLOUD_TAG, "no account in system");
            return null;
        }
    }

    private Request() {
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static void setRegion(String region) {
        sRegion = region;
    }

    public static void setRequestEnv(RequestEnv requestEnv) {
        sRequestEnv = requestEnv;
    }

    public static RequestEnv getRequestEnv() {
        return sRequestEnv;
    }

    public static String secureGet(String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.GET, params, null);
    }

    public static String secureGet(String url, Map<String, String> params, Map<String, String> additionalCookies) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.GET, params, additionalCookies);
    }

    public static String securePost(String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.POST, params, null);
    }

    public static String securePost(String url, Map<String, String> params, Map<String, String> additionalCookies) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.POST, params, additionalCookies);
    }

    public static String secureGet(String userId, ExtendedAuthToken extAuthToken, String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.GET, params, null);
    }

    public static String secureGet(String userId, ExtendedAuthToken extAuthToken, String url, Map<String, String> params, Map<String, String> cookies) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.GET, params, cookies);
    }

    public static String securePost(String userId, ExtendedAuthToken extAuthToken, String url, Map<String, String> params) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.POST, params, null);
    }

    public static String securePost(String userId, ExtendedAuthToken extAuthToken, String url, Map<String, String> params, Map<String, String> cookies) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        return execute(url, HttpMethod.POST, params, cookies);
    }

    private static String execute(String url, HttpMethod method, Map<String, String> params, Map<String, String> cookiesMap) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, ClientProtocolException, IOException, MiCloudServerException {
        Context context = getContext();
        if (!url.startsWith(CloudUtils.URL_RELOCATION_BASE)) {
            url = CloudUtils.updateRequestHost(url);
        }
        String response = MetaManager.UNKNOWN_STRING;
        int retry = 0;
        while (retry < 2) {
            ExtendedAuthToken extAuthToken = sRequestEnv.queryAuthToken();
            if (extAuthToken == null) {
                throw new MiCloudServerException(0);
            }
            if (params == null) {
                params = new HashMap();
            }
            ArrayList<NameValuePair> encodedParams = encodeParameters(extAuthToken.security, params);
            addSignatureParam(method, url, encodedParams, extAuthToken.security);
            Header cookies = getCookies(sRequestEnv.getAccountName(), extAuthToken.authToken, cookiesMap);
            try {
                if (HttpMethod.GET.equals(method)) {
                    return CloudRequestHelper.httpGetRequestWithDecodeData(CloudRequestHelper.appendUrl(url, encodedParams), cookies, extAuthToken.security);
                }
                if (HttpMethod.POST.equals(method)) {
                    return CloudRequestHelper.httpPostRequestWithDecodeData(url, new UrlEncodedFormEntity(encodedParams, "UTF-8"), cookies, extAuthToken.security);
                }
                throw new IllegalArgumentException("http method not supported.");
            } catch (MiCloudServerException e) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "MiCloudServer Exception: ", e);
                if (e.getStatusCode() == 401) {
                    if (retry == 0) {
                        Log.e(CloudRequestHelper.MICLOUD_TAG, "MiCloudServer 401 Exception: retry=" + retry, e);
                        sRequestEnv.invalidateAuthToken();
                    } else if (retry == 1) {
                        Log.e(CloudRequestHelper.MICLOUD_TAG, "MiCloudServer 401 Exception: retry=" + retry, e);
                        throw e;
                    }
                    retry++;
                } else {
                    CloudUtils.handleSendDataInTransferBroadCast(context, e);
                    throw e;
                }
            }
        }
        return response;
    }

    private static Header getCookies(String userId, String authToken, Map<String, String> cookies) {
        StringBuilder builder = new StringBuilder();
        builder.append("serviceToken=");
        builder.append(authToken);
        builder.append("; userId=");
        builder.append(userId);
        if (cookies != null && cookies.size() > 0) {
            for (String key : cookies.keySet()) {
                if (!(ThunderStoneKtvNetwork.JSON_TAG_USER_ID.equals(key) || "serviceToken".equals(key) || TextUtils.isEmpty(key))) {
                    builder.append("; " + key + LogHelper.SEPARATE_DOT);
                    builder.append((String) cookies.get(key));
                }
            }
        }
        return new BasicHeader("Cookie", builder.toString());
    }

    private static ArrayList<NameValuePair> encodeParameters(String security, Map<String, String> params) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        ArrayList<NameValuePair> encodedParams = new ArrayList(params.size());
        for (Entry<String, String> entry : params.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (!key.startsWith("_")) {
                if (value == null) {
                    value = MetaManager.UNKNOWN_STRING;
                }
                encodedParams.add(new BasicNameValuePair(key, CloudRequestHelper.encodeData(security, value)));
            }
        }
        return encodedParams;
    }

    private static void addSignatureParam(HttpMethod httpMethod, String url, ArrayList<NameValuePair> paramList, String security) throws UnsupportedEncodingException {
        paramList.add(new BasicNameValuePair("signature", CloudRequestHelper.getSignature(httpMethod, url, paramList, security)));
    }

    public static void addFilterTagsToParams(String url, Map<String, String> params, String security, Set<String> filterTags, long waterMark) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        ArrayList<NameValuePair> paramList = new ArrayList();
        for (Entry<String, String> param : params.entrySet()) {
            paramList.add(new BasicNameValuePair((String) param.getKey(), (String) param.getValue()));
        }
        StringBuilder finalTags = new StringBuilder();
        StringBuilder tmpTags = new StringBuilder();
        int size = 0;
        for (String tag : filterTags) {
            if (Long.parseLong(tag) > waterMark) {
                String stringBuilder;
                if (size < 100) {
                    if (tmpTags.length() != 0) {
                        tmpTags.append(",");
                    }
                    tmpTags.append(tag);
                    size++;
                    if (!(size % 10 == 0 || size == filterTags.size())) {
                    }
                }
                String str = PARAM_SYNC_FILTER_TAG;
                if (finalTags.length() == 0) {
                    stringBuilder = tmpTags.toString();
                } else {
                    stringBuilder = finalTags + "," + tmpTags;
                }
                NameValuePair filterParam = new BasicNameValuePair(str, CloudRequestHelper.encodeData(security, stringBuilder));
                paramList.add(filterParam);
                NameValuePair signatureParam = new BasicNameValuePair("signature", CloudRequestHelper.getSignature(HttpMethod.GET, url, paramList, security));
                paramList.add(signatureParam);
                int length = CloudRequestHelper.appendUrl(url, paramList).length();
                paramList.remove(filterParam);
                paramList.remove(signatureParam);
                if (length >= 1024) {
                    break;
                }
                if (finalTags.length() != 0) {
                    finalTags.append(",");
                }
                finalTags.append(tmpTags);
                tmpTags.setLength(0);
                if (size >= 1024) {
                    break;
                }
            }
        }
        String tagsText = finalTags.toString();
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "The filterTag is :" + tagsText);
        }
        params.put(PARAM_SYNC_FILTER_TAG, tagsText);
    }

    public static Context getContext() {
        if (sContext != null) {
            return sContext;
        }
        throw new IllegalStateException("sContext=null! Please call Request.init(Context) at Application onCreate");
    }

    public static String getRegion() {
        return sRegion;
    }
}
