package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

public class abe implements ux<yv, Bitmap> {
    private final ux<InputStream, Bitmap> f4027a;
    private final ux<ParcelFileDescriptor, Bitmap> f4028b;

    public abe(ux<InputStream, Bitmap> uxVar, ux<ParcelFileDescriptor, Bitmap> uxVar2) {
        this.f4027a = uxVar;
        this.f4028b = uxVar2;
    }

    public wk<Bitmap> m5072a(yv yvVar, int i, int i2) {
        wk<Bitmap> a;
        ParcelFileDescriptor b;
        InputStream a2 = yvVar.m27265a();
        if (a2 != null) {
            try {
                a = this.f4027a.mo565a(a2, i, i2);
            } catch (Throwable e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            if (a == null) {
                return a;
            }
            b = yvVar.m27266b();
            if (b == null) {
                return this.f4028b.mo565a(b, i, i2);
            }
            return a;
        }
        a = null;
        if (a == null) {
            return a;
        }
        b = yvVar.m27266b();
        if (b == null) {
            return a;
        }
        return this.f4028b.mo565a(b, i, i2);
    }

    public String mo566a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
