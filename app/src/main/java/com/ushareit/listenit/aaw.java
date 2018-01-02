package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

public class aaw implements aeb<ParcelFileDescriptor, Bitmap> {
    private final ux<File, Bitmap> f4006a;
    private final aax f4007b;
    private final aao f4008c = new aao();
    private final uu<ParcelFileDescriptor> f4009d = aaj.m4984b();

    public aaw(ws wsVar, ut utVar) {
        this.f4006a = new abr(new abj(wsVar, utVar));
        this.f4007b = new aax(wsVar, utVar);
    }

    public ux<File, Bitmap> mo561a() {
        return this.f4006a;
    }

    public ux<ParcelFileDescriptor, Bitmap> mo562b() {
        return this.f4007b;
    }

    public uu<ParcelFileDescriptor> mo563c() {
        return this.f4009d;
    }

    public uy<Bitmap> mo564d() {
        return this.f4008c;
    }
}
