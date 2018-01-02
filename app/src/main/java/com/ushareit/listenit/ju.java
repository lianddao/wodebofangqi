package com.ushareit.listenit;

import android.view.View;
import android.view.ViewParent;

class ju {
    public static boolean m24359a(View view) {
        return view.hasTransientState();
    }

    public static void m24360b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m24356a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m24357a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m24358a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m24361c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m24355a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static ViewParent m24362d(View view) {
        return view.getParentForAccessibility();
    }

    public static int m24363e(View view) {
        return view.getMinimumWidth();
    }

    public static int m24364f(View view) {
        return view.getMinimumHeight();
    }

    public static boolean m24365g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m24366h(View view) {
        return view.hasOverlappingRendering();
    }
}
