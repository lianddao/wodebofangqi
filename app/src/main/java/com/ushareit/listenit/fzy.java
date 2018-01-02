package com.ushareit.listenit;

import java.util.concurrent.atomic.AtomicBoolean;

class fzy implements dzl {
    final /* synthetic */ AtomicBoolean f13799a;
    final /* synthetic */ fzx f13800b;

    fzy(fzx com_ushareit_listenit_fzx, AtomicBoolean atomicBoolean) {
        this.f13800b = com_ushareit_listenit_fzx;
        this.f13799a = atomicBoolean;
    }

    public void mo1447a(Exception exception) {
        synchronized (this.f13799a) {
            this.f13799a.set(false);
            this.f13799a.notify();
        }
    }
}
