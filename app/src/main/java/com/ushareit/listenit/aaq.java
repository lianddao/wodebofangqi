package com.ushareit.listenit;

import android.graphics.Bitmap;

public abstract class aaq implements uz<Bitmap> {
    private ws f4000a;

    protected abstract Bitmap mo558a(ws wsVar, Bitmap bitmap, int i, int i2);

    public aaq(ws wsVar) {
        this.f4000a = wsVar;
    }

    public final wk<Bitmap> mo556a(wk<Bitmap> wkVar, int i, int i2) {
        if (afu.m5498a(i, i2)) {
            Bitmap bitmap = (Bitmap) wkVar.mo553b();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a = mo558a(this.f4000a, bitmap, i, i2);
            if (bitmap.equals(a)) {
                return wkVar;
            }
            return aap.m5007a(a, this.f4000a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
