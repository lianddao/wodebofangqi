package com.ushareit.listenit;

import com.mopub.network.MoPubRequestQueue;
import com.mopub.volley.Request;

class eom implements Runnable {
    final /* synthetic */ MoPubRequestQueue f11384a;
    final /* synthetic */ Request f11385b;
    final /* synthetic */ eol f11386c;

    eom(eol com_ushareit_listenit_eol, MoPubRequestQueue moPubRequestQueue, Request request) {
        this.f11386c = com_ushareit_listenit_eol;
        this.f11384a = moPubRequestQueue;
        this.f11385b = request;
    }

    public void run() {
        this.f11386c.f11383d.f2851a.remove(this.f11385b);
        this.f11386c.f11383d.add(this.f11385b);
    }
}
