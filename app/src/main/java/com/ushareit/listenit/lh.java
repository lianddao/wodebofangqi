package com.ushareit.listenit;

import android.view.View;
import android.view.ViewParent;

class lh implements le {
    lh() {
    }

    public boolean mo2871a(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof ih) {
            return ((ih) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public void mo2872b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof ih) {
            ((ih) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }

    public void mo2866a(ViewParent viewParent, View view) {
        if (viewParent instanceof ih) {
            ((ih) viewParent).onStopNestedScroll(view);
        }
    }

    public void mo2867a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof ih) {
            ((ih) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void mo2868a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof ih) {
            ((ih) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean mo2870a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (viewParent instanceof ih) {
            return ((ih) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    public boolean mo2869a(ViewParent viewParent, View view, float f, float f2) {
        if (viewParent instanceof ih) {
            return ((ih) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }
}
