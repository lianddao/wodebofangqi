package com.ushareit.listenit;

import android.location.Location;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class djf implements bzs {
    private final Date f9842a;
    private final int f9843b;
    private final Set<String> f9844c;
    private final boolean f9845d;
    private final Location f9846e;
    private final int f9847f;
    private final NativeAdOptionsParcel f9848g;
    private final List<String> f9849h;
    private final boolean f9850i;

    public djf(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.f9842a = date;
        this.f9843b = i;
        this.f9844c = set;
        this.f9846e = location;
        this.f9845d = z;
        this.f9847f = i2;
        this.f9848g = nativeAdOptionsParcel;
        this.f9849h = list;
        this.f9850i = z2;
    }

    public Date mo1875a() {
        return this.f9842a;
    }

    public int mo1876b() {
        return this.f9843b;
    }

    public Set<String> mo1877c() {
        return this.f9844c;
    }

    public Location mo1878d() {
        return this.f9846e;
    }

    public int mo1879e() {
        return this.f9847f;
    }

    public boolean mo1880f() {
        return this.f9845d;
    }

    public boolean mo1881g() {
        return this.f9850i;
    }

    public buq mo1900h() {
        if (this.f9848g == null) {
            return null;
        }
        bus b = new bus().m9906a(this.f9848g.f1553b).m9904a(this.f9848g.f1554c).m9908b(this.f9848g.f1555d);
        if (this.f9848g.f1552a >= 2) {
            b.m9907b(this.f9848g.f1556e);
        }
        if (this.f9848g.f1552a >= 3 && this.f9848g.f1557f != null) {
            b.m9905a(new buj().m9886a(this.f9848g.f1557f.f1549b).m9885a());
        }
        return b.m9903a();
    }

    public boolean mo1901i() {
        return this.f9849h != null && this.f9849h.contains("2");
    }

    public boolean mo1902j() {
        return this.f9849h != null && this.f9849h.contains("1");
    }
}
