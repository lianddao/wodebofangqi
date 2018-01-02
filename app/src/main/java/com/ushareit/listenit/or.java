package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class or {
    public static Object m25351a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m25352a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m25353a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m25357b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m25354a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m25358c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m25355a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m25356a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
