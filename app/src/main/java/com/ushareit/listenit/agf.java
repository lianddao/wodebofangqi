package com.ushareit.listenit;

import java.util.concurrent.CountDownLatch;

final class agf implements Runnable {
    final /* synthetic */ agb f4323a;
    private final CountDownLatch f4324b;

    public agf(agb com_ushareit_listenit_agb, CountDownLatch countDownLatch) {
        this.f4323a = com_ushareit_listenit_agb;
        this.f4324b = countDownLatch;
    }

    public void run() {
        this.f4324b.countDown();
        this.f4323a.m5547d();
    }
}
