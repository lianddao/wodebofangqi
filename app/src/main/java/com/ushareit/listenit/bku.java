package com.ushareit.listenit;

abstract class bku {
    private bkq f6771a;
    private bii f6772b;
    private bia f6773c;
    private bks f6774d;
    private long f6775e;
    private long f6776f;
    private long f6777g;
    private int f6778h;
    private int f6779i;
    private bkw f6780j;
    private long f6781k;
    private boolean f6782l;
    private boolean f6783m;

    protected abstract boolean mo1004a(bss com_ushareit_listenit_bss, long j, bkw com_ushareit_listenit_bkw);

    protected abstract long mo1005b(bss com_ushareit_listenit_bss);

    bku() {
    }

    void m8839a(bia com_ushareit_listenit_bia, bii com_ushareit_listenit_bii) {
        this.f6773c = com_ushareit_listenit_bia;
        this.f6772b = com_ushareit_listenit_bii;
        this.f6771a = new bkq();
        mo1003a(true);
    }

    protected void mo1003a(boolean z) {
        if (z) {
            this.f6780j = new bkw();
            this.f6776f = 0;
            this.f6778h = 0;
        } else {
            this.f6778h = 1;
        }
        this.f6775e = -1;
        this.f6777g = 0;
    }

    final void m8838a(long j) {
        this.f6771a.m8868a();
        if (j == 0) {
            mo1003a(!this.f6782l);
        } else if (this.f6778h != 0) {
            this.f6775e = this.f6774d.a_();
            this.f6778h = 2;
        }
    }

    final int m8837a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        switch (this.f6778h) {
            case 0:
                return m8835a(com_ushareit_listenit_bhz);
            case 1:
                com_ushareit_listenit_bhz.mo965b((int) this.f6776f);
                this.f6778h = 2;
                return 0;
            case 2:
                return m8836b(com_ushareit_listenit_bhz, com_ushareit_listenit_bie);
            default:
                throw new IllegalStateException();
        }
    }

    private int m8835a(bhz com_ushareit_listenit_bhz) {
        boolean z = true;
        while (z) {
            if (this.f6771a.m8869a(com_ushareit_listenit_bhz)) {
                this.f6781k = com_ushareit_listenit_bhz.mo968c() - this.f6776f;
                z = mo1004a(this.f6771a.m8870b(), this.f6776f, this.f6780j);
                if (z) {
                    this.f6776f = com_ushareit_listenit_bhz.mo968c();
                }
            } else {
                this.f6778h = 3;
                return -1;
            }
        }
        this.f6779i = this.f6780j.f6815a.f1443q;
        if (!this.f6783m) {
            this.f6772b.mo975a(this.f6780j.f6815a);
            this.f6783m = true;
        }
        if (this.f6780j.f6816b != null) {
            this.f6774d = this.f6780j.f6816b;
        } else if (com_ushareit_listenit_bhz.mo971d() == -1) {
            this.f6774d = new bkx();
        } else {
            this.f6774d = new bki(this.f6776f, com_ushareit_listenit_bhz.mo971d(), this);
        }
        this.f6780j = null;
        this.f6778h = 2;
        return 0;
    }

    private int m8836b(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        long a = this.f6774d.mo1000a(com_ushareit_listenit_bhz);
        if (a >= 0) {
            com_ushareit_listenit_bie.f6409a = a;
            return 1;
        }
        if (a < -1) {
            mo1006d((-a) - 2);
        }
        if (!this.f6782l) {
            this.f6773c.mo1028a(this.f6774d.mo1002d());
            this.f6782l = true;
        }
        if (this.f6781k > 0 || this.f6771a.m8869a(com_ushareit_listenit_bhz)) {
            this.f6781k = 0;
            bss b = this.f6771a.m8870b();
            long b2 = mo1005b(b);
            if (b2 >= 0 && this.f6777g + b2 >= this.f6775e) {
                long b3 = m8842b(this.f6777g);
                this.f6772b.mo976a(b, b.m9706c());
                this.f6772b.mo974a(b3, 1, b.m9706c(), 0, null);
                this.f6775e = -1;
            }
            this.f6777g += b2;
            return 0;
        }
        this.f6778h = 3;
        return -1;
    }

    protected long m8842b(long j) {
        return (1000000 * j) / ((long) this.f6779i);
    }

    protected long m8844c(long j) {
        return (((long) this.f6779i) * j) / 1000000;
    }

    protected void mo1006d(long j) {
        this.f6777g = j;
    }
}
