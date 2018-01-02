package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

public class abi implements aeb<InputStream, Bitmap> {
    private final abj f4038a;
    private final aao f4039b;
    private final zh f4040c = new zh();
    private final abr<Bitmap> f4041d;

    public abi(ws wsVar, ut utVar) {
        this.f4038a = new abj(wsVar, utVar);
        this.f4039b = new aao();
        this.f4041d = new abr(this.f4038a);
    }

    public ux<File, Bitmap> mo561a() {
        return this.f4041d;
    }

    public ux<InputStream, Bitmap> mo562b() {
        return this.f4038a;
    }

    public uu<InputStream> mo563c() {
        return this.f4040c;
    }

    public uy<Bitmap> mo564d() {
        return this.f4039b;
    }
}
