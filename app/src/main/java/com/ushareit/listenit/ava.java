package com.ushareit.listenit;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class ava implements ThreadFactory {
    protected final AtomicLong f5559a = new AtomicLong();
    private int f5560b = Thread.currentThread().getPriority();

    protected String m7244a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f5559a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, m7244a(), 0);
        thread.setPriority(this.f5560b);
        return thread;
    }
}
