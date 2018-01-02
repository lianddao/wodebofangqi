package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

public class hhr implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        return new hhq(runnable);
    }
}
