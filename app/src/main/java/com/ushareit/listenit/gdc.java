package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.view.ChargeLockScreenView;

public class gdc implements Runnable {
    final /* synthetic */ ChargeLockScreenView f13943a;

    public gdc(ChargeLockScreenView chargeLockScreenView) {
        this.f13943a = chargeLockScreenView;
    }

    public void run() {
        gyn.m23224c(this.f13943a.f15685a, this.f13943a.f15685a.getWidth());
    }
}
