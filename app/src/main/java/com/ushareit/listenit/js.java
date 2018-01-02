package com.ushareit.listenit;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;
import com.mopub.volley.DefaultRetryPolicy;

class js {
    static long m24336a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m24334a(View view) {
        return view.getAlpha();
    }

    public static void m24339a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m24341b(View view) {
        return view.getLayerType();
    }

    public static int m24335a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m24344c(View view) {
        return view.getMeasuredState();
    }

    public static float m24346d(View view) {
        return view.getTranslationX();
    }

    public static float m24348e(View view) {
        return view.getTranslationY();
    }

    public static float m24350f(View view) {
        return view.getScaleX();
    }

    public static void m24337a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m24342b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m24345c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m24347d(View view, float f) {
        view.setScaleX(f);
    }

    public static void m24349e(View view, float f) {
        view.setScaleY(f);
    }

    public static void m24340a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    static void m24338a(View view, int i) {
        view.offsetTopAndBottom(i);
        m24351g(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m24351g((View) parent);
        }
    }

    static void m24343b(View view, int i) {
        view.offsetLeftAndRight(i);
        m24351g(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m24351g((View) parent);
        }
    }

    private static void m24351g(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT + translationY);
        view.setTranslationY(translationY);
    }
}
