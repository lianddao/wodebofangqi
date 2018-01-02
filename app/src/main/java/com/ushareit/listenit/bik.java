package com.ushareit.listenit;

public final class bik implements bhy, bif {
    public static final bib f6418a = new bil();
    private static final int f6419e = btc.m9777e("FLV");
    public int f6420b;
    public int f6421c;
    public long f6422d;
    private final bss f6423f = new bss(4);
    private final bss f6424g = new bss(9);
    private final bss f6425h = new bss(11);
    private final bss f6426i = new bss();
    private bia f6427j;
    private int f6428k = 1;
    private int f6429l;
    private bij f6430m;
    private bip f6431n;
    private bim f6432o;

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        com_ushareit_listenit_bhz.mo970c(this.f6423f.f7639a, 0, 3);
        this.f6423f.m9707c(0);
        if (this.f6423f.m9717k() != f6419e) {
            return false;
        }
        com_ushareit_listenit_bhz.mo970c(this.f6423f.f7639a, 0, 2);
        this.f6423f.m9707c(0);
        if ((this.f6423f.m9714h() & 250) != 0) {
            return false;
        }
        com_ushareit_listenit_bhz.mo970c(this.f6423f.f7639a, 0, 4);
        this.f6423f.m9707c(0);
        int n = this.f6423f.m9720n();
        com_ushareit_listenit_bhz.mo962a();
        com_ushareit_listenit_bhz.mo969c(n);
        com_ushareit_listenit_bhz.mo970c(this.f6423f.f7639a, 0, 4);
        this.f6423f.m9707c(0);
        if (this.f6423f.m9720n() == 0) {
            return true;
        }
        return false;
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6427j = com_ushareit_listenit_bia;
    }

    public void mo980a(long j) {
        this.f6428k = 1;
        this.f6429l = 0;
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        while (true) {
            switch (this.f6428k) {
                case 1:
                    if (m8571b(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return -1;
                case 2:
                    m8572c(com_ushareit_listenit_bhz);
                    break;
                case 3:
                    if (m8573d(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return -1;
                case 4:
                    if (!m8574e(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return 0;
                default:
                    break;
            }
        }
    }

    private boolean m8571b(bhz com_ushareit_listenit_bhz) {
        boolean z = false;
        if (!com_ushareit_listenit_bhz.mo963a(this.f6424g.f7639a, 0, 9, true)) {
            return false;
        }
        this.f6424g.m9707c(0);
        this.f6424g.m9709d(4);
        int g = this.f6424g.m9713g();
        boolean z2 = (g & 4) != 0;
        if ((g & 1) != 0) {
            z = true;
        }
        if (z2 && this.f6430m == null) {
            this.f6430m = new bij(this.f6427j.mo1025a(8));
        }
        if (z && this.f6431n == null) {
            this.f6431n = new bip(this.f6427j.mo1025a(9));
        }
        if (this.f6432o == null) {
            this.f6432o = new bim(null);
        }
        this.f6427j.mo1026a();
        this.f6427j.mo1028a((bif) this);
        this.f6429l = (this.f6424g.m9720n() - 9) + 4;
        this.f6428k = 2;
        return true;
    }

    private void m8572c(bhz com_ushareit_listenit_bhz) {
        com_ushareit_listenit_bhz.mo965b(this.f6429l);
        this.f6429l = 0;
        this.f6428k = 3;
    }

    private boolean m8573d(bhz com_ushareit_listenit_bhz) {
        if (!com_ushareit_listenit_bhz.mo963a(this.f6425h.f7639a, 0, 11, true)) {
            return false;
        }
        this.f6425h.m9707c(0);
        this.f6420b = this.f6425h.m9713g();
        this.f6421c = this.f6425h.m9717k();
        this.f6422d = (long) this.f6425h.m9717k();
        this.f6422d = (((long) (this.f6425h.m9713g() << 24)) | this.f6422d) * 1000;
        this.f6425h.m9709d(3);
        this.f6428k = 4;
        return true;
    }

    private boolean m8574e(bhz com_ushareit_listenit_bhz) {
        boolean z = true;
        if (this.f6420b == 8 && this.f6430m != null) {
            this.f6430m.m8568b(m8575f(com_ushareit_listenit_bhz), this.f6422d);
        } else if (this.f6420b == 9 && this.f6431n != null) {
            this.f6431n.m8568b(m8575f(com_ushareit_listenit_bhz), this.f6422d);
        } else if (this.f6420b != 18 || this.f6432o == null) {
            com_ushareit_listenit_bhz.mo965b(this.f6421c);
            z = false;
        } else {
            this.f6432o.m8568b(m8575f(com_ushareit_listenit_bhz), this.f6422d);
        }
        this.f6429l = 4;
        this.f6428k = 2;
        return z;
    }

    private bss m8575f(bhz com_ushareit_listenit_bhz) {
        if (this.f6421c > this.f6426i.m9710e()) {
            this.f6426i.m9702a(new byte[Math.max(this.f6426i.m9710e() * 2, this.f6421c)], 0);
        } else {
            this.f6426i.m9707c(0);
        }
        this.f6426i.m9705b(this.f6421c);
        com_ushareit_listenit_bhz.mo966b(this.f6426i.f7639a, 0, this.f6421c);
        return this.f6426i;
    }

    public boolean mo957a() {
        return false;
    }

    public long mo958b() {
        return this.f6432o.m8594a();
    }

    public long mo959b(long j) {
        return 0;
    }
}
