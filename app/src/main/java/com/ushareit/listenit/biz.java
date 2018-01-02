package com.ushareit.listenit;

final class biz {
    private final bss f6527a = new bss(8);
    private int f6528b;

    public boolean m8661a(bhz com_ushareit_listenit_bhz) {
        long d = com_ushareit_listenit_bhz.mo971d();
        long j = (d == -1 || d > 1024) ? 1024 : d;
        int i = (int) j;
        com_ushareit_listenit_bhz.mo970c(this.f6527a.f7639a, 0, 4);
        j = this.f6527a.m9718l();
        this.f6528b = 4;
        while (j != 440786851) {
            int i2 = this.f6528b + 1;
            this.f6528b = i2;
            if (i2 == i) {
                return false;
            }
            com_ushareit_listenit_bhz.mo970c(this.f6527a.f7639a, 0, 1);
            j = ((j << 8) & -256) | ((long) (this.f6527a.f7639a[0] & 255));
        }
        j = m8660b(com_ushareit_listenit_bhz);
        long j2 = (long) this.f6528b;
        if (j == Long.MIN_VALUE) {
            return false;
        }
        if (d != -1 && j2 + j >= d) {
            return false;
        }
        while (((long) this.f6528b) < j2 + j) {
            if (m8660b(com_ushareit_listenit_bhz) == Long.MIN_VALUE) {
                return false;
            }
            d = m8660b(com_ushareit_listenit_bhz);
            if (d < 0 || d > 2147483647L) {
                return false;
            }
            if (d != 0) {
                com_ushareit_listenit_bhz.mo969c((int) d);
                this.f6528b = (int) (d + ((long) this.f6528b));
            }
        }
        return ((long) this.f6528b) == j + j2;
    }

    private long m8660b(bhz com_ushareit_listenit_bhz) {
        int i = 0;
        com_ushareit_listenit_bhz.mo970c(this.f6527a.f7639a, 0, 1);
        int i2 = this.f6527a.f7639a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i4++;
            i3 >>= 1;
        }
        i3 = (i3 ^ -1) & i2;
        com_ushareit_listenit_bhz.mo970c(this.f6527a.f7639a, 1, i4);
        while (i < i4) {
            i3 = (i3 << 8) + (this.f6527a.f7639a[i + 1] & 255);
            i++;
        }
        this.f6528b += i4 + 1;
        return (long) i3;
    }
}
