package com.ushareit.listenit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public abstract class cyj implements crt {
    private ScheduledThreadPoolExecutor f8486a = new cyk(this, 1, new cyl());

    public cyj() {
        this.f8486a.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public static String m11792b(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof ecf) {
            return "";
        }
        String valueOf = String.valueOf(ecl.m16740c());
        return new StringBuilder(String.valueOf(valueOf).length() + 104).append("Uncaught exception in Firebase Database runloop (").append(valueOf).append("). Please report to firebase-database-client@google.com").toString();
    }

    protected ThreadFactory mo1555a() {
        return Executors.defaultThreadFactory();
    }

    public void mo1459a(Runnable runnable) {
        this.f8486a.execute(runnable);
    }

    public abstract void mo1461a(Throwable th);

    protected csv mo1556b() {
        return csv.f8718a;
    }

    public void mo1460c() {
        this.f8486a.setCorePoolSize(1);
    }

    public ScheduledExecutorService m11798d() {
        return this.f8486a;
    }
}
