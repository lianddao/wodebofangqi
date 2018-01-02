package com.ushareit.listenit;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class elj implements OnPreDrawListener {
    final /* synthetic */ View f11213a;
    final /* synthetic */ eli f11214b;

    elj(eli com_ushareit_listenit_eli, View view) {
        this.f11214b = com_ushareit_listenit_eli;
        this.f11213a = view;
    }

    public boolean onPreDraw() {
        this.f11213a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f11214b.f11212a.m17147b();
        return true;
    }
}
