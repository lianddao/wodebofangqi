package com.ushareit.listenit;

import com.facebook.ads.internal.view.C0052n;

public class azn implements Runnable {
    final /* synthetic */ C0052n f5736a;

    public azn(C0052n c0052n) {
        this.f5736a = c0052n;
    }

    public void run() {
        if (!this.f5736a.f830d) {
            this.f5736a.f827a.m6616a(C0052n.f819l);
            this.f5736a.f835t.postDelayed(this, 250);
        }
    }
}
