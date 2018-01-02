package com.ushareit.listenit;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class dyd<V> extends FutureTask<V> implements Comparable<dyd> {
    final /* synthetic */ dya f10651a;
    private final long f10652b = dya.f10639j.getAndIncrement();
    private final boolean f10653c;
    private final String f10654d;

    dyd(dya com_ushareit_listenit_dya, Runnable runnable, boolean z, String str) {
        this.f10651a = com_ushareit_listenit_dya;
        super(runnable, null);
        cfi.m11080a((Object) str);
        this.f10654d = str;
        this.f10653c = z;
        if (this.f10652b == Long.MAX_VALUE) {
            com_ushareit_listenit_dya.mo2096w().m16242f().m16263a("Tasks index overflow");
        }
    }

    dyd(dya com_ushareit_listenit_dya, Callable<V> callable, boolean z, String str) {
        this.f10651a = com_ushareit_listenit_dya;
        super(callable);
        cfi.m11080a((Object) str);
        this.f10654d = str;
        this.f10653c = z;
        if (this.f10652b == Long.MAX_VALUE) {
            com_ushareit_listenit_dya.mo2096w().m16242f().m16263a("Tasks index overflow");
        }
    }

    public int m16402a(dyd com_ushareit_listenit_dyd) {
        if (this.f10653c != com_ushareit_listenit_dyd.f10653c) {
            return this.f10653c ? -1 : 1;
        } else {
            if (this.f10652b < com_ushareit_listenit_dyd.f10652b) {
                return -1;
            }
            if (this.f10652b > com_ushareit_listenit_dyd.f10652b) {
                return 1;
            }
            this.f10651a.mo2096w().m16243g().m16264a("Two tasks share the same index. index", Long.valueOf(this.f10652b));
            return 0;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m16402a((dyd) obj);
    }

    protected void setException(Throwable th) {
        this.f10651a.mo2096w().m16242f().m16264a(this.f10654d, th);
        if (th instanceof dyb) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
