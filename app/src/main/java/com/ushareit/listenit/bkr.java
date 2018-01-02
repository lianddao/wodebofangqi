package com.ushareit.listenit;

import java.io.EOFException;

final class bkr {
    private static final int f6800k = btc.m9777e("OggS");
    public int f6801a;
    public int f6802b;
    public long f6803c;
    public long f6804d;
    public long f6805e;
    public long f6806f;
    public int f6807g;
    public int f6808h;
    public int f6809i;
    public final int[] f6810j = new int[255];
    private final bss f6811l = new bss(255);

    bkr() {
    }

    public void m8871a() {
        this.f6801a = 0;
        this.f6802b = 0;
        this.f6803c = 0;
        this.f6804d = 0;
        this.f6805e = 0;
        this.f6806f = 0;
        this.f6807g = 0;
        this.f6808h = 0;
        this.f6809i = 0;
    }

    public boolean m8872a(bhz com_ushareit_listenit_bhz, boolean z) {
        int i = 0;
        this.f6811l.m9699a();
        m8871a();
        int i2 = (com_ushareit_listenit_bhz.mo971d() == -1 || com_ushareit_listenit_bhz.mo971d() - com_ushareit_listenit_bhz.mo964b() >= 27) ? true : 0;
        if (i2 == 0 || !com_ushareit_listenit_bhz.mo967b(this.f6811l.f7639a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.f6811l.m9718l() == ((long) f6800k)) {
            this.f6801a = this.f6811l.m9713g();
            if (this.f6801a == 0) {
                this.f6802b = this.f6811l.m9713g();
                this.f6803c = this.f6811l.m9723q();
                this.f6804d = this.f6811l.m9719m();
                this.f6805e = this.f6811l.m9719m();
                this.f6806f = this.f6811l.m9719m();
                this.f6807g = this.f6811l.m9713g();
                this.f6808h = this.f6807g + 27;
                this.f6811l.m9699a();
                com_ushareit_listenit_bhz.mo970c(this.f6811l.f7639a, 0, this.f6807g);
                while (i < this.f6807g) {
                    this.f6810j[i] = this.f6811l.m9713g();
                    this.f6809i += this.f6810j[i];
                    i++;
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new bfw("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new bfw("expected OggS capture pattern at begin of page");
        }
    }
}
