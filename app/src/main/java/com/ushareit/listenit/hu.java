package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class hu {
    static final ib f15576a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f15576a = new ia();
        } else if (VERSION.SDK_INT >= 12) {
            f15576a = new hz();
        } else if (VERSION.SDK_INT >= 9) {
            f15576a = new hy();
        } else if (VERSION.SDK_INT >= 5) {
            f15576a = new hx();
        } else {
            f15576a = new hw();
        }
    }

    public static int m24051a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m24053b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m24052a(MotionEvent motionEvent, int i) {
        return f15576a.mo2800a(motionEvent, i);
    }

    public static int m24054b(MotionEvent motionEvent, int i) {
        return f15576a.mo2802b(motionEvent, i);
    }

    public static float m24055c(MotionEvent motionEvent, int i) {
        return f15576a.mo2803c(motionEvent, i);
    }

    public static float m24057d(MotionEvent motionEvent, int i) {
        return f15576a.mo2804d(motionEvent, i);
    }

    public static int m24056c(MotionEvent motionEvent) {
        return f15576a.mo2799a(motionEvent);
    }

    public static int m24058d(MotionEvent motionEvent) {
        return f15576a.mo2801b(motionEvent);
    }

    public static float m24059e(MotionEvent motionEvent, int i) {
        return f15576a.mo2805e(motionEvent, i);
    }
}
