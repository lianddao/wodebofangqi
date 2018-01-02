package com.ushareit.listenit;

import java.util.concurrent.CountDownLatch;

final class dv extends eg<Void, Void, D> implements Runnable {
    boolean f10376a;
    final /* synthetic */ du f10377b;
    private final CountDownLatch f10378d = new CountDownLatch(1);

    dv(du duVar) {
        this.f10377b = duVar;
    }

    protected D m15737a(Void... voidArr) {
        try {
            return this.f10377b.m10771e();
        } catch (fd e) {
            if (m15735c()) {
                return null;
            }
            throw e;
        }
    }

    protected void mo2078a(D d) {
        try {
            this.f10377b.m10767b(this, d);
        } finally {
            this.f10378d.countDown();
        }
    }

    protected void mo2079b(D d) {
        try {
            this.f10377b.m10764a(this, d);
        } finally {
            this.f10378d.countDown();
        }
    }

    public void run() {
        this.f10376a = false;
        this.f10377b.m10769c();
    }
}
