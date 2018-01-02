package com.ushareit.listenit;

import android.graphics.Bitmap;

public final class eon extends fw<String, Bitmap> {
    public eon(int i) {
        super(i);
    }

    protected int m17266a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return super.mo2226a(str, bitmap);
    }
}
