package com.ushareit.listenit;

import com.ushareit.listenit.rate.RateGuideView;

public class grk implements Runnable {
    final /* synthetic */ RateGuideView f14587a;

    public grk(RateGuideView rateGuideView) {
        this.f14587a = rateGuideView;
    }

    public void run() {
        this.f14587a.f16384b = true;
        this.f14587a.m25921b();
    }
}
