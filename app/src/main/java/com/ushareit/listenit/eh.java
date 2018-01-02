package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class eh implements ThreadFactory {
    private final AtomicInteger f11059a = new AtomicInteger(1);

    eh() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.f11059a.getAndIncrement());
    }
}
