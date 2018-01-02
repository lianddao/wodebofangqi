package com.ushareit.listenit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class gwx extends hhw {
    public gwx(String str) {
        super(str);
    }

    protected String mo2314a() {
        return gwx.class.getSimpleName();
    }

    protected ExecutorService mo2315b() {
        int max = Math.max(1, Runtime.getRuntime().availableProcessors());
        return new hhs(max, max, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public void callback() {
    }
}
