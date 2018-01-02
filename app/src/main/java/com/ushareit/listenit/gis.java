package com.ushareit.listenit;

import com.ushareit.listenit.main.MainActivity;

public class gis implements Runnable {
    final /* synthetic */ MainActivity f14176a;

    public gis(MainActivity mainActivity) {
        this.f14176a = mainActivity;
    }

    public void run() {
        if (this.f14176a.f15913y != null) {
            gyn.m23215b(this.f14176a, this.f14176a.f15913y);
            this.f14176a.f15913y.m20572a(null);
            this.f14176a.f15913y = null;
        }
    }
}
