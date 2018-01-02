package com.ushareit.listenit;

import com.mopub.nativeads.PositioningSource.PositioningListener;

class emc implements Runnable {
    final /* synthetic */ PositioningListener f11244a;
    final /* synthetic */ emb f11245b;

    emc(emb com_ushareit_listenit_emb, PositioningListener positioningListener) {
        this.f11245b = com_ushareit_listenit_emb;
        this.f11244a = positioningListener;
    }

    public void run() {
        this.f11244a.onLoad(this.f11245b.f11243b);
    }
}
