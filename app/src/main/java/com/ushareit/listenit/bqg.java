package com.ushareit.listenit;

import android.text.TextUtils;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class bqg {
    public final String f7416a;
    public final String f7417b;
    public final boolean f7418c;
    public final boolean f7419d;
    public final int f7420e;
    public final int f7421f;
    public final boolean f7422g;
    public final int f7423h;
    public final int f7424i;
    public final boolean f7425j;

    public bqg() {
        this(null, null, false, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true);
    }

    public bqg(String str, String str2, boolean z, boolean z2, int i, int i2, boolean z3, int i3, int i4, boolean z4) {
        this.f7416a = str;
        this.f7417b = str2;
        this.f7418c = z;
        this.f7419d = z2;
        this.f7420e = i;
        this.f7421f = i2;
        this.f7422g = z3;
        this.f7423h = i3;
        this.f7424i = i4;
        this.f7425j = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bqg com_ushareit_listenit_bqg = (bqg) obj;
        if (this.f7418c == com_ushareit_listenit_bqg.f7418c && this.f7419d == com_ushareit_listenit_bqg.f7419d && this.f7420e == com_ushareit_listenit_bqg.f7420e && this.f7421f == com_ushareit_listenit_bqg.f7421f && this.f7422g == com_ushareit_listenit_bqg.f7422g && this.f7425j == com_ushareit_listenit_bqg.f7425j && this.f7423h == com_ushareit_listenit_bqg.f7423h && this.f7424i == com_ushareit_listenit_bqg.f7424i && TextUtils.equals(this.f7416a, com_ushareit_listenit_bqg.f7416a) && TextUtils.equals(this.f7417b, com_ushareit_listenit_bqg.f7417b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int hashCode = ((this.f7418c ? 1 : 0) + (((this.f7416a.hashCode() * 31) + this.f7417b.hashCode()) * 31)) * 31;
        if (this.f7419d) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (((((i + hashCode) * 31) + this.f7420e) * 31) + this.f7421f) * 31;
        if (this.f7422g) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + hashCode) * 31;
        if (!this.f7425j) {
            i2 = 0;
        }
        return ((((i + i2) * 31) + this.f7423h) * 31) + this.f7424i;
    }
}
