package com.ushareit.listenit;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class bux extends Thread {
    CountDownLatch f7783a = new CountDownLatch(1);
    boolean f7784b = false;
    private WeakReference<AdvertisingIdClient> f7785c;
    private long f7786d;

    public bux(AdvertisingIdClient advertisingIdClient, long j) {
        this.f7785c = new WeakReference(advertisingIdClient);
        this.f7786d = j;
        start();
    }

    private void m9926c() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f7785c.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.finish();
            this.f7784b = true;
        }
    }

    public void m9927a() {
        this.f7783a.countDown();
    }

    public boolean m9928b() {
        return this.f7784b;
    }

    public void run() {
        try {
            if (!this.f7783a.await(this.f7786d, TimeUnit.MILLISECONDS)) {
                m9926c();
            }
        } catch (InterruptedException e) {
            m9926c();
        }
    }
}
