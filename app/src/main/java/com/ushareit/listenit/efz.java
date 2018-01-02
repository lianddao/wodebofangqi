package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class efz implements ThreadFactory {
    private final AtomicInteger f11016a = new AtomicInteger(1);
    private final String f11017b;

    efz(String str) {
        this.f11017b = str;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f11017b;
        Thread thread = new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 27).append("FirebaseStorage-").append(str).append(this.f11016a.getAndIncrement()).toString());
        thread.setDaemon(false);
        thread.setPriority(9);
        return thread;
    }
}
