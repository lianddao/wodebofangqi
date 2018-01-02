package com.ushareit.listenit;

final class bkg {
    public bjs f6732a;
    public long f6733b;
    public long f6734c;
    public long f6735d;
    public int f6736e;
    public int f6737f;
    public long[] f6738g;
    public int[] f6739h;
    public int[] f6740i;
    public int[] f6741j;
    public long[] f6742k;
    public boolean[] f6743l;
    public boolean f6744m;
    public boolean[] f6745n;
    public bkf f6746o;
    public int f6747p;
    public bss f6748q;
    public boolean f6749r;
    public long f6750s;

    bkg() {
    }

    public void m8806a() {
        this.f6736e = 0;
        this.f6750s = 0;
        this.f6744m = false;
        this.f6749r = false;
        this.f6746o = null;
    }

    public void m8808a(int i, int i2) {
        this.f6736e = i;
        this.f6737f = i2;
        if (this.f6739h == null || this.f6739h.length < i) {
            this.f6738g = new long[i];
            this.f6739h = new int[i];
        }
        if (this.f6740i == null || this.f6740i.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.f6740i = new int[i3];
            this.f6741j = new int[i3];
            this.f6742k = new long[i3];
            this.f6743l = new boolean[i3];
            this.f6745n = new boolean[i3];
        }
    }

    public void m8807a(int i) {
        if (this.f6748q == null || this.f6748q.m9706c() < i) {
            this.f6748q = new bss(i);
        }
        this.f6747p = i;
        this.f6744m = true;
        this.f6749r = true;
    }

    public void m8809a(bhz com_ushareit_listenit_bhz) {
        com_ushareit_listenit_bhz.mo966b(this.f6748q.f7639a, 0, this.f6747p);
        this.f6748q.m9707c(0);
        this.f6749r = false;
    }

    public void m8810a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9703a(this.f6748q.f7639a, 0, this.f6747p);
        this.f6748q.m9707c(0);
        this.f6749r = false;
    }

    public long m8811b(int i) {
        return this.f6742k[i] + ((long) this.f6741j[i]);
    }
}
