package com.ushareit.listenit;

final class bja {
    private static final long[] f6530a = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] f6531b = new byte[8];
    private int f6532c;
    private int f6533d;

    public void m8665a() {
        this.f6532c = 0;
        this.f6533d = 0;
    }

    public long m8664a(bhz com_ushareit_listenit_bhz, boolean z, boolean z2, int i) {
        if (this.f6532c == 0) {
            if (!com_ushareit_listenit_bhz.mo963a(this.f6531b, 0, 1, z)) {
                return -1;
            }
            this.f6533d = m8662a(this.f6531b[0] & 255);
            if (this.f6533d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f6532c = 1;
        }
        if (this.f6533d > i) {
            this.f6532c = 0;
            return -2;
        }
        if (this.f6533d != 1) {
            com_ushareit_listenit_bhz.mo966b(this.f6531b, 1, this.f6533d - 1);
        }
        this.f6532c = 0;
        return m8663a(this.f6531b, this.f6533d, z2);
    }

    public int m8666b() {
        return this.f6533d;
    }

    public static int m8662a(int i) {
        for (int i2 = 0; i2 < f6530a.length; i2++) {
            if ((f6530a[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long m8663a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f6530a[i - 1] ^ -1;
        }
        long j2 = j;
        for (int i2 = 1; i2 < i; i2++) {
            j2 = (j2 << 8) | (((long) bArr[i2]) & 255);
        }
        return j2;
    }
}
