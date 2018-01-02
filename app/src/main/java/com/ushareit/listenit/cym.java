package com.ushareit.listenit;

import java.lang.Thread.UncaughtExceptionHandler;

class cym implements UncaughtExceptionHandler {
    final /* synthetic */ cyl f9363a;

    cym(cyl com_ushareit_listenit_cyl) {
        this.f9363a = com_ushareit_listenit_cyl;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f9363a.f9362a.mo1461a(th);
    }
}
