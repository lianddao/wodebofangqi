package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

public class hhk implements ThreadFactory {
    int f15462a = 0;

    public Thread newThread(Runnable runnable) {
        Thread com_ushareit_listenit_hhl = new hhl(this, runnable, "fifo-pool-thread-" + this.f15462a);
        this.f15462a++;
        return com_ushareit_listenit_hhl;
    }
}
