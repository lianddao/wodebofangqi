package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class abw implements um {
    private final ws f4068a;

    public abw(ws wsVar) {
        this.f4068a = wsVar;
    }

    public Bitmap mo570a(int i, int i2, Config config) {
        return this.f4068a.mo3132b(i, i2, config);
    }

    public void mo571a(Bitmap bitmap) {
        if (!this.f4068a.mo3131a(bitmap)) {
            bitmap.recycle();
        }
    }
}
