package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class mb {
    private static final mf f15942a;

    static {
        if (VERSION.SDK_INT >= 19) {
            f15942a = new md();
        } else if (VERSION.SDK_INT >= 14) {
            f15942a = new mc();
        } else {
            f15942a = new me();
        }
    }

    public static nn m24868a(AccessibilityEvent accessibilityEvent) {
        return new nn(accessibilityEvent);
    }

    public static void m24869a(AccessibilityEvent accessibilityEvent, int i) {
        f15942a.mo2894a(accessibilityEvent, i);
    }

    public static int m24870b(AccessibilityEvent accessibilityEvent) {
        return f15942a.mo2893a(accessibilityEvent);
    }
}
