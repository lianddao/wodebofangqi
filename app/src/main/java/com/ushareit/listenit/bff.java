package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

public abstract class bff implements bfx, bfy {
    private final int f6036a;
    private int f6037b;
    private int f6038c;
    private bof f6039d;
    private long f6040e;
    private boolean f6041f = true;
    private boolean f6042g;

    public bff(int i) {
        this.f6036a = i;
    }

    public final int mo864a() {
        return this.f6036a;
    }

    public final bfy mo870b() {
        return this;
    }

    public final void mo865a(int i) {
        this.f6037b = i;
    }

    public bsm mo871c() {
        return null;
    }

    public final int mo872d() {
        return this.f6038c;
    }

    public final void mo869a(Format[] formatArr, bof com_ushareit_listenit_bof, long j, boolean z, long j2) {
        bsg.m9658b(this.f6038c == 0);
        this.f6038c = 1;
        mo934a(z);
        mo868a(formatArr, com_ushareit_listenit_bof, j2);
        mo933a(j, z);
    }

    public final void mo873e() {
        boolean z = true;
        if (this.f6038c != 1) {
            z = false;
        }
        bsg.m9658b(z);
        this.f6038c = 2;
        mo935m();
    }

    public final void mo868a(Format[] formatArr, bof com_ushareit_listenit_bof, long j) {
        bsg.m9658b(!this.f6042g);
        this.f6039d = com_ushareit_listenit_bof;
        this.f6041f = false;
        this.f6040e = j;
        mo1070a(formatArr);
    }

    public final bof mo874f() {
        return this.f6039d;
    }

    public final boolean mo875g() {
        return this.f6041f;
    }

    public final void mo876h() {
        this.f6042g = true;
    }

    public final void mo877i() {
        this.f6039d.mo1045b();
    }

    public final void mo867a(long j) {
        this.f6042g = false;
        mo933a(j, false);
    }

    public final void mo878j() {
        bsg.m9658b(this.f6038c == 2);
        this.f6038c = 1;
        mo936n();
    }

    public final void mo879k() {
        boolean z = true;
        if (this.f6038c != 1) {
            z = false;
        }
        bsg.m9658b(z);
        this.f6038c = 0;
        mo937o();
        this.f6039d = null;
        this.f6042g = false;
    }

    public int mo880l() {
        return 0;
    }

    public void mo866a(int i, Object obj) {
    }

    protected void mo934a(boolean z) {
    }

    protected void mo1070a(Format[] formatArr) {
    }

    protected void mo933a(long j, boolean z) {
    }

    protected void mo935m() {
    }

    protected void mo936n() {
    }

    protected void mo937o() {
    }

    protected final int m8003p() {
        return this.f6037b;
    }

    protected final int m7979a(bfu com_ushareit_listenit_bfu, bhf com_ushareit_listenit_bhf) {
        int a = this.f6039d.mo1042a(com_ushareit_listenit_bfu, com_ushareit_listenit_bhf);
        if (a == -4) {
            if (com_ushareit_listenit_bhf.m8384c()) {
                this.f6041f = true;
                if (this.f6042g) {
                    return -4;
                }
                return -3;
            }
            com_ushareit_listenit_bhf.f6322c += this.f6040e;
        }
        return a;
    }

    protected final boolean m8004q() {
        return this.f6041f ? this.f6042g : this.f6039d.mo1044a();
    }

    protected void m7989b(long j) {
        this.f6039d.mo1043a(j);
    }
}
