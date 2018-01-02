package com.ushareit.listenit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class dom {
    private static final ExecutorService f10094a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new dpz("GAC_Transform"));

    public static ExecutorService m15166a() {
        return f10094a;
    }
}
