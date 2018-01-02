package com.ushareit.listenit;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class jt {
    public static boolean m24353a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m24354b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m24352a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
