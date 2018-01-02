package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class gk {
    private static final gn f14213b;
    private static final Object f14214c = f14213b.mo2705a();
    final Object f14215a = f14213b.mo2706a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            f14213b = new go();
        } else if (VERSION.SDK_INT >= 14) {
            f14213b = new gl();
        } else {
            f14213b = new gq();
        }
    }

    Object m22115a() {
        return this.f14215a;
    }

    public void m22116a(View view, int i) {
        f14213b.mo2707a(f14214c, view, i);
    }

    public void m22117a(View view, AccessibilityEvent accessibilityEvent) {
        f14213b.mo2714d(f14214c, view, accessibilityEvent);
    }

    public boolean mo2961b(View view, AccessibilityEvent accessibilityEvent) {
        return f14213b.mo2710a(f14214c, view, accessibilityEvent);
    }

    public void m22122c(View view, AccessibilityEvent accessibilityEvent) {
        f14213b.mo2713c(f14214c, view, accessibilityEvent);
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        f14213b.mo2712b(f14214c, view, accessibilityEvent);
    }

    public void mo2862a(View view, mh mhVar) {
        f14213b.mo2708a(f14214c, view, mhVar);
    }

    public boolean mo2960a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f14213b.mo2711a(f14214c, viewGroup, view, accessibilityEvent);
    }

    public na m22114a(View view) {
        return f14213b.mo2704a(f14214c, view);
    }

    public boolean mo2863a(View view, int i, Bundle bundle) {
        return f14213b.mo2709a(f14214c, view, i, bundle);
    }
}
