package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;

public class anm {
    private static final String f4954a = anm.class.getName();
    private static anm f4955b;
    private static boolean f4956c = false;
    private Context f4957d;

    private anm(Context context) {
        this.f4957d = context;
    }

    public static anm m6391a(Context context) {
        if (f4955b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f4955b == null) {
                    f4955b = new anm(applicationContext);
                }
            }
        }
        return f4955b;
    }

    public synchronized void m6392a() {
        if (!f4956c) {
            if (app.m6623e(this.f4957d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new ann(Thread.getDefaultUncaughtExceptionHandler(), this.f4957d));
                } catch (Throwable e) {
                    Log.e(f4954a, "No permissions to set the default uncaught exception handler", e);
                }
            }
            f4956c = true;
        }
    }
}
