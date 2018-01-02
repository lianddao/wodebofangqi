package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;

public class aax implements ux<ParcelFileDescriptor, Bitmap> {
    private final abl f4010a;
    private final ws f4011b;
    private ut f4012c;

    public aax(ws wsVar, ut utVar) {
        this(new abl(), wsVar, utVar);
    }

    public aax(abl com_ushareit_listenit_abl, ws wsVar, ut utVar) {
        this.f4010a = com_ushareit_listenit_abl;
        this.f4011b = wsVar;
        this.f4012c = utVar;
    }

    public wk<Bitmap> m5044a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        return aap.m5007a(this.f4010a.m5096a(parcelFileDescriptor, this.f4011b, i, i2, this.f4012c), this.f4011b);
    }

    public String mo566a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
