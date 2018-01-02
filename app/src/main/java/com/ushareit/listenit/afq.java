package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class afq {
    private static final double f4275a;

    static {
        double d = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f4275a = d;
    }

    @TargetApi(17)
    public static long m5477a() {
        if (17 <= VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }

    public static double m5476a(long j) {
        return ((double) (m5477a() - j)) * f4275a;
    }
}
