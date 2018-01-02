package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class om {
    private static final op f16063b;
    private Object f16064a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f16063b = new oq();
        } else if (VERSION.SDK_INT >= 14) {
            f16063b = new oo();
        } else {
            f16063b = new on();
        }
    }

    public om(Context context) {
        this.f16064a = f16063b.mo2972a(context);
    }

    public void m25315a(int i, int i2) {
        f16063b.mo2973a(this.f16064a, i, i2);
    }

    public boolean m25316a() {
        return f16063b.mo2974a(this.f16064a);
    }

    public void m25321b() {
        f16063b.mo2979b(this.f16064a);
    }

    @Deprecated
    public boolean m25317a(float f) {
        return f16063b.mo2975a(this.f16064a, f);
    }

    public boolean m25318a(float f, float f2) {
        return f16063b.mo2976a(this.f16064a, f, f2);
    }

    public boolean m25322c() {
        return f16063b.mo2980c(this.f16064a);
    }

    public boolean m25319a(int i) {
        return f16063b.mo2977a(this.f16064a, i);
    }

    public boolean m25320a(Canvas canvas) {
        return f16063b.mo2978a(this.f16064a, canvas);
    }
}
