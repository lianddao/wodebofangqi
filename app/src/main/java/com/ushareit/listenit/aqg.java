package com.ushareit.listenit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class aqg {
    private int f5181a;
    private String f5182b;
    private Map<String, List<String>> f5183c;
    private byte[] f5184d;

    public aqg(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f5181a = httpURLConnection.getResponseCode();
            this.f5182b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f5183c = httpURLConnection.getHeaderFields();
        this.f5184d = bArr;
    }

    public int m6776a() {
        return this.f5181a;
    }

    public String m6777b() {
        return this.f5182b;
    }

    public Map<String, List<String>> m6778c() {
        return this.f5183c;
    }

    public byte[] m6779d() {
        return this.f5184d;
    }

    public String m6780e() {
        return this.f5184d != null ? new String(this.f5184d) : null;
    }
}
