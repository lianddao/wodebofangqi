package com.ushareit.listenit;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class dpz implements ThreadFactory {
    private final String f10144a;
    private final int f10145b;
    private final AtomicInteger f10146c;
    private final ThreadFactory f10147d;

    public dpz(String str) {
        this(str, 0);
    }

    public dpz(String str, int i) {
        this.f10146c = new AtomicInteger();
        this.f10147d = Executors.defaultThreadFactory();
        this.f10144a = (String) cfi.m11081a((Object) str, (Object) "Name must not be null");
        this.f10145b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f10147d.newThread(new dqa(runnable, this.f10145b));
        String str = this.f10144a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f10146c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
