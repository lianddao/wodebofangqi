package com.ushareit.listenit;

final class bjm {
    public final int f6622a;
    public int f6623b;
    public int f6624c;
    public long f6625d;
    private final boolean f6626e;
    private final bss f6627f;
    private final bss f6628g;
    private int f6629h;
    private int f6630i;

    public bjm(bss com_ushareit_listenit_bss, bss com_ushareit_listenit_bss2, boolean z) {
        boolean z2 = true;
        this.f6628g = com_ushareit_listenit_bss;
        this.f6627f = com_ushareit_listenit_bss2;
        this.f6626e = z;
        com_ushareit_listenit_bss2.m9707c(12);
        this.f6622a = com_ushareit_listenit_bss2.m9726t();
        com_ushareit_listenit_bss.m9707c(12);
        this.f6630i = com_ushareit_listenit_bss.m9726t();
        if (com_ushareit_listenit_bss.m9720n() != 1) {
            z2 = false;
        }
        bsg.m9659b(z2, "first_chunk must be 1");
        this.f6623b = -1;
    }

    public boolean m8728a() {
        int i = this.f6623b + 1;
        this.f6623b = i;
        if (i == this.f6622a) {
            return false;
        }
        long v;
        if (this.f6626e) {
            v = this.f6627f.m9728v();
        } else {
            v = this.f6627f.m9718l();
        }
        this.f6625d = v;
        if (this.f6623b == this.f6629h) {
            this.f6624c = this.f6628g.m9726t();
            this.f6628g.m9709d(4);
            i = this.f6630i - 1;
            this.f6630i = i;
            this.f6629h = i > 0 ? this.f6628g.m9726t() - 1 : -1;
        }
        return true;
    }
}
