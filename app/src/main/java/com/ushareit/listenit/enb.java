package com.ushareit.listenit;

import com.mopub.nativeads.MoPubStreamAdPlacer;

public class enb implements Runnable {
    final /* synthetic */ MoPubStreamAdPlacer f11290a;

    public enb(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        this.f11290a = moPubStreamAdPlacer;
    }

    public void run() {
        if (this.f11290a.f2700s) {
            this.f11290a.m3256c();
            this.f11290a.f2700s = false;
        }
    }
}
