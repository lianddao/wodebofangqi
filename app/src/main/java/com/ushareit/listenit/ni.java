package com.ushareit.listenit;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ni extends AccessibilityNodeProvider {
    final /* synthetic */ nj f16038a;

    ni(nj njVar) {
        this.f16038a = njVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f16038a.mo2944a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f16038a.mo2945a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f16038a.mo2946a(i, i2, bundle);
    }
}
