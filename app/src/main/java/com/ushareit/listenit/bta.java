package com.ushareit.listenit;

import android.os.SystemClock;

public final class bta implements bsm {
    private boolean f7659a;
    private long f7660b;
    private long f7661c;

    public void m9751a() {
        if (!this.f7659a) {
            this.f7659a = true;
            this.f7661c = m9750b(this.f7660b);
        }
    }

    public void m9753b() {
        if (this.f7659a) {
            this.f7660b = m9750b(this.f7661c);
            this.f7659a = false;
        }
    }

    public void m9752a(long j) {
        this.f7660b = j;
        this.f7661c = m9750b(j);
    }

    public long mo948t() {
        return this.f7659a ? m9750b(this.f7661c) : this.f7660b;
    }

    private long m9750b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
