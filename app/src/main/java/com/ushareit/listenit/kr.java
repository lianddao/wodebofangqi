package com.ushareit.listenit;

import android.support.v4.view.ViewPager;

public class kr implements Runnable {
    final /* synthetic */ ViewPager f15613a;

    public kr(ViewPager viewPager) {
        this.f15613a = viewPager;
    }

    public void run() {
        this.f15613a.setScrollState(0);
        this.f15613a.m53c();
    }
}
