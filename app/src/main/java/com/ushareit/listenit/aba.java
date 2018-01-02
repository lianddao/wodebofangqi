package com.ushareit.listenit;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class aba extends ConstantState {
    private static final Paint f4019d = new Paint(6);
    final Bitmap f4020a;
    int f4021b;
    Paint f4022c;

    public aba(Bitmap bitmap) {
        this.f4022c = f4019d;
        this.f4020a = bitmap;
    }

    aba(aba com_ushareit_listenit_aba) {
        this(com_ushareit_listenit_aba.f4020a);
        this.f4021b = com_ushareit_listenit_aba.f4021b;
    }

    void m5058a(ColorFilter colorFilter) {
        m5056a();
        this.f4022c.setColorFilter(colorFilter);
    }

    void m5057a(int i) {
        m5056a();
        this.f4022c.setAlpha(i);
    }

    void m5056a() {
        if (f4019d == this.f4022c) {
            this.f4022c = new Paint(6);
        }
    }

    public Drawable newDrawable() {
        return new aaz(null, this);
    }

    public Drawable newDrawable(Resources resources) {
        return new aaz(resources, this);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
