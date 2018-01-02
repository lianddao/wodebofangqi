package com.ushareit.listenit;

import com.mopub.common.Constants;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class ezm {
    public static HttpClient m18636a(int i, int i2, boolean z) {
        ClientConnectionManager singleClientConnManager;
        HttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("; charset=", "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(Constants.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        if (z) {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        } else {
            singleClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        }
        return new DefaultHttpClient(singleClientConnManager, basicHttpParams);
    }

    public static HttpClient m18635a(int i, int i2) {
        return m18636a(i, i2, false);
    }

    public static String m18633a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            exu.m18432a(e.getMessage());
            return null;
        }
    }

    public static Map<String, String> m18634a(HttpResponse httpResponse) {
        Header[] allHeaders = httpResponse.getAllHeaders();
        Map<String, String> hashMap = new HashMap();
        for (Header header : allHeaders) {
            hashMap.put(header.getName(), header.getValue());
        }
        return hashMap;
    }

    public static ezt m18631a(String str, Map<String, String> map, Map<String, String> map2, int i, int i2) {
        Throwable th;
        exw.m18449b("HttpUtils", "post url -> " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        Writer writer;
        try {
            ezt com_ushareit_listenit_ezt;
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setInstanceFollowRedirects(true);
            if (map != null && map.size() > 0) {
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (map2 != null) {
                if (map2.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Writer outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    try {
                        Object obj = 1;
                        for (Entry entry2 : map2.entrySet()) {
                            Object obj2;
                            if (obj != null) {
                                obj2 = null;
                            } else {
                                outputStreamWriter.write("&");
                                stringBuilder.append("&");
                                obj2 = obj;
                            }
                            outputStreamWriter.append((CharSequence) entry2.getKey()).append("=").append(m18633a((String) entry2.getValue()));
                            stringBuilder.append((String) entry2.getKey()).append("=").append(m18633a((String) entry2.getValue()));
                            obj = obj2;
                        }
                        outputStreamWriter.flush();
                        exw.m18443a("HttpUtils", "post params: " + stringBuilder);
                        writer = outputStreamWriter;
                        com_ushareit_listenit_ezt = new ezt(httpURLConnection);
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (IOException e) {
                            }
                        }
                        httpURLConnection.disconnect();
                        exw.m18449b("HttpUtils", "response" + com_ushareit_listenit_ezt.m18641a());
                        return com_ushareit_listenit_ezt;
                    } catch (Throwable th2) {
                        th = th2;
                        writer = outputStreamWriter;
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (IOException e2) {
                            }
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
            }
            writer = null;
            try {
                com_ushareit_listenit_ezt = new ezt(httpURLConnection);
                if (writer != null) {
                    writer.close();
                }
                httpURLConnection.disconnect();
                exw.m18449b("HttpUtils", "response" + com_ushareit_listenit_ezt.m18641a());
                return com_ushareit_listenit_ezt;
            } catch (Throwable th3) {
                th = th3;
                if (writer != null) {
                    writer.close();
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            writer = null;
            if (writer != null) {
                writer.close();
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public static ezt m18630a(String str, Map<String, String> map, int i, int i2) {
        return m18631a(str, null, map, i, i2);
    }

    public static ezt m18632a(String str, byte[] bArr, int i, int i2) {
        OutputStream bufferedOutputStream;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder(str);
        exw.m18449b("HttpUtils", "post buffer url -> " + stringBuilder.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(stringBuilder.toString()).openConnection();
        try {
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            if (bArr != null) {
                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            }
            bufferedOutputStream = null;
            ezt com_ushareit_listenit_ezt = new ezt(httpURLConnection);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                }
            }
            httpURLConnection.disconnect();
            return com_ushareit_listenit_ezt;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
