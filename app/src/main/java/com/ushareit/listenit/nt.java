package com.ushareit.listenit;

import android.view.accessibility.AccessibilityRecord;

class nt {
    public static void m25260a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m25262b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m25263c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public static void m25264d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public static void m25261a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m25265e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
