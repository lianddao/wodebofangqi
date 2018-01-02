package com.ushareit.listenit;

import java.util.concurrent.atomic.AtomicBoolean;

class fzz implements dzm<efd> {
    final /* synthetic */ AtomicBoolean f13801a;
    final /* synthetic */ fzx f13802b;

    fzz(fzx com_ushareit_listenit_fzx, AtomicBoolean atomicBoolean) {
        this.f13802b = com_ushareit_listenit_fzx;
        this.f13801a = atomicBoolean;
    }

    public void m21463a(efd com_ushareit_listenit_efd) {
        synchronized (this.f13801a) {
            this.f13801a.set(true);
            this.f13801a.notify();
        }
    }
}
