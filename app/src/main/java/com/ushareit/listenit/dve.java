package com.ushareit.listenit;

import java.util.concurrent.atomic.AtomicReference;

class dve implements Runnable {
    final /* synthetic */ AtomicReference f10399a;
    final /* synthetic */ boolean f10400b;
    final /* synthetic */ dva f10401c;

    dve(dva com_ushareit_listenit_dva, AtomicReference atomicReference, boolean z) {
        this.f10401c = com_ushareit_listenit_dva;
        this.f10399a = atomicReference;
        this.f10400b = z;
    }

    public void run() {
        this.f10401c.mo2088o().m15798a(this.f10399a, this.f10400b);
    }
}
