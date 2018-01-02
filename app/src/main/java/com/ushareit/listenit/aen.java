package com.ushareit.listenit;

import android.graphics.drawable.Drawable;

public class aen<T extends Drawable> implements aes<T> {
    private final aex<T> f4239a;
    private final int f4240b;
    private aep<T> f4241c;
    private aep<T> f4242d;

    public aen() {
        this(300);
    }

    public aen(int i) {
        this(new aex(new aeo(i)), i);
    }

    aen(aex<T> com_ushareit_listenit_aex_T, int i) {
        this.f4239a = com_ushareit_listenit_aex_T;
        this.f4240b = i;
    }

    public aeq<T> mo610a(boolean z, boolean z2) {
        if (z) {
            return aet.m5422b();
        }
        if (z2) {
            return m5410a();
        }
        return m5411b();
    }

    private aeq<T> m5410a() {
        if (this.f4241c == null) {
            this.f4241c = new aep(this.f4239a.mo610a(false, true), this.f4240b);
        }
        return this.f4241c;
    }

    private aeq<T> m5411b() {
        if (this.f4242d == null) {
            this.f4242d = new aep(this.f4239a.mo610a(false, false), this.f4240b);
        }
        return this.f4242d;
    }
}
