package com.ushareit.listenit;

import java.util.Queue;

abstract class wr<T extends xb> {
    private final Queue<T> f17490a = afu.m5496a(20);

    protected abstract T mo3127b();

    wr() {
    }

    protected T m27136c() {
        xb xbVar = (xb) this.f17490a.poll();
        if (xbVar == null) {
            return mo3127b();
        }
        return xbVar;
    }

    public void m27134a(T t) {
        if (this.f17490a.size() < 20) {
            this.f17490a.offer(t);
        }
    }
}
