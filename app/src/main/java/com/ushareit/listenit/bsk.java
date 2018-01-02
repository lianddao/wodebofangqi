package com.ushareit.listenit;

public final class bsk {
    public final int f7608a;
    public final int f7609b;
    public final int f7610c;
    public final int f7611d;
    public final int f7612e;
    public final int f7613f;
    public final int f7614g;
    public final long f7615h;

    public bsk(byte[] bArr, int i) {
        bsr com_ushareit_listenit_bsr = new bsr(bArr);
        com_ushareit_listenit_bsr.m9694a(i * 8);
        this.f7608a = com_ushareit_listenit_bsr.m9697c(16);
        this.f7609b = com_ushareit_listenit_bsr.m9697c(16);
        this.f7610c = com_ushareit_listenit_bsr.m9697c(24);
        this.f7611d = com_ushareit_listenit_bsr.m9697c(24);
        this.f7612e = com_ushareit_listenit_bsr.m9697c(20);
        this.f7613f = com_ushareit_listenit_bsr.m9697c(3) + 1;
        this.f7614g = com_ushareit_listenit_bsr.m9697c(5) + 1;
        this.f7615h = (long) com_ushareit_listenit_bsr.m9697c(36);
    }

    public int m9671a() {
        return this.f7614g * this.f7612e;
    }

    public long m9672b() {
        return (this.f7615h * 1000000) / ((long) this.f7612e);
    }
}
