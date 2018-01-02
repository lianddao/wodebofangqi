package com.ushareit.listenit;

class bkn implements bif, bks {
    final /* synthetic */ bkl f6786a;
    private long[] f6787b;
    private long[] f6788c;
    private long f6789d;
    private volatile long f6790e;
    private volatile long f6791f;
    private long f6792g;

    private bkn(bkl com_ushareit_listenit_bkl) {
        this.f6786a = com_ushareit_listenit_bkl;
        this.f6789d = -1;
        this.f6792g = -1;
    }

    public void m8854a(long j) {
        this.f6789d = j;
    }

    public void m8855a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9709d(1);
        int k = com_ushareit_listenit_bss.m9717k() / 18;
        this.f6787b = new long[k];
        this.f6788c = new long[k];
        for (int i = 0; i < k; i++) {
            this.f6787b[i] = com_ushareit_listenit_bss.m9722p();
            this.f6788c[i] = com_ushareit_listenit_bss.m9722p();
            com_ushareit_listenit_bss.m9709d(2);
        }
    }

    public long mo1000a(bhz com_ushareit_listenit_bhz) {
        if (this.f6792g < 0) {
            return -1;
        }
        this.f6792g = (-this.f6792g) - 2;
        return this.f6792g;
    }

    public synchronized long a_() {
        this.f6792g = this.f6791f;
        return this.f6790e;
    }

    public bif mo1002d() {
        return this;
    }

    public boolean mo957a() {
        return true;
    }

    public synchronized long mo959b(long j) {
        int a;
        this.f6790e = this.f6786a.m8844c(j);
        a = btc.m9762a(this.f6787b, this.f6790e, true, true);
        this.f6791f = this.f6787b[a];
        return this.f6788c[a] + this.f6789d;
    }

    public long mo958b() {
        return this.f6786a.f6784a.m9672b();
    }
}
