package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Log;
import com.mopub.volley.DefaultRetryPolicy;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class vf implements vc<InputStream> {
    private static final vi f17033a = new vh();
    private final yq f17034b;
    private final vi f17035c;
    private HttpURLConnection f17036d;
    private InputStream f17037e;
    private volatile boolean f17038f;

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m26698b(tvVar);
    }

    public vf(yq yqVar) {
        this(yqVar, f17033a);
    }

    vf(yq yqVar, vi viVar) {
        this.f17034b = yqVar;
        this.f17035c = viVar;
    }

    public InputStream m26698b(tv tvVar) {
        return m26695a(this.f17034b.m27254a(), 0, null, this.f17034b.m27255b());
    }

    private InputStream m26695a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.f17036d = this.f17035c.mo3107a(url);
        for (Entry entry : map.entrySet()) {
            this.f17036d.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        this.f17036d.setConnectTimeout(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
        this.f17036d.setReadTimeout(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
        this.f17036d.setUseCaches(false);
        this.f17036d.setDoInput(true);
        this.f17036d.connect();
        if (this.f17038f) {
            return null;
        }
        int responseCode = this.f17036d.getResponseCode();
        if (responseCode / 100 == 2) {
            return m26694a(this.f17036d);
        }
        if (responseCode / 100 == 3) {
            Object headerField = this.f17036d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                return m26695a(new URL(url, headerField), i + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + responseCode + ": " + this.f17036d.getResponseMessage());
        }
    }

    private InputStream m26694a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f17037e = afo.m5471a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f17037e = httpURLConnection.getInputStream();
        }
        return this.f17037e;
    }

    public void mo585a() {
        if (this.f17037e != null) {
            try {
                this.f17037e.close();
            } catch (IOException e) {
            }
        }
        if (this.f17036d != null) {
            this.f17036d.disconnect();
        }
    }

    public String mo586b() {
        return this.f17034b.m27256c();
    }

    public void mo587c() {
        this.f17038f = true;
    }
}
