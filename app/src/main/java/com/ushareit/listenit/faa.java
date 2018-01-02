package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

final class faa implements ServiceConnection {
    boolean f12298a;
    private final LinkedBlockingQueue<IBinder> f12299b;

    private faa() {
        this.f12298a = false;
        this.f12299b = new LinkedBlockingQueue(1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f12299b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder m18680a() {
        if (this.f12298a) {
            throw new IllegalStateException();
        }
        this.f12298a = true;
        return (IBinder) this.f12299b.take();
    }
}
