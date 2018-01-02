package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

public class ye implements ThreadFactory {
    int f17559a = 0;

    public Thread newThread(Runnable runnable) {
        Thread yfVar = new yf(this, runnable, "fifo-pool-thread-" + this.f17559a);
        this.f17559a++;
        return yfVar;
    }
}
