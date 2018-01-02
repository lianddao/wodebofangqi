package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class gu {
    public static Object m22797a(gw gwVar) {
        return new gv(gwVar);
    }

    public static Object m22798a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m22799a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
