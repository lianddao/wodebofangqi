package com.ushareit.listenit;

import android.graphics.Bitmap;

public class acx implements uz<acq> {
    private final uz<Bitmap> f4143a;
    private final uz<abx> f4144b;

    public acx(ws wsVar, uz<Bitmap> uzVar) {
        this((uz) uzVar, new acb(uzVar, wsVar));
    }

    acx(uz<Bitmap> uzVar, uz<abx> uzVar2) {
        this.f4143a = uzVar;
        this.f4144b = uzVar2;
    }

    public wk<acq> mo556a(wk<acq> wkVar, int i, int i2) {
        wk b = ((acq) wkVar.mo553b()).m5229b();
        wk c = ((acq) wkVar.mo553b()).m5230c();
        if (b != null && this.f4143a != null) {
            wk a = this.f4143a.mo556a(b, i, i2);
            if (b.equals(a)) {
                return wkVar;
            }
            return new acr(new acq(a, ((acq) wkVar.mo553b()).m5230c()));
        } else if (c == null || this.f4144b == null) {
            return wkVar;
        } else {
            b = this.f4144b.mo556a(c, i, i2);
            if (c.equals(b)) {
                return wkVar;
            }
            return new acr(new acq(((acq) wkVar.mo553b()).m5229b(), b));
        }
    }

    public String mo557a() {
        return this.f4143a.mo557a();
    }
}
