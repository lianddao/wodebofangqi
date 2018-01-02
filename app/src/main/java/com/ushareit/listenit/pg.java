package com.ushareit.listenit;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class pg {
    public static Object m25475a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m25480a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m25482b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m25483c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m25484d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m25476a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m25477a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m25478a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m25479a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void m25485e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m25486f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m25487g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }

    public static boolean m25481a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }
}
