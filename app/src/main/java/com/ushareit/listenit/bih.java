package com.ushareit.listenit;

public final class bih {
    private final long f6411a;
    private long f6412b;
    private volatile long f6413c = -9223372036854775807L;

    public bih(long j) {
        this.f6411a = j;
    }

    public void m8564a() {
        this.f6413c = -9223372036854775807L;
    }

    public long m8563a(long j) {
        long j2;
        if (this.f6413c != -9223372036854775807L) {
            long d = m8562d(this.f6413c);
            long j3 = (4294967296L + d) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - d) >= Math.abs(j3 - d)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        return m8565b(m8561c(j2));
    }

    public long m8565b(long j) {
        if (this.f6413c != -9223372036854775807L) {
            this.f6413c = j;
        } else {
            if (this.f6411a != Long.MAX_VALUE) {
                this.f6412b = this.f6411a - j;
            }
            synchronized (this) {
                this.f6413c = j;
                notifyAll();
            }
        }
        return this.f6412b + j;
    }

    public static long m8561c(long j) {
        return (1000000 * j) / 90000;
    }

    public static long m8562d(long j) {
        return (90000 * j) / 1000000;
    }
}
