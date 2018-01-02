package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.os.Bundle;

public final class dh extends dp {
    public static final dq f9793a = new di();
    private static final dj f9794g;
    private final String f9795b;
    private final CharSequence f9796c;
    private final CharSequence[] f9797d;
    private final boolean f9798e;
    private final Bundle f9799f;

    public String mo1756a() {
        return this.f9795b;
    }

    public CharSequence mo1757b() {
        return this.f9796c;
    }

    public CharSequence[] mo1758c() {
        return this.f9797d;
    }

    public boolean mo1759d() {
        return this.f9798e;
    }

    public Bundle mo1760e() {
        return this.f9799f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f9794g = new dk();
        } else if (VERSION.SDK_INT >= 16) {
            f9794g = new dm();
        } else {
            f9794g = new dl();
        }
    }
}
