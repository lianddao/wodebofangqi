package com.ushareit.listenit;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class csx implements cqj {
    private final ThreadPoolExecutor f8908a;

    public csx(ThreadFactory threadFactory, csv com_ushareit_listenit_csv) {
        int i = 1;
        this.f8908a = new ThreadPoolExecutor(1, i, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new csy(this, threadFactory, com_ushareit_listenit_csv));
    }

    public void mo1450a() {
        this.f8908a.setCorePoolSize(1);
    }

    public void mo1451a(Runnable runnable) {
        this.f8908a.execute(runnable);
    }
}
