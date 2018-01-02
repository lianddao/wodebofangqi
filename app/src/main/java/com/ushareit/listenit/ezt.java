package com.ushareit.listenit;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class ezt {
    private Map<String, List<String>> f12257a;
    private String f12258b;
    private int f12259c;
    private String f12260d;

    ezt(HttpURLConnection httpURLConnection) {
        this.f12257a = httpURLConnection.getHeaderFields();
        this.f12259c = httpURLConnection.getResponseCode();
        this.f12260d = httpURLConnection.getResponseMessage();
        Closeable closeable = null;
        try {
            closeable = httpURLConnection.getInputStream();
        } catch (IOException e) {
            closeable = httpURLConnection.getErrorStream();
        } catch (Throwable th) {
            fbb.m18757a(closeable);
        }
        if (closeable != null) {
            this.f12258b = fbb.m18753a((InputStream) closeable, true);
        }
        fbb.m18757a(closeable);
    }

    public String m18641a() {
        return this.f12258b;
    }

    public int m18642b() {
        return this.f12259c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UrlResponse [statusCode=").append(this.f12259c).append(", statusMessage=").append(this.f12260d).append(",content=").append(this.f12258b).append("]");
        return stringBuilder.toString();
    }
}
