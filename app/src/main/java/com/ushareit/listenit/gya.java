package com.ushareit.listenit;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class gya extends Scroller {
    private int f14896a = 400;

    public gya(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f14896a);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f14896a);
    }

    public void m23122a(int i) {
        this.f14896a = i;
    }
}
