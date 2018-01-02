package com.ushareit.listenit;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class fjz {
    private final AtomicInteger f12823a = new AtomicInteger(0);
    private long f12824b = -1;
    private AtomicInteger f12825c = new AtomicInteger(0);

    public abstract void mo2390a(boolean z, long j);

    public fjz() {
        m19581a(1);
    }

    public fjz(int i) {
        m19581a(i);
    }

    public void m19581a(int i) {
        this.f12823a.set(i);
        this.f12825c.set(i);
    }

    public void m19585b(int i) {
        this.f12823a.addAndGet(i);
        this.f12825c.addAndGet(i);
    }

    public void m19582a(long j) {
        synchronized (this.f12823a) {
            this.f12824b = j;
            int decrementAndGet = this.f12825c.decrementAndGet();
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(decrementAndGet == 0, this.f12824b);
            }
        }
    }

    public void m19580a() {
        synchronized (this.f12823a) {
            this.f12824b = -1;
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(false, this.f12824b);
            }
        }
    }

    public void m19586b(long j) {
        synchronized (this.f12823a) {
            this.f12824b = j;
            int decrementAndGet = this.f12825c.decrementAndGet();
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(decrementAndGet == 0, this.f12824b);
            }
        }
    }

    public void m19584b() {
        synchronized (this.f12823a) {
            this.f12824b = -1;
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(false, this.f12824b);
            }
        }
    }

    public void m19587c() {
        synchronized (this.f12823a) {
            int decrementAndGet = this.f12825c.decrementAndGet();
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(decrementAndGet == 0, this.f12824b);
            }
        }
    }

    public void m19588d() {
        synchronized (this.f12823a) {
            this.f12824b = -1;
            if (this.f12823a.decrementAndGet() == 0) {
                mo2390a(false, this.f12824b);
            }
        }
    }
}
