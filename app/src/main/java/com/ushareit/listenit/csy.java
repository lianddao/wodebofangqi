package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

class csy implements ThreadFactory {
    final /* synthetic */ ThreadFactory f8909a;
    final /* synthetic */ csv f8910b;
    final /* synthetic */ csx f8911c;

    csy(csx com_ushareit_listenit_csx, ThreadFactory threadFactory, csv com_ushareit_listenit_csv) {
        this.f8911c = com_ushareit_listenit_csx;
        this.f8909a = threadFactory;
        this.f8910b = com_ushareit_listenit_csv;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f8909a.newThread(runnable);
        this.f8910b.mo1551a(newThread, "FirebaseDatabaseEventTarget");
        this.f8910b.mo1553a(newThread, true);
        return newThread;
    }
}
