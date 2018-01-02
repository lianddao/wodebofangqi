package com.ushareit.listenit;

import android.os.SystemClock;

public final class ciq implements cio {
    private static ciq f8354a;

    public static synchronized cio m11395d() {
        cio com_ushareit_listenit_cio;
        synchronized (ciq.class) {
            if (f8354a == null) {
                f8354a = new ciq();
            }
            com_ushareit_listenit_cio = f8354a;
        }
        return com_ushareit_listenit_cio;
    }

    public long mo1370a() {
        return System.currentTimeMillis();
    }

    public long mo1371b() {
        return SystemClock.elapsedRealtime();
    }

    public long mo1372c() {
        return System.nanoTime();
    }
}
