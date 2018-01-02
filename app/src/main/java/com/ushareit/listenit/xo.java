package com.ushareit.listenit;

import java.io.File;

public class xo implements xh {
    private final int f17534a;
    private final xp f17535b;

    public xo(xp xpVar, int i) {
        this.f17534a = i;
        this.f17535b = xpVar;
    }

    public xg mo3138a() {
        File a = this.f17535b.mo3139a();
        if (a == null) {
            return null;
        }
        if (a.mkdirs() || (a.exists() && a.isDirectory())) {
            return xq.m27208a(a, this.f17534a);
        }
        return null;
    }
}
