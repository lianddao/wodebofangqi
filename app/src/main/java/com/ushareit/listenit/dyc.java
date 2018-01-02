package com.ushareit.listenit;

import java.lang.Thread.UncaughtExceptionHandler;

final class dyc implements UncaughtExceptionHandler {
    final /* synthetic */ dya f10649a;
    private final String f10650b;

    public dyc(dya com_ushareit_listenit_dya, String str) {
        this.f10649a = com_ushareit_listenit_dya;
        cfi.m11080a((Object) str);
        this.f10650b = str;
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f10649a.mo2096w().m16242f().m16264a(this.f10650b, th);
    }
}
