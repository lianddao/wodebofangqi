package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class aar extends aaq {
    public aar(ws wsVar) {
        super(wsVar);
    }

    protected Bitmap mo558a(ws wsVar, Bitmap bitmap, int i, int i2) {
        Bitmap a = wsVar.mo3128a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        Bitmap a2 = abk.m5091a(a, bitmap, i, i2);
        if (!(a == null || a == a2 || wsVar.mo3131a(a))) {
            a.recycle();
        }
        return a2;
    }

    public String mo557a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
