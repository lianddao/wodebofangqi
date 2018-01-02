package com.ushareit.listenit;

import android.os.SystemClock;
import android.util.Log;

public class cik {
    private final long f8350a;
    private final int f8351b;
    private final gg<String, Long> f8352c;

    public cik() {
        this.f8350a = 60000;
        this.f8351b = 10;
        this.f8352c = new gg(10);
    }

    public cik(int i, long j) {
        this.f8350a = j;
        this.f8351b = i;
        this.f8352c = new gg();
    }

    private void m11380a(long j, long j2) {
        for (int size = this.f8352c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f8352c.m20345c(size)).longValue() > j) {
                this.f8352c.m20346d(size);
            }
        }
    }

    public Long m11381a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f8350a;
        synchronized (this) {
            while (this.f8352c.size() >= this.f8351b) {
                m11380a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f8351b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.f8352c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean m11382b(String str) {
        boolean z;
        synchronized (this) {
            z = this.f8352c.remove(str) != null;
        }
        return z;
    }
}
