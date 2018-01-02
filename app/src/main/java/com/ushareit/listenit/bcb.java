package com.ushareit.listenit;

import com.facebook.internal.C0114v;

public enum bcb implements C0114v {
    OG_MESSAGE_DIALOG(20140204);
    
    private int f5892b;

    private bcb(int i) {
        this.f5892b = i;
    }

    public String mo834a() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    public int mo835b() {
        return this.f5892b;
    }
}
