package com.ushareit.listenit;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.umeng.analytics.pro.C0277j;

public final class bua {
    public static final bua f7753a = new bua(320, 50, "320x50_mb");
    public static final bua f7754b = new bua(468, 60, "468x60_as");
    public static final bua f7755c = new bua(320, 100, "320x100_as");
    public static final bua f7756d = new bua(728, 90, "728x90_as");
    public static final bua f7757e = new bua(300, 250, "300x250_as");
    public static final bua f7758f = new bua(C0277j.f3691b, 600, "160x600_as");
    public static final bua f7759g = new bua(-1, -2, "smart_banner");
    public static final bua f7760h = new bua(-3, -4, "fluid");
    public static final bua f7761i = new bua(-3, 0, "search_v2");
    private final int f7762j;
    private final int f7763k;
    private final String f7764l;

    public bua(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String valueOf3 = String.valueOf("_as");
        this(i, i2, new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append("x").append(valueOf2).append(valueOf3).toString());
    }

    bua(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f7762j = i;
            this.f7763k = i2;
            this.f7764l = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int m9860a() {
        return this.f7763k;
    }

    public int m9861a(Context context) {
        switch (this.f7763k) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.m2147b(context.getResources().getDisplayMetrics());
            default:
                return bwt.m10268a().m10466a(context, this.f7763k);
        }
    }

    public int m9862b() {
        return this.f7762j;
    }

    public int m9863b(Context context) {
        switch (this.f7762j) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.m2145a(context.getResources().getDisplayMetrics());
            default:
                return bwt.m10268a().m10466a(context, this.f7762j);
        }
    }

    public boolean m9864c() {
        return this.f7762j == -3 && this.f7763k == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bua)) {
            return false;
        }
        bua com_ushareit_listenit_bua = (bua) obj;
        return this.f7762j == com_ushareit_listenit_bua.f7762j && this.f7763k == com_ushareit_listenit_bua.f7763k && this.f7764l.equals(com_ushareit_listenit_bua.f7764l);
    }

    public int hashCode() {
        return this.f7764l.hashCode();
    }

    public String toString() {
        return this.f7764l;
    }
}
