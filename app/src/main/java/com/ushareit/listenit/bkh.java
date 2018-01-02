package com.ushareit.listenit;

final class bkh {
    public final int f6751a;
    public final long[] f6752b;
    public final int[] f6753c;
    public final int f6754d;
    public final long[] f6755e;
    public final int[] f6756f;

    public bkh(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        bsg.m9656a(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9656a(z);
        if (iArr2.length != jArr2.length) {
            z2 = false;
        }
        bsg.m9656a(z2);
        this.f6752b = jArr;
        this.f6753c = iArr;
        this.f6754d = i;
        this.f6755e = jArr2;
        this.f6756f = iArr2;
        this.f6751a = jArr.length;
    }

    public int m8812a(long j) {
        for (int a = btc.m9762a(this.f6755e, j, true, false); a >= 0; a--) {
            if ((this.f6756f[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public int m8813b(long j) {
        for (int b = btc.m9773b(this.f6755e, j, true, false); b < this.f6755e.length; b++) {
            if ((this.f6756f[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
