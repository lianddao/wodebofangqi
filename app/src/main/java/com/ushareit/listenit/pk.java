package com.ushareit.listenit;

import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

public class pk implements Runnable {
    final View f16112a;
    final /* synthetic */ SlidingPaneLayout f16113b;

    public pk(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f16113b = slidingPaneLayout;
        this.f16112a = view;
    }

    public void run() {
        if (this.f16112a.getParent() == this.f16113b) {
            ja.m24137a(this.f16112a, 0, null);
            this.f16113b.m158g(this.f16112a);
        }
        this.f16113b.f238u.remove(this);
    }
}
