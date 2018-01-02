package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import java.io.InputStream;

public class acs implements ux<yv, acq> {
    private static final acu f4131a = new acu();
    private static final act f4132b = new act();
    private final ux<yv, Bitmap> f4133c;
    private final ux<InputStream, abx> f4134d;
    private final ws f4135e;
    private final acu f4136f;
    private final act f4137g;
    private String f4138h;

    public acs(ux<yv, Bitmap> uxVar, ux<InputStream, abx> uxVar2, ws wsVar) {
        this(uxVar, uxVar2, wsVar, f4131a, f4132b);
    }

    acs(ux<yv, Bitmap> uxVar, ux<InputStream, abx> uxVar2, ws wsVar, acu com_ushareit_listenit_acu, act com_ushareit_listenit_act) {
        this.f4133c = uxVar;
        this.f4134d = uxVar2;
        this.f4135e = wsVar;
        this.f4136f = com_ushareit_listenit_acu;
        this.f4137g = com_ushareit_listenit_act;
    }

    public wk<acq> m5239a(yv yvVar, int i, int i2) {
        afn a = afn.m5467a();
        byte[] b = a.m5469b();
        try {
            acq a2 = m5235a(yvVar, i, i2, b);
            return a2 != null ? new acr(a2) : null;
        } finally {
            a.m5468a(b);
        }
    }

    private acq m5235a(yv yvVar, int i, int i2, byte[] bArr) {
        if (yvVar.m27265a() != null) {
            return m5238b(yvVar, i, i2, bArr);
        }
        return m5237b(yvVar, i, i2);
    }

    private acq m5238b(yv yvVar, int i, int i2, byte[] bArr) {
        InputStream a = this.f4137g.m5242a(yvVar.m27265a(), bArr);
        a.mark(2048);
        ImageType a2 = this.f4136f.m5243a(a);
        a.reset();
        acq com_ushareit_listenit_acq = null;
        if (a2 == ImageType.GIF) {
            com_ushareit_listenit_acq = m5236a(a, i, i2);
        }
        if (com_ushareit_listenit_acq == null) {
            return m5237b(new yv(a, yvVar.m27266b()), i, i2);
        }
        return com_ushareit_listenit_acq;
    }

    private acq m5236a(InputStream inputStream, int i, int i2) {
        wk a = this.f4134d.mo565a(inputStream, i, i2);
        if (a == null) {
            return null;
        }
        abx com_ushareit_listenit_abx = (abx) a.mo553b();
        if (com_ushareit_listenit_abx.m5151e() > 1) {
            return new acq(null, a);
        }
        return new acq(new aap(com_ushareit_listenit_abx.m5147b(), this.f4135e), null);
    }

    private acq m5237b(yv yvVar, int i, int i2) {
        wk a = this.f4133c.mo565a(yvVar, i, i2);
        if (a != null) {
            return new acq(a, null);
        }
        return null;
    }

    public String mo566a() {
        if (this.f4138h == null) {
            this.f4138h = this.f4134d.mo566a() + this.f4133c.mo566a();
        }
        return this.f4138h;
    }
}
