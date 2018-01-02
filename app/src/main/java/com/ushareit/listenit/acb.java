package com.ushareit.listenit;

import android.graphics.Bitmap;

public class acb implements uz<abx> {
    private final uz<Bitmap> f4094a;
    private final ws f4095b;

    public acb(uz<Bitmap> uzVar, ws wsVar) {
        this.f4094a = uzVar;
        this.f4095b = wsVar;
    }

    public wk<abx> mo556a(wk<abx> wkVar, int i, int i2) {
        abx com_ushareit_listenit_abx = (abx) wkVar.mo553b();
        Bitmap b = ((abx) wkVar.mo553b()).m5147b();
        Bitmap bitmap = (Bitmap) this.f4094a.mo556a(new aap(b, this.f4095b), i, i2).mo553b();
        if (bitmap.equals(b)) {
            return wkVar;
        }
        return new aca(new abx(com_ushareit_listenit_abx, bitmap, this.f4094a));
    }

    public String mo557a() {
        return this.f4094a.mo557a();
    }
}
