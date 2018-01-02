package com.ushareit.listenit;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class dya extends duy {
    private static final AtomicLong f10639j = new AtomicLong(Long.MIN_VALUE);
    private dye f10640a;
    private dye f10641b;
    private final PriorityBlockingQueue<FutureTask<?>> f10642c = new PriorityBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f10643d = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f10644e = new dyc(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f10645f = new dyc(this, "Thread death: Uncaught exception on network thread");
    private final Object f10646g = new Object();
    private final Semaphore f10647h = new Semaphore(2);
    private volatile boolean f10648i;

    dya(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private void m16371a(dyd<?> com_ushareit_listenit_dyd_) {
        synchronized (this.f10646g) {
            this.f10642c.add(com_ushareit_listenit_dyd_);
            if (this.f10640a == null) {
                this.f10640a = new dye(this, "Measurement Worker", this.f10642c);
                this.f10640a.setUncaughtExceptionHandler(this.f10644e);
                this.f10640a.start();
            } else {
                this.f10640a.m16404a();
            }
        }
    }

    private void m16372a(FutureTask<?> futureTask) {
        synchronized (this.f10646g) {
            this.f10643d.add(futureTask);
            if (this.f10641b == null) {
                this.f10641b = new dye(this, "Measurement Network", this.f10643d);
                this.f10641b.setUncaughtExceptionHandler(this.f10645f);
                this.f10641b.start();
            } else {
                this.f10641b.m16404a();
            }
        }
    }

    public <V> Future<V> m16379a(Callable<V> callable) {
        m15696c();
        cfi.m11080a((Object) callable);
        dyd com_ushareit_listenit_dyd = new dyd(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f10640a) {
            com_ushareit_listenit_dyd.run();
        } else {
            m16371a(com_ushareit_listenit_dyd);
        }
        return com_ushareit_listenit_dyd;
    }

    public void m16380a(Runnable runnable) {
        m15696c();
        cfi.m11080a((Object) runnable);
        m16371a(new dyd(this, runnable, false, "Task exception on worker thread"));
    }

    public <V> Future<V> m16381b(Callable<V> callable) {
        m15696c();
        cfi.m11080a((Object) callable);
        dyd com_ushareit_listenit_dyd = new dyd(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f10640a) {
            com_ushareit_listenit_dyd.run();
        } else {
            m16371a(com_ushareit_listenit_dyd);
        }
        return com_ushareit_listenit_dyd;
    }

    public void m16382b(Runnable runnable) {
        m15696c();
        cfi.m11080a((Object) runnable);
        m16372a(new dyd(this, runnable, false, "Task exception on network thread"));
    }

    protected void mo2080e() {
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public void mo2082i() {
        if (Thread.currentThread() != this.f10641b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public void mo2083j() {
        if (Thread.currentThread() != this.f10640a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }
}
