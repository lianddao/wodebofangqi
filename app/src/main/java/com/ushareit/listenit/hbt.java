package com.ushareit.listenit;

import com.ushareit.listenit.widget.LISTENitViewFlipper;

public class hbt implements Runnable {
    final LISTENitViewFlipper f15161a;
    final /* synthetic */ LISTENitViewFlipper f15162b;

    public hbt(LISTENitViewFlipper lISTENitViewFlipper, LISTENitViewFlipper lISTENitViewFlipper2) {
        this.f15162b = lISTENitViewFlipper;
        this.f15161a = lISTENitViewFlipper2;
    }

    public void run() {
        this.f15161a.requestLayout();
    }
}
