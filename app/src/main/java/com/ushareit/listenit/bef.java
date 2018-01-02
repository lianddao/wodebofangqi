package com.ushareit.listenit;

import com.umeng.analytics.pro.C0277j;

@Deprecated
public final class bef {
    public static final bef f5989a = new bef(-1, -2, "mb");
    public static final bef f5990b = new bef(320, 50, "mb");
    public static final bef f5991c = new bef(300, 250, "as");
    public static final bef f5992d = new bef(468, 60, "as");
    public static final bef f5993e = new bef(728, 90, "as");
    public static final bef f5994f = new bef(C0277j.f3691b, 600, "as");
    private final bua f5995g;

    private bef(int i, int i2, String str) {
        this(new bua(i, i2));
    }

    public bef(bua com_ushareit_listenit_bua) {
        this.f5995g = com_ushareit_listenit_bua;
    }

    public int m7883a() {
        return this.f5995g.m9862b();
    }

    public int m7884b() {
        return this.f5995g.m9860a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bef)) {
            return false;
        }
        return this.f5995g.equals(((bef) obj).f5995g);
    }

    public int hashCode() {
        return this.f5995g.hashCode();
    }

    public String toString() {
        return this.f5995g.toString();
    }
}
