package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class lc {
    static final le f15623a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f15623a = new lg();
        } else if (i >= 19) {
            f15623a = new lf();
        } else if (i >= 14) {
            f15623a = new ld();
        } else {
            f15623a = new lh();
        }
    }

    public static boolean m24411a(ViewParent viewParent, View view, View view2, int i) {
        return f15623a.mo2871a(viewParent, view, view2, i);
    }

    public static void m24412b(ViewParent viewParent, View view, View view2, int i) {
        f15623a.mo2872b(viewParent, view, view2, i);
    }

    public static void m24406a(ViewParent viewParent, View view) {
        f15623a.mo2866a(viewParent, view);
    }

    public static void m24407a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f15623a.mo2867a(viewParent, view, i, i2, i3, i4);
    }

    public static void m24408a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f15623a.mo2868a(viewParent, view, i, i2, iArr);
    }

    public static boolean m24410a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f15623a.mo2870a(viewParent, view, f, f2, z);
    }

    public static boolean m24409a(ViewParent viewParent, View view, float f, float f2) {
        return f15623a.mo2869a(viewParent, view, f, f2);
    }
}
