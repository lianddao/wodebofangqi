package com.ushareit.listenit;

final class bjg implements bjf {
    private final long[] f6554a;
    private final long[] f6555b;
    private final long f6556c;

    public static bjg m8689a(bid com_ushareit_listenit_bid, bss com_ushareit_listenit_bss, long j, long j2) {
        com_ushareit_listenit_bss.m9709d(10);
        int n = com_ushareit_listenit_bss.m9720n();
        if (n <= 0) {
            return null;
        }
        int i = com_ushareit_listenit_bid.f6405d;
        long a = btc.m9763a((long) n, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, (long) i);
        int h = com_ushareit_listenit_bss.m9714h();
        int h2 = com_ushareit_listenit_bss.m9714h();
        int h3 = com_ushareit_listenit_bss.m9714h();
        com_ushareit_listenit_bss.m9709d(2);
        long j3 = j + ((long) com_ushareit_listenit_bid.f6404c);
        long[] jArr = new long[(h + 1)];
        long[] jArr2 = new long[(h + 1)];
        jArr[0] = 0;
        jArr2[0] = j3;
        for (n = 1; n < jArr.length; n++) {
            int g;
            long j4;
            switch (h3) {
                case 1:
                    g = com_ushareit_listenit_bss.m9713g();
                    break;
                case 2:
                    g = com_ushareit_listenit_bss.m9714h();
                    break;
                case 3:
                    g = com_ushareit_listenit_bss.m9717k();
                    break;
                case 4:
                    g = com_ushareit_listenit_bss.m9726t();
                    break;
                default:
                    return null;
            }
            j3 += (long) (g * h2);
            jArr[n] = (((long) n) * a) / ((long) h);
            if (j2 == -1) {
                j4 = j3;
            } else {
                j4 = Math.min(j2, j3);
            }
            jArr2[n] = j4;
        }
        return new bjg(jArr, jArr2, a);
    }

    private bjg(long[] jArr, long[] jArr2, long j) {
        this.f6554a = jArr;
        this.f6555b = jArr2;
        this.f6556c = j;
    }

    public boolean mo957a() {
        return true;
    }

    public long mo959b(long j) {
        return this.f6555b[btc.m9762a(this.f6554a, j, true, true)];
    }

    public long mo995a(long j) {
        return this.f6554a[btc.m9762a(this.f6555b, j, true, true)];
    }

    public long mo958b() {
        return this.f6556c;
    }
}
