package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.io.OutputStream;

public class acv implements uy<acq> {
    private final uy<Bitmap> f4139a;
    private final uy<abx> f4140b;
    private String f4141c;

    public acv(uy<Bitmap> uyVar, uy<abx> uyVar2) {
        this.f4139a = uyVar;
        this.f4140b = uyVar2;
    }

    public boolean m5245a(wk<acq> wkVar, OutputStream outputStream) {
        acq com_ushareit_listenit_acq = (acq) wkVar.mo553b();
        wk b = com_ushareit_listenit_acq.m5229b();
        if (b != null) {
            return this.f4139a.mo552a(b, outputStream);
        }
        return this.f4140b.mo552a(com_ushareit_listenit_acq.m5230c(), outputStream);
    }

    public String mo551a() {
        if (this.f4141c == null) {
            this.f4141c = this.f4139a.mo551a() + this.f4140b.mo551a();
        }
        return this.f4141c;
    }
}
