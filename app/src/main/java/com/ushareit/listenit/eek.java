package com.ushareit.listenit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class eek extends Service {
    MessengerCompat f2023a = new MessengerCompat(new eel(this, Looper.getMainLooper()));
    final ExecutorService f2024b = Executors.newSingleThreadExecutor();
    private final Object f2025c = new Object();
    private int f2026d;
    private int f2027e = 0;

    private void mo294d(Intent intent) {
        if (intent != null) {
            ep.m2433a(intent);
        }
        synchronized (this.f2025c) {
            this.f2027e--;
            if (this.f2027e == 0) {
                m2577b(this.f2026d);
            }
        }
    }

    public boolean mo291a(Intent intent) {
        return false;
    }

    public abstract void mo292b(Intent intent);

    boolean m2577b(int i) {
        return stopSelfResult(i);
    }

    public abstract Intent mo293c(Intent intent);

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) ? null : this.f2023a.m2339a();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f2025c) {
            this.f2026d = i2;
            this.f2027e++;
        }
        Intent c = mo293c(intent);
        if (c == null) {
            mo294d(intent);
            return 2;
        } else if (mo291a(c)) {
            mo294d(intent);
            return 2;
        } else {
            this.f2024b.execute(new eem(this, c, intent));
            return 3;
        }
    }
}
