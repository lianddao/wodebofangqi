package com.ushareit.listenit;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class nl extends AccessibilityNodeProvider {
    final /* synthetic */ nm f16039a;

    nl(nm nmVar) {
        this.f16039a = nmVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f16039a.mo2947a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f16039a.mo2948a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f16039a.mo2949a(i, i2, bundle);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f16039a.mo2950b(i);
    }
}
