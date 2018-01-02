package com.ushareit.listenit;

import java.util.List;
import java.util.Map;

class dxm implements Runnable {
    private final dxl f10569a;
    private final int f10570b;
    private final Throwable f10571c;
    private final byte[] f10572d;
    private final String f10573e;
    private final Map<String, List<String>> f10574f;

    private dxm(String str, dxl com_ushareit_listenit_dxl, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        cfi.m11080a((Object) com_ushareit_listenit_dxl);
        this.f10569a = com_ushareit_listenit_dxl;
        this.f10570b = i;
        this.f10571c = th;
        this.f10572d = bArr;
        this.f10573e = str;
        this.f10574f = map;
    }

    public void run() {
        this.f10569a.mo2107a(this.f10573e, this.f10570b, this.f10571c, this.f10572d, this.f10574f);
    }
}
