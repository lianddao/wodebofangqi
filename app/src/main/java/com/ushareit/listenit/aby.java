package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class aby extends ConstantState {
    uo f4081a;
    byte[] f4082b;
    Context f4083c;
    uz<Bitmap> f4084d;
    int f4085e;
    int f4086f;
    um f4087g;
    ws f4088h;
    Bitmap f4089i;

    public aby(uo uoVar, byte[] bArr, Context context, uz<Bitmap> uzVar, int i, int i2, um umVar, ws wsVar, Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        this.f4081a = uoVar;
        this.f4082b = bArr;
        this.f4088h = wsVar;
        this.f4089i = bitmap;
        this.f4083c = context.getApplicationContext();
        this.f4084d = uzVar;
        this.f4085e = i;
        this.f4086f = i2;
        this.f4087g = umVar;
    }

    public Drawable newDrawable(Resources resources) {
        return newDrawable();
    }

    public Drawable newDrawable() {
        return new abx(this);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
