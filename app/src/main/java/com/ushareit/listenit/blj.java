package com.ushareit.listenit;

public final class blj implements bhy {
    public static final bib f6873a = new blk();
    private static final int f6874b = btc.m9777e("ID3");
    private final long f6875c;
    private final bss f6876d;
    private bll f6877e;
    private boolean f6878f;

    public blj() {
        this(0);
    }

    public blj(long j) {
        this.f6875c = j;
        this.f6876d = new bss(200);
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        int s;
        bss com_ushareit_listenit_bss = new bss(10);
        bsr com_ushareit_listenit_bsr = new bsr(com_ushareit_listenit_bss.f7639a);
        int i = 0;
        while (true) {
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 10);
            com_ushareit_listenit_bss.m9707c(0);
            if (com_ushareit_listenit_bss.m9717k() != f6874b) {
                break;
            }
            com_ushareit_listenit_bss.m9709d(3);
            s = com_ushareit_listenit_bss.m9725s();
            i += s + 10;
            com_ushareit_listenit_bhz.mo969c(s);
        }
        com_ushareit_listenit_bhz.mo962a();
        com_ushareit_listenit_bhz.mo969c(i);
        s = 0;
        int i2 = 0;
        int i3 = i;
        while (true) {
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 2);
            com_ushareit_listenit_bss.m9707c(0);
            if ((com_ushareit_listenit_bss.m9714h() & 65526) != 65520) {
                com_ushareit_listenit_bhz.mo962a();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                com_ushareit_listenit_bhz.mo969c(i3);
                s = 0;
                i2 = 0;
            } else {
                s++;
                if (s >= 4 && i2 > 188) {
                    return true;
                }
                com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 4);
                com_ushareit_listenit_bsr.m9694a(14);
                int c = com_ushareit_listenit_bsr.m9697c(13);
                if (c <= 6) {
                    return false;
                }
                com_ushareit_listenit_bhz.mo969c(c - 6);
                i2 += c;
            }
        }
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6877e = new bll(true);
        this.f6877e.mo1009a(com_ushareit_listenit_bia, new blr(0, 1));
        com_ushareit_listenit_bia.mo1026a();
        com_ushareit_listenit_bia.mo1028a(new big(-9223372036854775807L));
    }

    public void mo980a(long j) {
        this.f6878f = false;
        this.f6877e.mo1007a();
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        int a = com_ushareit_listenit_bhz.mo961a(this.f6876d.f7639a, 0, 200);
        if (a == -1) {
            return -1;
        }
        this.f6876d.m9707c(0);
        this.f6876d.m9705b(a);
        if (!this.f6878f) {
            this.f6877e.mo1008a(this.f6875c, true);
            this.f6878f = true;
        }
        this.f6877e.mo1010a(this.f6876d);
        return 0;
    }
}
