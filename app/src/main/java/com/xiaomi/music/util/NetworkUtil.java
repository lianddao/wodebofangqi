package com.xiaomi.music.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.baidu.music.download.DownloadStatus;
import com.baidu.music.log.LogHelper;
import com.miui.player.meta.MetaManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class NetworkUtil {
    public static final int HTTP_CONNECTION_TIMEOUT_MS = 8000;
    public static final int HTTP_SO_TIMEOUT_MS = 15000;
    static final String TAG = "NetworkUtil";
    public static final String UserAgent_PC_Chrome = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
    public static final String UserAgent_PC_Chrome_6_0_464_0 = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
    private static boolean sAllowNetwork = false;

    public static String concatAsUrl(String url, Map<String, String> nameValues) {
        if (nameValues == null || nameValues.isEmpty()) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        for (Entry<String, String> entry : nameValues.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append(LogHelper.SEPARATE_DOT);
            sb.append(encode((String) entry.getValue()));
            sb.append("&");
        }
        int len = sb.length();
        if (len > 0) {
            sb.deleteCharAt(len - 1);
        }
        return sb.toString();
    }

    public static InputStream doHttpGet(String strUrl) throws URISyntaxException, ClientProtocolException, IOException {
        return doHttpGet(strUrl, 8000, HTTP_SO_TIMEOUT_MS);
    }

    public static InputStream doHttpGet(String strUrl, int connTimeOut, int soTimeOut) throws URISyntaxException, ClientProtocolException, IOException {
        return doHttpGet(strUrl, connTimeOut, soTimeOut, null);
    }

    public static InputStream doHttpGet(String strUrl, int connTimeOut, int soTimeOut, long[] len) throws URISyntaxException, ClientProtocolException, IOException {
        if (!URLUtil.isHttpUrl(strUrl) && !URLUtil.isHttpsUrl(strUrl)) {
            return null;
        }
        HttpGet httpRequest = new HttpGet(new URL(strUrl).toURI());
        httpRequest.setHeader("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3");
        httpRequest.setHeader("Accept-Encoding", "gzip");
        HttpParams httpParameters = new BasicHttpParams();
        if (connTimeOut > 0) {
            HttpConnectionParams.setConnectionTimeout(httpParameters, connTimeOut);
        }
        if (soTimeOut > 0) {
            HttpConnectionParams.setSoTimeout(httpParameters, soTimeOut);
        }
        HttpResponse response = SecurityGruadian.executeRequest(newHttpClient(httpParameters), httpRequest);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode >= 300) {
            return null;
        }
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return null;
        }
        BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
        InputStream content = bufHttpEntity.getContent();
        Header[] headers = response.getHeaders("Content-Encoding");
        if (headers != null) {
            for (Header header : headers) {
                String value = header.getValue();
                if (value != null && "gzip".equals(value.toLowerCase())) {
                    content = new GZIPInputStream(content);
                    break;
                }
            }
        }
        if (len == null) {
            return content;
        }
        len[0] = bufHttpEntity.getContentLength();
        return content;
    }

    public static String encode(String src) {
        if (src != null) {
            try {
                return URLEncoder.encode(src, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return MetaManager.UNKNOWN_STRING;
    }

    public static String concat(String connector, List<String> args) {
        StringBuilder sb = new StringBuilder();
        if (!(args == null || args.isEmpty())) {
            for (String v : args) {
                if (v != null) {
                    sb.append(v);
                }
                sb.append(connector);
            }
            int len = sb.length();
            sb.delete(len - connector.length(), len);
        }
        return sb.toString();
    }

    public static int getActiveNetworkType(Context context) {
        return SecurityGruadian.getActiveNetworkType(context);
    }

    public static boolean isActive(Context context) {
        return getActiveNetworkType(context) >= 0;
    }

    public static boolean isActiveNetworkMetered(Context context) {
        return SecurityGruadian.isActiveNetworkMetered(context);
    }

    public static String doHttpPost(Context context, String url, List<NameValuePair> nameValuePairs) throws IOException {
        return doHttpPost(context, url, nameValuePairs, null, null, null);
    }

    public static String doHttpPost(Context context, String url, List<NameValuePair> nameValuePairs, Map<String, String> headers, String userAgent, String cookie) throws IOException {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url");
        }
        BasicHttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 5000);
        if (!TextUtils.isEmpty(userAgent)) {
            httpParameters.setParameter("User-agent", userAgent);
        }
        if (!TextUtils.isEmpty(cookie)) {
            httpParameters.setParameter("Cookie", cookie);
        }
        HttpClient httpclient = newHttpClient(httpParameters);
        HttpPost httppost = new HttpPost(url);
        if (!(nameValuePairs == null || nameValuePairs.size() == 0)) {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        }
        HttpResponse response = SecurityGruadian.executeRequest(httpclient, httppost);
        int statusCode = response.getStatusLine().getStatusCode();
        Log.d(TAG, "Http POST Response Code: " + statusCode);
        if (statusCode < 200 || statusCode >= DownloadStatus.STATUS_BASE_2) {
            return null;
        }
        if (headers != null) {
            Header[] _headers = response.getAllHeaders();
            for (int i = 0; i < _headers.length; i++) {
                headers.put(_headers[i].getName(), _headers[i].getValue());
            }
        }
        HttpEntity body = response.getEntity();
        if (body != null) {
            String result = EntityUtils.toString(body);
            if (result != null) {
                return result;
            }
        }
        return MetaManager.UNKNOWN_STRING;
    }

    public static String doHttpPost(String url, JSONObject js) throws IOException {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url");
        }
        HttpParams parms = new BasicHttpParams();
        parms.setParameter(AlixDefine.charset, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(parms, 5000);
        HttpConnectionParams.setSoTimeout(parms, 8000);
        HttpClient httpclient = newHttpClient(parms);
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader(MIME.CONTENT_TYPE, "application/json");
        httppost.addHeader(AlixDefine.charset, "UTF-8");
        httppost.setEntity(new StringEntity(js.toString(), "UTF-8"));
        HttpResponse response = SecurityGruadian.executeRequest(httpclient, httppost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode >= DownloadStatus.STATUS_BASE_2) {
            return null;
        }
        HttpEntity body = response.getEntity();
        if (body != null) {
            String result = EntityUtils.toString(body);
            if (result != null) {
                return result;
            }
        }
        return MetaManager.UNKNOWN_STRING;
    }

    public static InputStream doHttpGet(String strUrl, Header cookie) throws ClientProtocolException, URISyntaxException, IOException {
        return doHttpGet(strUrl, cookie, 8000, (int) HTTP_SO_TIMEOUT_MS);
    }

    public static InputStream doHttpGet(String strUrl, Header cookie, int connTimeOut, int soTimeOut) throws URISyntaxException, ClientProtocolException, IOException {
        if (!URLUtil.isHttpUrl(strUrl) && !URLUtil.isHttpsUrl(strUrl)) {
            return null;
        }
        HttpGet httpRequest = new HttpGet(new URL(strUrl).toURI());
        httpRequest.addHeader(cookie);
        HttpParams httpParameters = new BasicHttpParams();
        if (connTimeOut > 0) {
            HttpConnectionParams.setConnectionTimeout(httpParameters, connTimeOut);
        }
        if (soTimeOut > 0) {
            HttpConnectionParams.setSoTimeout(httpParameters, soTimeOut);
        }
        HttpResponse response = SecurityGruadian.executeRequest(newHttpClient(httpParameters), httpRequest);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode >= DownloadStatus.STATUS_BASE_2) {
            return null;
        }
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return new BufferedHttpEntity(entity).getContent();
        }
        return null;
    }

    public static HttpClient newHttpClient(HttpParams params) throws IOException {
        if (sAllowNetwork) {
            return new DefaultHttpClient(params);
        }
        throw new IOException("Network is disallow!");
    }

    public static void setNetworkAllow(boolean allow) {
        sAllowNetwork = allow;
    }

    public static boolean isNetworkAllow() {
        return sAllowNetwork;
    }
}
