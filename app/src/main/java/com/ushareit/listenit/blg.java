package com.ushareit.listenit;

public final class blg implements bhy {
    public static final bib f6855a = new blh();
    private static final int f6856b = btc.m9777e("ID3");
    private final long f6857c;
    private final bss f6858d;
    private bli f6859e;
    private boolean f6860f;

    public blg() {
        this(0);
    }

    public blg(long j) {
        this.f6857c = j;
        this.f6858d = new bss(2786);
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        int s;
        bss com_ushareit_listenit_bss = new bss(10);
        int i = 0;
        while (true) {
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 10);
            com_ushareit_listenit_bss.m9707c(0);
            if (com_ushareit_listenit_bss.m9717k() != f6856b) {
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
        int i2 = i;
        while (true) {
            com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, 5);
            com_ushareit_listenit_bss.m9707c(0);
            if (com_ushareit_listenit_bss.m9714h() != 2935) {
                com_ushareit_listenit_bhz.mo962a();
                i2++;
                if (i2 - i >= 8192) {
                    return false;
                }
                com_ushareit_listenit_bhz.mo969c(i2);
                s = 0;
            } else {
                s++;
                if (s >= 4) {
                    return true;
                }
                int a = bgg.m8229a(com_ushareit_listenit_bss.f7639a);
                if (a == -1) {
                    return false;
                }
                com_ushareit_listenit_bhz.mo969c(a - 5);
            }
        }
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6859e = new bli();
        this.f6859e.mo1009a(com_ushareit_listenit_bia, new blr(0, 1));
        com_ushareit_listenit_bia.mo1026a();
        com_ushareit_listenit_bia.mo1028a(new big(-9223372036854775807L));
    }

    public void mo980a(long j) {
        this.f6860f = false;
        this.f6859e.mo1007a();
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        int a = com_ushareit_listenit_bhz.mo961a(this.f6858d.f7639a, 0, 2786);
        if (a == -1) {
            return -1;
        }
        this.f6858d.m9707c(0);
        this.f6858d.m9705b(a);
        if (!this.f6860f) {
            this.f6859e.mo1008a(this.f6857c, true);
            this.f6860f = true;
        }
        this.f6859e.mo1010a(this.f6858d);
        return 0;
    }
}
