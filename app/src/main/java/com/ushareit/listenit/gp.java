package com.ushareit.listenit;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class gp implements gw {
    final /* synthetic */ gk f14521a;
    final /* synthetic */ go f14522b;

    gp(go goVar, gk gkVar) {
        this.f14522b = goVar;
        this.f14521a = gkVar;
    }

    public boolean mo2731a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f14521a.mo2961b(view, accessibilityEvent);
    }

    public void mo2733b(View view, AccessibilityEvent accessibilityEvent) {
        this.f14521a.mo2864d(view, accessibilityEvent);
    }

    public void mo2729a(View view, Object obj) {
        this.f14521a.mo2862a(view, new mh(obj));
    }

    public void mo2734c(View view, AccessibilityEvent accessibilityEvent) {
        this.f14521a.m22122c(view, accessibilityEvent);
    }

    public boolean mo2732a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f14521a.mo2960a(viewGroup, view, accessibilityEvent);
    }

    public void mo2728a(View view, int i) {
        this.f14521a.m22116a(view, i);
    }

    public void mo2735d(View view, AccessibilityEvent accessibilityEvent) {
        this.f14521a.m22117a(view, accessibilityEvent);
    }

    public Object mo2727a(View view) {
        na a = this.f14521a.m22114a(view);
        return a != null ? a.m25146a() : null;
    }

    public boolean mo2730a(View view, int i, Bundle bundle) {
        return this.f14521a.mo2863a(view, i, bundle);
    }
}
