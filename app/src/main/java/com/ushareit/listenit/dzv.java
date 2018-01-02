package com.ushareit.listenit;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class dzv implements dzw {
    private final CountDownLatch f10732a;

    private dzv() {
        this.f10732a = new CountDownLatch(1);
    }

    public void mo1447a(Exception exception) {
        this.f10732a.countDown();
    }

    public void mo1448a(Object obj) {
        this.f10732a.countDown();
    }

    public boolean m16576a(long j, TimeUnit timeUnit) {
        return this.f10732a.await(j, timeUnit);
    }
}
