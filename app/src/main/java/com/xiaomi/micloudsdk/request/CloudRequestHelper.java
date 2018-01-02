package com.xiaomi.micloudsdk.request;

import android.accounts.Account;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.music.log.LogHelper;
import com.miui.player.meta.MetaManager;
import com.miui.player.vod.ThunderStoneKtvNetwork;
import com.xiaomi.micloudsdk.utils.CloudUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import miui.net.CloudCoder;
import miui.net.ExtendedAuthToken;
import miui.net.MiCloudHttpClient;
import miui.net.SecureRequest;
import miui.net.exception.CipherException;
import miui.net.exception.MiCloudServerException;
import miui.util.ObjectUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class CloudRequestHelper {
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final int HTTP_REQUEST_TIMEOUT_MS = 30000;
    public static final int HTTP_URL_LENGTH_LIMIT = 1024;
    private static final int MAX_FILTER_TAG_COUNT = 100;
    public static final String MICLOUD_TAG = "Micloud";
    private static final String PARAM_SYNC_FILTER_TAG = "filterTag";

    enum HttpMethod {
        GET,
        POST
    }

    private CloudRequestHelper() {
    }

    public static HttpClient getHttpClient() {
        HttpClient httpClient = MiCloudHttpClient.newInstance();
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 30000);
        HttpConnectionParams.setSoTimeout(params, 30000);
        ConnManagerParams.setTimeout(params, 30000);
        return httpClient;
    }

    private static String httpPostRequest(String url, HttpEntity entity, Header cookies, String security, int redirectCount) throws ClientProtocolException, IOException, MiCloudServerException, IllegalBlockSizeException, BadPaddingException {
        HttpPost post = new HttpPost(url);
        if (entity != null) {
            post.setHeader(entity.getContentType());
            post.setEntity(entity);
        }
        if (cookies != null) {
            post.setHeader(cookies);
        }
        post.setHeader(HEADER_ACCEPT_ENCODING, ENCODING_GZIP);
        if (redirectCount > 0) {
            post.setHeader(CloudUtils.X_XIAOMI_REDIRECT_COUNT, redirectCount + MetaManager.UNKNOWN_STRING);
        }
        post.setHeader(CloudUtils.X_XIAOMI_SUPPORT_REDIRECT, "true");
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, "http post url : " + url);
            Log.d(MICLOUD_TAG, "http post cookies : " + cookies.toString());
        }
        HttpResponse resp = getHttpClient().execute(post);
        int statusCode = resp.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String response = decodeData(security, decodeGZip(resp));
            String redirectUrl = CloudUtils.checkRedirect(response, redirectCount);
            if (TextUtils.isEmpty(redirectUrl)) {
                return response;
            }
            return httpPostRequest(redirectUrl, entity, cookies, security, redirectCount + 1);
        } else if (MiCloudServerException.isMiCloudServerException(statusCode)) {
            Log.e(MICLOUD_TAG, "MiCloudServerException: " + statusCode + " " + resp.getStatusLine());
            throw new MiCloudServerException(statusCode, resp);
        } else {
            Log.e(MICLOUD_TAG, "Server error: " + statusCode + " " + resp.getStatusLine());
            throw new IOException("Server error: " + statusCode + " " + resp.getStatusLine());
        }
    }

    public static String httpPostRequestWithDecodeData(String url, HttpEntity entity, Header cookies, String security) throws ClientProtocolException, IOException, IllegalBlockSizeException, BadPaddingException, MiCloudServerException {
        String response = httpPostRequest(url, entity, cookies, security, 0);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, response);
        }
        return response;
    }

    public static String httpGetRequestWithDecodeData(String url, Header cookies, String security) throws ClientProtocolException, IOException, IllegalBlockSizeException, BadPaddingException, MiCloudServerException {
        String response = httpGetRequest(url, cookies, security, 0);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, response);
        }
        return response;
    }

    private static String httpGetRequest(String url, Header cookies, String security, int redirectCount) throws ClientProtocolException, IOException, MiCloudServerException, IllegalBlockSizeException, BadPaddingException {
        HttpGet request = new HttpGet(url);
        request.setHeader(cookies);
        request.setHeader(HEADER_ACCEPT_ENCODING, ENCODING_GZIP);
        if (redirectCount > 0) {
            request.setHeader(CloudUtils.X_XIAOMI_REDIRECT_COUNT, redirectCount + MetaManager.UNKNOWN_STRING);
        }
        request.setHeader(CloudUtils.X_XIAOMI_SUPPORT_REDIRECT, "true");
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, "http get url : " + url);
            Log.d(MICLOUD_TAG, "http get cookies : " + cookies.toString());
        }
        HttpResponse resp = getHttpClient().execute(request);
        int statusCode = resp.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String response = decodeData(security, decodeGZip(resp));
            String redirectUrl = CloudUtils.checkRedirect(response, redirectCount);
            if (TextUtils.isEmpty(redirectUrl)) {
                return response;
            }
            return httpGetRequest(redirectUrl, cookies, security, redirectCount + 1);
        } else if (MiCloudServerException.isMiCloudServerException(statusCode)) {
            Log.e(MICLOUD_TAG, "MiCloudServerException: " + statusCode + " " + resp.getStatusLine());
            throw new MiCloudServerException(statusCode, resp);
        } else {
            Log.e(MICLOUD_TAG, "Server error: " + statusCode + " " + resp.getStatusLine());
            throw new IOException("Server error: " + statusCode + " " + resp.getStatusLine());
        }
    }

    public static Header getCookies(Account account, ExtendedAuthToken extToken) {
        StringBuilder builder = new StringBuilder();
        builder.append("serviceToken=");
        builder.append(extToken.authToken);
        builder.append("; userId=");
        builder.append(account.name);
        return new BasicHeader("Cookie", builder.toString());
    }

    public static Map<String, String> getCookiesAsMap(Account account, ExtendedAuthToken extToken) {
        HashMap<String, String> map = new HashMap();
        map.put("serviceToken", extToken.authToken);
        map.put(ThunderStoneKtvNetwork.JSON_TAG_USER_ID, account.name);
        return map;
    }

    public static String appendUrl(String origin, List<NameValuePair> nameValuePairs) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        if (origin == null) {
            throw new NullPointerException("origin is not allowed null");
        }
        StringBuilder urlBuilder = new StringBuilder(origin);
        if (!origin.contains("?")) {
            urlBuilder.append("?");
        }
        for (int i = 0; i < nameValuePairs.size(); i++) {
            if (i != 0) {
                urlBuilder.append("&");
            }
            String name = ((NameValuePair) nameValuePairs.get(i)).getName();
            String value = ((NameValuePair) nameValuePairs.get(i)).getValue();
            urlBuilder.append(name);
            urlBuilder.append(LogHelper.SEPARATE_DOT);
            urlBuilder.append(URLEncoder.encode(value, "UTF-8"));
        }
        String url = urlBuilder.toString();
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, "result url length is: " + url.length());
        }
        return url;
    }

    public static void addFilterTagsToParams(String url, Map<String, String> params, String security, Set<String> filterTags) throws CipherException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        if (filterTags != null && !filterTags.isEmpty()) {
            ArrayList<String> allFilters = new ArrayList(filterTags);
            int limit = Math.min(filterTags.size(), 100);
            while (limit > 0) {
                params.put(PARAM_SYNC_FILTER_TAG, TextUtils.join(",", allFilters.subList(0, limit)));
                if (appendUrl(url, ObjectUtils.mapToPairs(SecureRequest.encryptParams("GET", url, params, security))).length() >= 1024) {
                    limit /= 2;
                } else {
                    return;
                }
            }
            params.remove(PARAM_SYNC_FILTER_TAG);
        }
    }

    public static String encodeData(String security, String data) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return Base64.encodeToString(CloudCoder.newAESCipher(security, 1).doFinal(data.getBytes("UTF-8")), 2);
    }

    public static String decodeData(String security, InputStream is) throws IllegalBlockSizeException, BadPaddingException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is), 1024);
        while (true) {
            try {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }
        }
        String result = builder.toString();
        if (result.length() == 0) {
            return result;
        }
        try {
            String result2 = new String(CloudCoder.newAESCipher(security, 2).doFinal(Base64.decode(result, 2)));
            return result2;
        } catch (IllegalArgumentException e2) {
            if (Log.isLoggable(MICLOUD_TAG, 3)) {
                Log.d(MICLOUD_TAG, "base64 decode failed, content : " + result);
            }
            throw new IOException();
        }
    }

    public static String getSignature(HttpMethod httpMethod, String url, ArrayList<NameValuePair> paramList, String security) throws UnsupportedEncodingException {
        TreeMap<String, String> params = new TreeMap();
        if (paramList != null) {
            Iterator i$ = paramList.iterator();
            while (i$.hasNext()) {
                NameValuePair pair = (NameValuePair) i$.next();
                params.put(pair.getName(), pair.getValue());
            }
        }
        return CloudCoder.generateSignature(httpMethod.name(), url, params, security);
    }

    public static boolean checkWifiAvailability(Context context) {
        return !((ConnectivityManager) context.getSystemService("connectivity")).isActiveNetworkMetered();
    }

    static InputStream decodeGZip(HttpResponse resp) throws IllegalStateException, IOException {
        Header contentEncoding = resp.getFirstHeader("Content-Encoding");
        if (contentEncoding == null || !contentEncoding.getValue().equalsIgnoreCase(ENCODING_GZIP)) {
            return resp.getEntity().getContent();
        }
        return new GZIPInputStream(resp.getEntity().getContent());
    }
}
