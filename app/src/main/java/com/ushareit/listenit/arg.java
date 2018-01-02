package com.ushareit.listenit;

import java.util.concurrent.CountDownLatch;

final class arg implements Runnable {
    final /* synthetic */ ara f5228a;
    private final CountDownLatch f5229b;

    public arg(ara com_ushareit_listenit_ara, CountDownLatch countDownLatch) {
        this.f5228a = com_ushareit_listenit_ara;
        this.f5229b = countDownLatch;
    }

    public void run() {
        this.f5229b.countDown();
        this.f5228a.m6870e();
    }
}
