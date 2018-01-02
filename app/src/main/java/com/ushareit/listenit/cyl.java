package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

class cyl implements ThreadFactory {
    final /* synthetic */ cyj f9362a;

    private cyl(cyj com_ushareit_listenit_cyj) {
        this.f9362a = com_ushareit_listenit_cyj;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f9362a.mo1555a().newThread(runnable);
        csv b = this.f9362a.mo1556b();
        b.mo1551a(newThread, "FirebaseDatabaseWorker");
        b.mo1553a(newThread, true);
        b.mo1552a(newThread, new cym(this));
        return newThread;
    }
}
