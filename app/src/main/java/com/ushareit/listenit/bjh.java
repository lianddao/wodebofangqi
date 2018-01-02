package com.ushareit.listenit;

final class bjh implements bjf {
    private final long f6557a;
    private final long f6558b;
    private final long f6559c;
    private final long[] f6560d;
    private final long f6561e;
    private final int f6562f;

    public static bjh m8695a(bid com_ushareit_listenit_bid, bss com_ushareit_listenit_bss, long j, long j2) {
        int i = com_ushareit_listenit_bid.f6408g;
        int i2 = com_ushareit_listenit_bid.f6405d;
        long j3 = j + ((long) com_ushareit_listenit_bid.f6404c);
        int n = com_ushareit_listenit_bss.m9720n();
        if ((n & 1) == 1) {
            int t = com_ushareit_listenit_bss.m9726t();
            if (t != 0) {
                long a = btc.m9763a((long) t, ((long) i) * 1000000, (long) i2);
                if ((n & 6) != 6) {
                    return new bjh(j3, a, j2);
                }
                long t2 = (long) com_ushareit_listenit_bss.m9726t();
                com_ushareit_listenit_bss.m9709d(1);
                long[] jArr = new long[99];
                for (t = 0; t < 99; t++) {
                    jArr[t] = (long) com_ushareit_listenit_bss.m9713g();
                }
                return new bjh(j3, a, j2, jArr, t2, com_ushareit_listenit_bid.f6404c);
            }
        }
        return null;
    }

    private bjh(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    private bjh(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f6557a = j;
        this.f6558b = j2;
        this.f6559c = j3;
        this.f6560d = jArr;
        this.f6561e = j4;
        this.f6562f = i;
    }

    public boolean mo957a() {
        return this.f6560d != null;
    }

    public long mo959b(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        if (!mo957a()) {
            return this.f6557a;
        }
        float f3 = (((float) j) * 100.0f) / ((float) this.f6558b);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) this.f6560d[i - 1];
            }
            if (i < 99) {
                f = (float) this.f6560d[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        return Math.min(this.f6557a + Math.round((((double) f) * 0.00390625d) * ((double) this.f6561e)), this.f6559c != -1 ? this.f6559c - 1 : ((this.f6557a - ((long) this.f6562f)) + this.f6561e) - 1);
    }

    public long mo995a(long j) {
        if (!mo957a() || j < this.f6557a) {
            return 0;
        }
        double d = (256.0d * ((double) (j - this.f6557a))) / ((double) this.f6561e);
        int a = btc.m9762a(this.f6560d, (long) d, true, false) + 1;
        long a2 = m8694a(a);
        long j2 = a == 0 ? 0 : this.f6560d[a - 1];
        long j3 = a == 99 ? 256 : this.f6560d[a];
        return a2 + (j3 == j2 ? 0 : (long) ((((double) (m8694a(a + 1) - a2)) * (d - ((double) j2))) / ((double) (j3 - j2))));
    }

    public long mo958b() {
        return this.f6558b;
    }

    private long m8694a(int i) {
        return (this.f6558b * ((long) i)) / 100;
    }
}
