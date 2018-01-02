package com.ushareit.listenit;

class qq {
    long f16339a = 0;
    qq f16340b;

    qq() {
    }

    void m25810a(int i) {
        if (i >= 64) {
            m25808b();
            this.f16340b.m25810a(i - 64);
            return;
        }
        this.f16339a |= 1 << i;
    }

    private void m25808b() {
        if (this.f16340b == null) {
            this.f16340b = new qq();
        }
    }

    void m25812b(int i) {
        if (i < 64) {
            this.f16339a &= (1 << i) ^ -1;
        } else if (this.f16340b != null) {
            this.f16340b.m25812b(i - 64);
        }
    }

    boolean m25813c(int i) {
        if (i < 64) {
            return (this.f16339a & (1 << i)) != 0;
        } else {
            m25808b();
            return this.f16340b.m25813c(i - 64);
        }
    }

    void m25809a() {
        this.f16339a = 0;
        if (this.f16340b != null) {
            this.f16340b.m25809a();
        }
    }

    void m25811a(int i, boolean z) {
        if (i >= 64) {
            m25808b();
            this.f16340b.m25811a(i - 64, z);
            return;
        }
        boolean z2 = (this.f16339a & Long.MIN_VALUE) != 0;
        long j = (1 << i) - 1;
        this.f16339a = (((j ^ -1) & this.f16339a) << 1) | (this.f16339a & j);
        if (z) {
            m25810a(i);
        } else {
            m25812b(i);
        }
        if (z2 || this.f16340b != null) {
            m25808b();
            this.f16340b.m25811a(0, z2);
        }
    }

    boolean m25814d(int i) {
        if (i >= 64) {
            m25808b();
            return this.f16340b.m25814d(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.f16339a & j) != 0;
        this.f16339a &= j ^ -1;
        j--;
        this.f16339a = Long.rotateRight((j ^ -1) & this.f16339a, 1) | (this.f16339a & j);
        if (this.f16340b == null) {
            return z;
        }
        if (this.f16340b.m25813c(0)) {
            m25810a(63);
        }
        this.f16340b.m25814d(0);
        return z;
    }

    int m25815e(int i) {
        if (this.f16340b == null) {
            if (i >= 64) {
                return Long.bitCount(this.f16339a);
            }
            return Long.bitCount(this.f16339a & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.f16339a & ((1 << i) - 1));
        } else {
            return this.f16340b.m25815e(i - 64) + Long.bitCount(this.f16339a);
        }
    }

    public String toString() {
        return this.f16340b == null ? Long.toBinaryString(this.f16339a) : this.f16340b.toString() + "xx" + Long.toBinaryString(this.f16339a);
    }
}
