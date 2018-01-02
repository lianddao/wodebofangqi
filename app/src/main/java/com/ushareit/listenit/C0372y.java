package com.ushareit.listenit;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class C0372y implements OnPreDrawListener {
    final /* synthetic */ View f17551a;
    final /* synthetic */ aa f17552b;
    final /* synthetic */ int f17553c;
    final /* synthetic */ Object f17554d;
    final /* synthetic */ C0369v f17555e;

    C0372y(C0369v c0369v, View view, aa aaVar, int i, Object obj) {
        this.f17555e = c0369v;
        this.f17551a = view;
        this.f17552b = aaVar;
        this.f17553c = i;
        this.f17554d = obj;
    }

    public boolean onPreDraw() {
        this.f17551a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f17555e.m26630a(this.f17552b, this.f17553c, this.f17554d);
        return true;
    }
}
