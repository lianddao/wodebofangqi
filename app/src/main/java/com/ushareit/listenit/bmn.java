package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

public final class bmn implements bhy, bif {
    public static final bib f7093a = new bmo();
    private bia f7094b;
    private bii f7095c;
    private bmp f7096d;
    private int f7097e;
    private int f7098f;

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        return bmq.m9082a(com_ushareit_listenit_bhz) != null;
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f7094b = com_ushareit_listenit_bia;
        this.f7095c = com_ushareit_listenit_bia.mo1025a(0);
        this.f7096d = null;
        com_ushareit_listenit_bia.mo1026a();
    }

    public void mo980a(long j) {
        this.f7098f = 0;
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        if (this.f7096d == null) {
            this.f7096d = bmq.m9082a(com_ushareit_listenit_bhz);
            if (this.f7096d == null) {
                throw new bfw("Unsupported or unrecognized wav header.");
            }
            this.f7095c.mo975a(Format.m2067a(null, "audio/raw", null, this.f7096d.m9077c(), 32768, this.f7096d.m9079e(), this.f7096d.m9078d(), this.f7096d.m9081g(), null, null, 0, null));
            this.f7097e = this.f7096d.m9075b();
        }
        if (!this.f7096d.m9080f()) {
            bmq.m9083a(com_ushareit_listenit_bhz, this.f7096d);
            this.f7094b.mo1028a((bif) this);
        }
        int a = this.f7095c.mo973a(com_ushareit_listenit_bhz, 32768 - this.f7098f, true);
        if (a != -1) {
            this.f7098f += a;
        }
        int i = this.f7098f / this.f7097e;
        if (i > 0) {
            long b = this.f7096d.m9076b(com_ushareit_listenit_bhz.mo968c() - ((long) this.f7098f));
            int i2 = i * this.f7097e;
            this.f7098f -= i2;
            this.f7095c.mo974a(b, 1, i2, this.f7098f, null);
        }
        return a == -1 ? -1 : 0;
    }

    public long mo958b() {
        return this.f7096d.m9072a();
    }

    public boolean mo957a() {
        return true;
    }

    public long mo959b(long j) {
        return this.f7096d.m9073a(j);
    }
}
