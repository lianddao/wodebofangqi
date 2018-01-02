package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.view.VerticalDragLayout;

public class gdm implements Runnable {
    final /* synthetic */ int f13958a;
    final /* synthetic */ VerticalDragLayout f13959b;

    public gdm(VerticalDragLayout verticalDragLayout, int i) {
        this.f13959b = verticalDragLayout;
        this.f13958a = i;
    }

    public void run() {
        this.f13959b.f15737a.m25691a(this.f13959b.f15739c, this.f13959b.getPaddingLeft(), this.f13958a);
        this.f13959b.postInvalidate();
    }
}
