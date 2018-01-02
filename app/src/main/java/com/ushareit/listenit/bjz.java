package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class bjz implements bhy, bif {
    public static final bib f6688a = new bka();
    private static final int f6689b = btc.m9777e("qt  ");
    private final bss f6690c = new bss(bso.f7618a);
    private final bss f6691d = new bss(4);
    private final bss f6692e = new bss(16);
    private final Stack<bjj> f6693f = new Stack();
    private int f6694g;
    private int f6695h;
    private long f6696i;
    private int f6697j;
    private bss f6698k;
    private int f6699l;
    private int f6700m;
    private bia f6701n;
    private bkb[] f6702o;
    private long f6703p;
    private boolean f6704q;

    public bjz() {
        m8789d();
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        return bkd.m8805b(com_ushareit_listenit_bhz);
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6701n = com_ushareit_listenit_bia;
    }

    public void mo980a(long j) {
        this.f6693f.clear();
        this.f6697j = 0;
        this.f6699l = 0;
        this.f6700m = 0;
        this.f6694g = 0;
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        while (true) {
            switch (this.f6694g) {
                case 0:
                    if (com_ushareit_listenit_bhz.mo968c() != 0) {
                        this.f6694g = 3;
                        break;
                    }
                    m8789d();
                    break;
                case 1:
                    if (m8785b(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return -1;
                case 2:
                    if (!m8786b(com_ushareit_listenit_bhz, com_ushareit_listenit_bie)) {
                        break;
                    }
                    return 1;
                default:
                    return m8787c(com_ushareit_listenit_bhz, com_ushareit_listenit_bie);
            }
        }
    }

    public boolean mo957a() {
        return true;
    }

    public long mo958b() {
        return this.f6703p;
    }

    public long mo959b(long j) {
        long j2 = Long.MAX_VALUE;
        bkb[] com_ushareit_listenit_bkbArr = this.f6702o;
        int length = com_ushareit_listenit_bkbArr.length;
        int i = 0;
        while (i < length) {
            bkb com_ushareit_listenit_bkb = com_ushareit_listenit_bkbArr[i];
            bkh com_ushareit_listenit_bkh = com_ushareit_listenit_bkb.f6714b;
            int a = com_ushareit_listenit_bkh.m8812a(j);
            if (a == -1) {
                a = com_ushareit_listenit_bkh.m8813b(j);
            }
            com_ushareit_listenit_bkb.f6716d = a;
            long j3 = com_ushareit_listenit_bkh.f6752b[a];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        return j2;
    }

    private void m8789d() {
        this.f6694g = 1;
        this.f6697j = 0;
    }

    private boolean m8785b(bhz com_ushareit_listenit_bhz) {
        if (this.f6697j == 0) {
            if (!com_ushareit_listenit_bhz.mo963a(this.f6692e.f7639a, 0, 8, true)) {
                return false;
            }
            this.f6697j = 8;
            this.f6692e.m9707c(0);
            this.f6696i = this.f6692e.m9718l();
            this.f6695h = this.f6692e.m9720n();
        }
        if (this.f6696i == 1) {
            com_ushareit_listenit_bhz.mo966b(this.f6692e.f7639a, 8, 8);
            this.f6697j += 8;
            this.f6696i = this.f6692e.m9728v();
        }
        if (m8784b(this.f6695h)) {
            long c = (com_ushareit_listenit_bhz.mo968c() + this.f6696i) - ((long) this.f6697j);
            this.f6693f.add(new bjj(this.f6695h, c));
            if (this.f6696i == ((long) this.f6697j)) {
                m8788c(c);
            } else {
                m8789d();
            }
        } else if (m8782a(this.f6695h)) {
            boolean z;
            if (this.f6697j == 8) {
                z = true;
            } else {
                z = false;
            }
            bsg.m9658b(z);
            if (this.f6696i <= 2147483647L) {
                z = true;
            } else {
                z = false;
            }
            bsg.m9658b(z);
            this.f6698k = new bss((int) this.f6696i);
            System.arraycopy(this.f6692e.f7639a, 0, this.f6698k.f7639a, 0, 8);
            this.f6694g = 2;
        } else {
            this.f6698k = null;
            this.f6694g = 2;
        }
        return true;
    }

    private boolean m8786b(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        boolean z;
        long j = this.f6696i - ((long) this.f6697j);
        long c = com_ushareit_listenit_bhz.mo968c() + j;
        if (this.f6698k != null) {
            com_ushareit_listenit_bhz.mo966b(this.f6698k.f7639a, this.f6697j, (int) j);
            if (this.f6695h == bji.f6589a) {
                this.f6704q = m8783a(this.f6698k);
                z = false;
            } else if (this.f6693f.isEmpty()) {
                z = false;
            } else {
                ((bjj) this.f6693f.peek()).m8704a(new bjk(this.f6695h, this.f6698k));
                z = false;
            }
        } else if (j < 262144) {
            com_ushareit_listenit_bhz.mo965b((int) j);
            z = false;
        } else {
            com_ushareit_listenit_bie.f6409a = j + com_ushareit_listenit_bhz.mo968c();
            z = true;
        }
        m8788c(c);
        if (!z || this.f6694g == 3) {
            return false;
        }
        return true;
    }

    private void m8788c(long j) {
        while (!this.f6693f.isEmpty() && ((bjj) this.f6693f.peek()).aN == j) {
            bjj com_ushareit_listenit_bjj = (bjj) this.f6693f.pop();
            if (com_ushareit_listenit_bjj.aM == bji.f6563A) {
                m8781a(com_ushareit_listenit_bjj);
                this.f6693f.clear();
                this.f6694g = 3;
            } else if (!this.f6693f.isEmpty()) {
                ((bjj) this.f6693f.peek()).m8703a(com_ushareit_listenit_bjj);
            }
        }
        if (this.f6694g != 3) {
            m8789d();
        }
    }

    private static boolean m8783a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(8);
        if (com_ushareit_listenit_bss.m9720n() == f6689b) {
            return true;
        }
        com_ushareit_listenit_bss.m9709d(4);
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            if (com_ushareit_listenit_bss.m9720n() == f6689b) {
                return true;
            }
        }
        return false;
    }

    private void m8781a(bjj com_ushareit_listenit_bjj) {
        List arrayList = new ArrayList();
        bic com_ushareit_listenit_bic = new bic();
        bjk d = com_ushareit_listenit_bjj.m8705d(bji.az);
        if (d != null) {
            bjl.m8715a(d, this.f6704q, com_ushareit_listenit_bic);
        }
        int i = 0;
        long j = Long.MAX_VALUE;
        long j2 = -9223372036854775807L;
        while (i < com_ushareit_listenit_bjj.aP.size()) {
            long j3;
            long j4;
            bjj com_ushareit_listenit_bjj2 = (bjj) com_ushareit_listenit_bjj.aP.get(i);
            if (com_ushareit_listenit_bjj2.aM != bji.f6565C) {
                j3 = j;
                j4 = j2;
            } else {
                bke a = bjl.m8713a(com_ushareit_listenit_bjj2, com_ushareit_listenit_bjj.m8705d(bji.f6564B), -9223372036854775807L, null, this.f6704q);
                if (a == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    bkh a2 = bjl.m8714a(a, com_ushareit_listenit_bjj2.m8706e(bji.f6566D).m8706e(bji.f6567E).m8706e(bji.f6568F), com_ushareit_listenit_bic);
                    if (a2.f6751a == 0) {
                        j3 = j;
                        j4 = j2;
                    } else {
                        bkb com_ushareit_listenit_bkb = new bkb(a, a2, this.f6701n.mo1025a(i));
                        Format a3 = a.f6723f.m2077a(a2.f6754d + 30);
                        if (a.f6719b == 1 && com_ushareit_listenit_bic.m8552a()) {
                            a3 = a3.m2078a(com_ushareit_listenit_bic.f6393a, com_ushareit_listenit_bic.f6394b);
                        }
                        com_ushareit_listenit_bkb.f6715c.mo975a(a3);
                        j2 = Math.max(j2, a.f6722e);
                        arrayList.add(com_ushareit_listenit_bkb);
                        j3 = a2.f6752b[0];
                        if (j3 < j) {
                            j4 = j2;
                        } else {
                            j3 = j;
                            j4 = j2;
                        }
                    }
                }
            }
            i++;
            j = j3;
            j2 = j4;
        }
        this.f6703p = j2;
        this.f6702o = (bkb[]) arrayList.toArray(new bkb[arrayList.size()]);
        this.f6701n.mo1026a();
        this.f6701n.mo1028a((bif) this);
    }

    private int m8787c(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        int e = m8790e();
        if (e == -1) {
            return -1;
        }
        bkb com_ushareit_listenit_bkb = this.f6702o[e];
        bii com_ushareit_listenit_bii = com_ushareit_listenit_bkb.f6715c;
        int i = com_ushareit_listenit_bkb.f6716d;
        long j = com_ushareit_listenit_bkb.f6714b.f6752b[i];
        e = com_ushareit_listenit_bkb.f6714b.f6753c[i];
        if (com_ushareit_listenit_bkb.f6713a.f6724g == 1) {
            j += 8;
            e -= 8;
        }
        long c = (j - com_ushareit_listenit_bhz.mo968c()) + ((long) this.f6699l);
        if (c < 0 || c >= 262144) {
            com_ushareit_listenit_bie.f6409a = j;
            return 1;
        }
        int a;
        com_ushareit_listenit_bhz.mo965b((int) c);
        int i2;
        if (com_ushareit_listenit_bkb.f6713a.f6728k != 0) {
            byte[] bArr = this.f6691d.f7639a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            i2 = com_ushareit_listenit_bkb.f6713a.f6728k;
            int i3 = 4 - com_ushareit_listenit_bkb.f6713a.f6728k;
            while (this.f6699l < e) {
                if (this.f6700m == 0) {
                    com_ushareit_listenit_bhz.mo966b(this.f6691d.f7639a, i3, i2);
                    this.f6691d.m9707c(0);
                    this.f6700m = this.f6691d.m9726t();
                    this.f6690c.m9707c(0);
                    com_ushareit_listenit_bii.mo976a(this.f6690c, 4);
                    this.f6699l += 4;
                    e += i3;
                } else {
                    a = com_ushareit_listenit_bii.mo973a(com_ushareit_listenit_bhz, this.f6700m, false);
                    this.f6699l += a;
                    this.f6700m -= a;
                }
            }
            a = e;
        } else {
            while (this.f6699l < e) {
                i2 = com_ushareit_listenit_bii.mo973a(com_ushareit_listenit_bhz, e - this.f6699l, false);
                this.f6699l += i2;
                this.f6700m -= i2;
            }
            a = e;
        }
        com_ushareit_listenit_bii.mo974a(com_ushareit_listenit_bkb.f6714b.f6755e[i], com_ushareit_listenit_bkb.f6714b.f6756f[i], a, 0, null);
        com_ushareit_listenit_bkb.f6716d++;
        this.f6699l = 0;
        this.f6700m = 0;
        return 0;
    }

    private int m8790e() {
        int i = -1;
        long j = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.f6702o.length; i2++) {
            bkb com_ushareit_listenit_bkb = this.f6702o[i2];
            int i3 = com_ushareit_listenit_bkb.f6716d;
            if (i3 != com_ushareit_listenit_bkb.f6714b.f6751a) {
                long j2 = com_ushareit_listenit_bkb.f6714b.f6752b[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private static boolean m8782a(int i) {
        return i == bji.f6579Q || i == bji.f6564B || i == bji.f6580R || i == bji.f6581S || i == bji.al || i == bji.am || i == bji.an || i == bji.f6578P || i == bji.ao || i == bji.ap || i == bji.aq || i == bji.ar || i == bji.as || i == bji.f6576N || i == bji.f6589a || i == bji.az;
    }

    private static boolean m8784b(int i) {
        return i == bji.f6563A || i == bji.f6565C || i == bji.f6566D || i == bji.f6567E || i == bji.f6568F || i == bji.f6577O;
    }
}
