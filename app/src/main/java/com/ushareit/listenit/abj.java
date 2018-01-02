package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.io.InputStream;

public class abj implements ux<InputStream, Bitmap> {
    private final aas f4042a;
    private ws f4043b;
    private ut f4044c;
    private String f4045d;

    public abj(ws wsVar, ut utVar) {
        this(aas.f4001a, wsVar, utVar);
    }

    public abj(aas com_ushareit_listenit_aas, ws wsVar, ut utVar) {
        this.f4042a = com_ushareit_listenit_aas;
        this.f4043b = wsVar;
        this.f4044c = utVar;
    }

    public wk<Bitmap> m5086a(InputStream inputStream, int i, int i2) {
        return aap.m5007a(this.f4042a.m5026a(inputStream, this.f4043b, i, i2, this.f4044c), this.f4043b);
    }

    public String mo566a() {
        if (this.f4045d == null) {
            this.f4045d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f4042a.mo560a() + this.f4044c.name();
        }
        return this.f4045d;
    }
}
