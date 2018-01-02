package com.ushareit.listenit;

import com.facebook.internal.C0114v;

public enum bbu implements C0114v {
    LIKE_DIALOG(20140701);
    
    private int f5875b;

    private bbu(int i) {
        this.f5875b = i;
    }

    public String mo834a() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    public int mo835b() {
        return this.f5875b;
    }
}
