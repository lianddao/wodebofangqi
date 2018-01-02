package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class pb {
    Object f16108a;
    pc f16109b;

    public static pb m25418a(Context context, Interpolator interpolator) {
        return new pb(VERSION.SDK_INT, context, interpolator);
    }

    private pb(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f16109b = new pf();
        } else if (i >= 9) {
            this.f16109b = new pe();
        } else {
            this.f16109b = new pd();
        }
        this.f16108a = this.f16109b.mo2981a(context, interpolator);
    }

    public boolean m25423a() {
        return this.f16109b.mo2986a(this.f16108a);
    }

    public int m25425b() {
        return this.f16109b.mo2988b(this.f16108a);
    }

    public int m25426c() {
        return this.f16109b.mo2989c(this.f16108a);
    }

    public int m25427d() {
        return this.f16109b.mo2993g(this.f16108a);
    }

    public int m25428e() {
        return this.f16109b.mo2994h(this.f16108a);
    }

    public float m25429f() {
        return this.f16109b.mo2990d(this.f16108a);
    }

    public boolean m25430g() {
        return this.f16109b.mo2991e(this.f16108a);
    }

    public void m25419a(int i, int i2, int i3, int i4) {
        this.f16109b.mo2982a(this.f16108a, i, i2, i3, i4);
    }

    public void m25420a(int i, int i2, int i3, int i4, int i5) {
        this.f16109b.mo2983a(this.f16108a, i, i2, i3, i4, i5);
    }

    public void m25421a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f16109b.mo2984a(this.f16108a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m25422a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f16109b.mo2985a(this.f16108a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m25424a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f16109b.mo2987a(this.f16108a, i, i2, i3, i4, i5, i6);
    }

    public void m25431h() {
        this.f16109b.mo2992f(this.f16108a);
    }
}
