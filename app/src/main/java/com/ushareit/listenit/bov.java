package com.ushareit.listenit;

import java.util.List;

public abstract class bov extends bhg implements bop {
    private bop f7242c;
    private long f7243d;

    public abstract void mo1067d();

    public void m9261a(long j, bop com_ushareit_listenit_bop, long j2) {
        this.a = j;
        this.f7242c = com_ushareit_listenit_bop;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.a;
        }
        this.f7243d = j2;
    }

    public int mo1065b() {
        return this.f7242c.mo1065b();
    }

    public long mo1064a(int i) {
        return this.f7242c.mo1064a(i) + this.f7243d;
    }

    public int mo1063a(long j) {
        return this.f7242c.mo1063a(j - this.f7243d);
    }

    public List<bom> mo1066b(long j) {
        return this.f7242c.mo1066b(j - this.f7243d);
    }

    public void mo951a() {
        super.mo951a();
        this.f7242c = null;
    }
}
