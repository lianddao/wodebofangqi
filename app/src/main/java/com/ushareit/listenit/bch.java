package com.ushareit.listenit;

import com.facebook.internal.C0114v;

public enum bch implements C0114v {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028);
    
    private int f5900d;

    private bch(int i) {
        this.f5900d = i;
    }

    public String mo834a() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    public int mo835b() {
        return this.f5900d;
    }
}
