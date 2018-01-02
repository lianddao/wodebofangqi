package com.ushareit.listenit;

import android.content.Context;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.umeng.analytics.C0154a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class eub {
    private eud f11876a;
    private boolean f11877b = false;
    private Exception f11878c = null;

    eub(eud com_ushareit_listenit_eud) {
        this.f11876a = com_ushareit_listenit_eud;
    }

    public Exception m17965a() {
        return this.f11878c;
    }

    public boolean m17967b() {
        return this.f11877b;
    }

    public boolean m17966a(Context context, int i, String str) {
        int size;
        exw.m18443a("BeylaManager.UploadTask", "try to dispatch");
        List arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        this.f11877b = false;
        int i2 = 0;
        for (etq com_ushareit_listenit_etq : this.f11876a.m17979a((int) MoPubClientPositioning.NO_REPEAT)) {
            String c = com_ushareit_listenit_etq.m17922c();
            if (str == null || !str.equals(c)) {
                List a = this.f11876a.m17980a(c);
                if (a.size() + i2 > i) {
                    this.f11877b = true;
                    break;
                } else if (a.isEmpty()) {
                    arrayList.add(c);
                } else {
                    exw.m18443a("BeylaManager.UploadTask", "dispatch commit id:" + c + ", event count:" + a.size());
                    try {
                        com_ushareit_listenit_etq.m17920a(context);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(C0154a.f2941A, com_ushareit_listenit_etq.m17938s());
                        jSONObject.put("events", eto.m17906a(a));
                        jSONArray.put(jSONObject);
                        size = a.size() + i2;
                        try {
                            arrayList.add(c);
                        } catch (JSONException e) {
                            exu.m18432a("Serialize this upload package failed!");
                            i2 = size;
                        }
                    } catch (JSONException e2) {
                        size = i2;
                        exu.m18432a("Serialize this upload package failed!");
                        i2 = size;
                    }
                    i2 = size;
                }
            }
        }
        exw.m18443a("BeylaManager.UploadTask", "upload events count:" + i2);
        try {
            boolean z;
            if (jSONArray.length() == 0 || m17964a(jSONArray.toString())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                exw.m18449b("BeylaManager.UploadTask", "upload succeed!" + arrayList);
                if (!arrayList.isEmpty()) {
                    this.f11876a.m17983a(arrayList);
                }
            }
            return z;
        } catch (Throwable e3) {
            exw.m18444a("BeylaManager.UploadTask", "upload result failed!", e3);
            this.f11878c = e3;
            return false;
        }
    }

    private boolean m17964a(String str) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        boolean z = true;
        exw.m18443a("BeylaManager.UploadTask", "Upload contents:" + str);
        try {
            Object a = eui.m18005a(str);
            exu.m18430a(a);
            if (a == null || a.length == 0) {
                throw new IOException("encode packet failed!");
            }
            URL url = new URL(fbp.m18800a("%s?length=%d", m17962a(a[0]), Integer.valueOf(a.length)));
            exw.m18443a("BeylaManager.UploadTask", "post url:" + url);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setChunkedStreamingMode(0);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.addRequestProperty("Accept-Charset", "UTF-8");
                Closeable bufferedOutputStream = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                bufferedOutputStream.write(a);
                fbb.m18757a(bufferedOutputStream);
                int responseCode = httpURLConnection2.getResponseCode();
                bufferedOutputStream = httpURLConnection2.getInputStream();
                String a2 = m17963a((InputStream) bufferedOutputStream);
                fbb.m18757a(bufferedOutputStream);
                exw.m18449b("BeylaManager.UploadTask", "upload status code:" + responseCode + (200 == responseCode ? "" : ", cause:" + a2));
                if (responseCode != 200) {
                    z = false;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return z;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private String m17963a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        try {
            return new String(bArr, 0, inputStream.read(bArr), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    private static String m17962a(byte b) {
        if (b >= (byte) 3) {
            return euo.m18017a(eys.m18562a(), "beyla_use_https", true) ? "https://dts.ushareit.com" : "http://dts.ushareit.com";
        } else {
            try {
                return "https://dts.ushareit.com";
            } catch (Exception e) {
                return "https://dts.ushareit.com";
            }
        }
    }
}
