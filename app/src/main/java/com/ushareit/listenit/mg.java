package com.ushareit.listenit;

import android.view.accessibility.AccessibilityEvent;

class mg {
    public static void m24878a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    public static int m24877a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
