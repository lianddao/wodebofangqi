package com.ushareit.listenit;

import android.graphics.Bitmap;

public class aap implements wk<Bitmap> {
    private final Bitmap f3998a;
    private final ws f3999b;

    public /* synthetic */ Object mo553b() {
        return m5008a();
    }

    public static aap m5007a(Bitmap bitmap, ws wsVar) {
        if (bitmap == null) {
            return null;
        }
        return new aap(bitmap, wsVar);
    }

    public aap(Bitmap bitmap, ws wsVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (wsVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.f3998a = bitmap;
            this.f3999b = wsVar;
        }
    }

    public Bitmap m5008a() {
        return this.f3998a;
    }

    public int mo554c() {
        return afu.m5492a(this.f3998a);
    }

    public void mo555d() {
        if (!this.f3999b.mo3131a(this.f3998a)) {
            this.f3998a.recycle();
        }
    }
}
