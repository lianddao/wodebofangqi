package com.ushareit.listenit;

import com.ushareit.listenit.widget.LISTENitViewFlipper;

public class hbu implements Runnable {
    final boolean f15163a;
    final LISTENitViewFlipper f15164b;
    final /* synthetic */ LISTENitViewFlipper f15165c;

    public hbu(LISTENitViewFlipper lISTENitViewFlipper, LISTENitViewFlipper lISTENitViewFlipper2, boolean z) {
        this.f15165c = lISTENitViewFlipper;
        this.f15164b = lISTENitViewFlipper2;
        this.f15163a = z;
    }

    public void run() {
        this.f15164b.f17231e.mo2746a(this.f15163a, this.f15164b.f17240n, this.f15164b.f17239m);
    }
}
