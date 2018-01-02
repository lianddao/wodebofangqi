package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class pv extends Animation {
    final /* synthetic */ int f16290a;
    final /* synthetic */ int f16291b;
    final /* synthetic */ SwipeRefreshLayout f16292c;

    public pv(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f16292c = swipeRefreshLayout;
        this.f16290a = i;
        this.f16291b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f16292c.f243C.setAlpha((int) (((float) this.f16290a) + (((float) (this.f16291b - this.f16290a)) * f)));
    }
}
