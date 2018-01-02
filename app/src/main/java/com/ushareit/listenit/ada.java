package com.ushareit.listenit;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class ada implements adb<Bitmap, aaz> {
    private final Resources f4150a;
    private final ws f4151b;

    public ada(Resources resources, ws wsVar) {
        this.f4150a = resources;
        this.f4151b = wsVar;
    }

    public wk<aaz> mo588a(wk<Bitmap> wkVar) {
        return new abb(new aaz(this.f4150a, (Bitmap) wkVar.mo553b()), this.f4151b);
    }

    public String mo589a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
