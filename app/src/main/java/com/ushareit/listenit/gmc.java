package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class gmc<T> {
    private List<T> f14389a = new CopyOnWriteArrayList();
    private int f14390b = 1;
    private final AtomicInteger f14391c = new AtomicInteger(0);
    private AtomicBoolean f14392d = new AtomicBoolean(false);

    public abstract void mo2716a(boolean z, List<T> list);

    public gmc(int i) {
        this.f14390b = i;
    }

    public void m22415a(T t) {
        this.f14392d.set(true);
        if (t != null) {
            this.f14389a.add(t);
        }
        synchronized (this.f14391c) {
            if (this.f14391c.incrementAndGet() == this.f14390b) {
                mo2716a(this.f14392d.get(), this.f14389a);
            }
        }
    }

    public void m22414a() {
        synchronized (this.f14391c) {
            if (this.f14391c.incrementAndGet() == this.f14390b) {
                mo2716a(this.f14392d.get(), this.f14389a);
            }
        }
    }
}
