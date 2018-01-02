package com.ushareit.listenit;

import android.graphics.Bitmap;

public class acq {
    private final wk<abx> f4128a;
    private final wk<Bitmap> f4129b;

    public acq(wk<Bitmap> wkVar, wk<abx> wkVar2) {
        if (wkVar != null && wkVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (wkVar == null && wkVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.f4129b = wkVar;
            this.f4128a = wkVar2;
        }
    }

    public int m5228a() {
        if (this.f4129b != null) {
            return this.f4129b.mo554c();
        }
        return this.f4128a.mo554c();
    }

    public wk<Bitmap> m5229b() {
        return this.f4129b;
    }

    public wk<abx> m5230c() {
        return this.f4128a;
    }
}
