package com.ushareit.listenit;

import android.text.TextUtils;

public class gnj {
    public String f14449a;
    public String f14450b;
    public String f14451c;
    public String f14452d;
    public String f14453e;
    public String f14454f;

    public String toString() {
        return "NetAlbumInfo{name='" + this.f14449a + '\'' + ", artist='" + this.f14450b + '\'' + ", smallImage='" + this.f14451c + '\'' + ", mediumImage='" + this.f14452d + '\'' + ", largeImage='" + this.f14453e + '\'' + ", extraLargeImage='" + this.f14454f + '\'' + '}';
    }

    public String m22500a() {
        if (!TextUtils.isEmpty(this.f14454f)) {
            return this.f14454f;
        }
        if (!TextUtils.isEmpty(this.f14453e)) {
            return this.f14453e;
        }
        if (TextUtils.isEmpty(this.f14452d)) {
            return this.f14451c;
        }
        return this.f14452d;
    }
}
