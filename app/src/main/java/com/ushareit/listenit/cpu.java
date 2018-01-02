package com.ushareit.listenit;

import java.util.concurrent.ScheduledExecutorService;

public class cpu {
    private final ScheduledExecutorService f8669a;
    private long f8670b = 1000;
    private double f8671c = 0.5d;
    private long f8672d = 30000;
    private double f8673e = 1.3d;
    private final cvy f8674f;

    public cpu(ScheduledExecutorService scheduledExecutorService, cvz com_ushareit_listenit_cvz, String str) {
        this.f8669a = scheduledExecutorService;
        this.f8674f = new cvy(com_ushareit_listenit_cvz, str);
    }

    public cps m12218a() {
        return new cps(this.f8669a, this.f8674f, this.f8670b, this.f8672d, this.f8673e, this.f8671c);
    }

    public cpu m12219a(double d) {
        this.f8673e = d;
        return this;
    }

    public cpu m12220a(long j) {
        this.f8670b = j;
        return this;
    }

    public cpu m12221b(double d) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("Argument out of range: " + d);
        }
        this.f8671c = d;
        return this;
    }

    public cpu m12222b(long j) {
        this.f8672d = j;
        return this;
    }
}
