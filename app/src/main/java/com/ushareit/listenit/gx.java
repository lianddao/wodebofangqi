package com.ushareit.listenit;

import android.os.Build.VERSION;

public final class gx {
    static final gy f14847a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f14847a = new ha();
        } else {
            f14847a = new gz();
        }
    }

    public static int m23080a(int i, int i2) {
        return f14847a.mo2744a(i, i2);
    }
}
