package com.ushareit.listenit;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class dha extends bup {
    private final dgx f9800a;
    private final Drawable f9801b;
    private final Uri f9802c;
    private final double f9803d;

    public dha(dgx com_ushareit_listenit_dgx) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.f9800a = com_ushareit_listenit_dgx;
        try {
            ckg a = this.f9800a.mo1193a();
            if (a != null) {
                drawable = (Drawable) ckj.m11513a(a);
                this.f9801b = drawable;
                uri = this.f9800a.mo1194b();
                this.f9802c = uri;
                d = 1.0d;
                d = this.f9800a.mo1195c();
                this.f9803d = d;
            }
        } catch (Throwable e) {
            bze.m10489b("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.f9801b = drawable;
        try {
            uri = this.f9800a.mo1194b();
        } catch (Throwable e2) {
            bze.m10489b("Failed to get uri.", e2);
        }
        this.f9802c = uri;
        d = 1.0d;
        try {
            d = this.f9800a.mo1195c();
        } catch (Throwable e3) {
            bze.m10489b("Failed to get scale.", e3);
        }
        this.f9803d = d;
    }

    public Drawable mo1761a() {
        return this.f9801b;
    }

    public Uri mo1762b() {
        return this.f9802c;
    }

    public double mo1763c() {
        return this.f9803d;
    }
}
