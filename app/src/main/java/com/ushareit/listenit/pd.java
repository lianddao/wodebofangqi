package com.ushareit.listenit;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class pd implements pc {
    pd() {
    }

    public Object mo2981a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public boolean mo2986a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int mo2988b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int mo2989c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float mo2990d(Object obj) {
        return 0.0f;
    }

    public boolean mo2991e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void mo2982a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    public void mo2983a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void mo2984a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void mo2985a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void mo2992f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int mo2993g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int mo2994h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }

    public boolean mo2987a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return false;
    }
}
