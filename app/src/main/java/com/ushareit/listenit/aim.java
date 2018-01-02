package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class aim implements ThreadFactory {
    private final AtomicInteger f4444a = new AtomicInteger(0);

    aim() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FacebookSdk #" + this.f4444a.incrementAndGet());
    }
}
