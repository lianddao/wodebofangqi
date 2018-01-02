package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

final class aoe implements ServiceConnection {
    private AtomicBoolean f5022a;
    private final BlockingQueue<IBinder> f5023b;

    private aoe() {
        this.f5022a = new AtomicBoolean(false);
        this.f5023b = new LinkedBlockingDeque();
    }

    public IBinder m6450a() {
        if (!this.f5022a.compareAndSet(true, true)) {
            return (IBinder) this.f5023b.take();
        }
        throw new IllegalStateException("Binder already consumed");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f5023b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
