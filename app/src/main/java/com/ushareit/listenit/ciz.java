package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ciz implements ServiceConnection {
    boolean f8361a = false;
    private final BlockingQueue<IBinder> f8362b = new LinkedBlockingQueue();

    public IBinder m11424a(long j, TimeUnit timeUnit) {
        cfi.m11092c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f8361a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f8361a = true;
        IBinder iBinder = (IBinder) this.f8362b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8362b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
