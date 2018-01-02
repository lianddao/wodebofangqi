package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

public class yq {
    private final URL f17577a;
    private final yr f17578b;
    private final String f17579c;
    private String f17580d;
    private URL f17581e;

    public yq(URL url) {
        this(url, yr.f17583b);
    }

    public yq(String str) {
        this(str, yr.f17583b);
    }

    public yq(URL url, yr yrVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        } else if (yrVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f17577a = url;
            this.f17579c = null;
            this.f17578b = yrVar;
        }
    }

    public yq(String str, yr yrVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        } else if (yrVar == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f17579c = str;
            this.f17577a = null;
            this.f17578b = yrVar;
        }
    }

    public URL m27254a() {
        return m27252d();
    }

    private URL m27252d() {
        if (this.f17581e == null) {
            this.f17581e = new URL(m27253e());
        }
        return this.f17581e;
    }

    private String m27253e() {
        if (TextUtils.isEmpty(this.f17580d)) {
            String str = this.f17579c;
            if (TextUtils.isEmpty(str)) {
                str = this.f17577a.toString();
            }
            this.f17580d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f17580d;
    }

    public Map<String, String> m27255b() {
        return this.f17578b.mo3149a();
    }

    public String m27256c() {
        return this.f17579c != null ? this.f17579c : this.f17577a.toString();
    }

    public String toString() {
        return m27256c() + '\n' + this.f17578b.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yq)) {
            return false;
        }
        yq yqVar = (yq) obj;
        if (m27256c().equals(yqVar.m27256c()) && this.f17578b.equals(yqVar.f17578b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (m27256c().hashCode() * 31) + this.f17578b.hashCode();
    }
}
