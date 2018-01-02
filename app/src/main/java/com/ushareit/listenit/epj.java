package com.ushareit.listenit;

import com.mopub.volley.toolbox.ImageLoader.ImageContainer;

class epj implements Runnable {
    final /* synthetic */ ImageContainer f11432a;
    final /* synthetic */ epi f11433b;

    epj(epi com_ushareit_listenit_epi, ImageContainer imageContainer) {
        this.f11433b = com_ushareit_listenit_epi;
        this.f11432a = imageContainer;
    }

    public void run() {
        this.f11433b.onResponse(this.f11432a, false);
    }
}
