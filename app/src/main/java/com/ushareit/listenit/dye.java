package com.ushareit.listenit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

final class dye extends Thread {
    final /* synthetic */ dya f10655a;
    private final Object f10656b = new Object();
    private final BlockingQueue<FutureTask<?>> f10657c;

    public dye(dya com_ushareit_listenit_dya, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
        this.f10655a = com_ushareit_listenit_dya;
        cfi.m11080a((Object) str);
        cfi.m11080a((Object) blockingQueue);
        this.f10657c = blockingQueue;
        setName(str);
    }

    private void m16403a(InterruptedException interruptedException) {
        this.f10655a.mo2096w().m16262z().m16264a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public void m16404a() {
        synchronized (this.f10656b) {
            this.f10656b.notifyAll();
        }
    }

    public void run() {
        Object obj = null;
        while (obj == null) {
            try {
                this.f10655a.f10647h.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                m16403a(e);
            }
        }
        while (true) {
            try {
                FutureTask futureTask = (FutureTask) this.f10657c.poll();
                if (futureTask != null) {
                    futureTask.run();
                } else {
                    synchronized (this.f10656b) {
                        if (this.f10657c.peek() == null && !this.f10655a.f10648i) {
                            try {
                                this.f10656b.wait(30000);
                            } catch (InterruptedException e2) {
                                m16403a(e2);
                            }
                        }
                    }
                    synchronized (this.f10655a.f10646g) {
                        if (this.f10657c.peek() == null) {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                synchronized (this.f10655a.f10646g) {
                    this.f10655a.f10647h.release();
                    this.f10655a.f10646g.notifyAll();
                    if (this == this.f10655a.f10640a) {
                        this.f10655a.f10640a = null;
                    } else if (this == this.f10655a.f10641b) {
                        this.f10655a.f10641b = null;
                    } else {
                        this.f10655a.mo2096w().m16242f().m16263a("Current scheduler thread is neither worker nor network");
                    }
                }
            }
        }
        synchronized (this.f10655a.f10646g) {
            this.f10655a.f10647h.release();
            this.f10655a.f10646g.notifyAll();
            if (this == this.f10655a.f10640a) {
                this.f10655a.f10640a = null;
            } else if (this == this.f10655a.f10641b) {
                this.f10655a.f10641b = null;
            } else {
                this.f10655a.mo2096w().m16242f().m16263a("Current scheduler thread is neither worker nor network");
            }
        }
    }
}
