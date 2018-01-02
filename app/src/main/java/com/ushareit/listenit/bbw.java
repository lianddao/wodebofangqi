package com.ushareit.listenit;

import com.facebook.internal.C0114v;

public enum bbw implements C0114v {
    MESSAGE_DIALOG(20140204),
    PHOTOS(20140324),
    VIDEO(20141218);
    
    private int f5881d;

    private bbw(int i) {
        this.f5881d = i;
    }

    public String mo834a() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    public int mo835b() {
        return this.f5881d;
    }
}
