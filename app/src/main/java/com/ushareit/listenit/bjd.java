package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.io.EOFException;

public final class bjd implements bhy {
    public static final bib f6539a = new bje();
    private static final int f6540b = btc.m9777e("Xing");
    private static final int f6541c = btc.m9777e("Info");
    private static final int f6542d = btc.m9777e("VBRI");
    private final long f6543e;
    private final bss f6544f;
    private final bid f6545g;
    private final bic f6546h;
    private bia f6547i;
    private bii f6548j;
    private int f6549k;
    private bjf f6550l;
    private long f6551m;
    private long f6552n;
    private int f6553o;

    public bjd() {
        this(-9223372036854775807L);
    }

    public bjd(long j) {
        this.f6543e = j;
        this.f6544f = new bss(4);
        this.f6545g = new bid();
        this.f6546h = new bic();
        this.f6551m = -9223372036854775807L;
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        return m8680a(com_ushareit_listenit_bhz, true);
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6547i = com_ushareit_listenit_bia;
        this.f6548j = this.f6547i.mo1025a(0);
        this.f6547i.mo1026a();
    }

    public void mo980a(long j) {
        this.f6549k = 0;
        this.f6551m = -9223372036854775807L;
        this.f6552n = 0;
        this.f6553o = 0;
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        if (this.f6549k == 0) {
            try {
                m8680a(com_ushareit_listenit_bhz, false);
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.f6550l == null) {
            this.f6550l = m8682c(com_ushareit_listenit_bhz);
            this.f6547i.mo1028a(this.f6550l);
            this.f6548j.mo975a(Format.m2066a(null, this.f6545g.f6403b, null, -1, 4096, this.f6545g.f6406e, this.f6545g.f6405d, -1, this.f6546h.f6393a, this.f6546h.f6394b, null, null, 0, null));
        }
        return m8681b(com_ushareit_listenit_bhz);
    }

    private int m8681b(bhz com_ushareit_listenit_bhz) {
        int n;
        if (this.f6553o == 0) {
            com_ushareit_listenit_bhz.mo962a();
            if (!com_ushareit_listenit_bhz.mo967b(this.f6544f.f7639a, 0, 4, true)) {
                return -1;
            }
            this.f6544f.m9707c(0);
            n = this.f6544f.m9720n();
            if ((n & -128000) != (this.f6549k & -128000) || bid.m8555a(n) == -1) {
                com_ushareit_listenit_bhz.mo965b(1);
                this.f6549k = 0;
                return 0;
            }
            bid.m8557a(n, this.f6545g);
            if (this.f6551m == -9223372036854775807L) {
                this.f6551m = this.f6550l.mo995a(com_ushareit_listenit_bhz.mo968c());
                if (this.f6543e != -9223372036854775807L) {
                    long a = this.f6550l.mo995a(0);
                    this.f6551m = (this.f6543e - a) + this.f6551m;
                }
            }
            this.f6553o = this.f6545g.f6404c;
        }
        n = this.f6548j.mo973a(com_ushareit_listenit_bhz, this.f6553o, true);
        if (n == -1) {
            return -1;
        }
        this.f6553o -= n;
        if (this.f6553o > 0) {
            return 0;
        }
        this.f6548j.mo974a(((this.f6552n * 1000000) / ((long) this.f6545g.f6405d)) + this.f6551m, 1, this.f6545g.f6404c, 0, null);
        this.f6552n += (long) this.f6545g.f6408g;
        this.f6553o = 0;
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8680a(com.ushareit.listenit.bhz r13, boolean r14) {
        /*
        r12 = this;
        r11 = 4;
        r10 = -128000; // 0xfffffffffffe0c00 float:NaN double:NaN;
        r7 = 1;
        r2 = 0;
        if (r14 == 0) goto L_0x0042;
    L_0x0008:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x000a:
        r13.mo962a();
        r4 = r13.mo968c();
        r8 = 0;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x009b;
    L_0x0017:
        r1 = r12.f6546h;
        com.ushareit.listenit.bjc.m8673a(r13, r1);
        r4 = r13.mo964b();
        r1 = (int) r4;
        if (r14 != 0) goto L_0x0026;
    L_0x0023:
        r13.mo965b(r1);
    L_0x0026:
        r3 = r1;
        r4 = r2;
        r5 = r2;
        r1 = r2;
    L_0x002a:
        r6 = r12.f6544f;
        r8 = r6.f7639a;
        if (r5 <= 0) goto L_0x0045;
    L_0x0030:
        r6 = r7;
    L_0x0031:
        r6 = r13.mo967b(r8, r2, r11, r6);
        if (r6 != 0) goto L_0x0047;
    L_0x0037:
        if (r14 == 0) goto L_0x0097;
    L_0x0039:
        r0 = r3 + r1;
        r13.mo965b(r0);
    L_0x003e:
        r12.f6549k = r4;
        r2 = r7;
    L_0x0041:
        return r2;
    L_0x0042:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        goto L_0x000a;
    L_0x0045:
        r6 = r2;
        goto L_0x0031;
    L_0x0047:
        r6 = r12.f6544f;
        r6.m9707c(r2);
        r6 = r12.f6544f;
        r6 = r6.m9720n();
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        r8 = r6 & r10;
        r9 = r4 & r10;
        if (r8 != r9) goto L_0x0061;
    L_0x005a:
        r8 = com.ushareit.listenit.bid.m8555a(r6);
        r9 = -1;
        if (r8 != r9) goto L_0x0084;
    L_0x0061:
        r4 = r1 + 1;
        if (r1 != r0) goto L_0x006f;
    L_0x0065:
        if (r14 != 0) goto L_0x0041;
    L_0x0067:
        r0 = new com.ushareit.listenit.bfw;
        r1 = "Searched too many bytes.";
        r0.<init>(r1);
        throw r0;
    L_0x006f:
        if (r14 == 0) goto L_0x007d;
    L_0x0071:
        r13.mo962a();
        r1 = r3 + r4;
        r13.mo969c(r1);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x007d:
        r13.mo965b(r7);
        r1 = r4;
        r5 = r2;
        r4 = r2;
        goto L_0x002a;
    L_0x0084:
        r5 = r5 + 1;
        if (r5 != r7) goto L_0x0094;
    L_0x0088:
        r4 = r12.f6545g;
        com.ushareit.listenit.bid.m8557a(r6, r4);
        r4 = r6;
    L_0x008e:
        r6 = r8 + -4;
        r13.mo969c(r6);
        goto L_0x002a;
    L_0x0094:
        if (r5 != r11) goto L_0x008e;
    L_0x0096:
        goto L_0x0037;
    L_0x0097:
        r13.mo962a();
        goto L_0x003e;
    L_0x009b:
        r1 = r2;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bjd.a(com.ushareit.listenit.bhz, boolean):boolean");
    }

    private bjf m8682c(bhz com_ushareit_listenit_bhz) {
        int n;
        bjf a;
        int i = 21;
        bss com_ushareit_listenit_bss = new bss(this.f6545g.f6404c);
        com_ushareit_listenit_bhz.mo970c(com_ushareit_listenit_bss.f7639a, 0, this.f6545g.f6404c);
        long c = com_ushareit_listenit_bhz.mo968c();
        long d = com_ushareit_listenit_bhz.mo971d();
        if ((this.f6545g.f6402a & 1) != 0) {
            if (this.f6545g.f6406e != 1) {
                i = 36;
            }
        } else if (this.f6545g.f6406e == 1) {
            i = 13;
        }
        if (com_ushareit_listenit_bss.m9706c() >= i + 4) {
            com_ushareit_listenit_bss.m9707c(i);
            n = com_ushareit_listenit_bss.m9720n();
        } else {
            n = 0;
        }
        if (n == f6540b || n == f6541c) {
            a = bjh.m8695a(this.f6545g, com_ushareit_listenit_bss, c, d);
            if (!(a == null || this.f6546h.m8552a())) {
                com_ushareit_listenit_bhz.mo962a();
                com_ushareit_listenit_bhz.mo969c(i + 141);
                com_ushareit_listenit_bhz.mo970c(this.f6544f.f7639a, 0, 3);
                this.f6544f.m9707c(0);
                this.f6546h.m8553a(this.f6544f.m9717k());
            }
            com_ushareit_listenit_bhz.mo965b(this.f6545g.f6404c);
        } else {
            if (com_ushareit_listenit_bss.m9706c() >= 40) {
                com_ushareit_listenit_bss.m9707c(36);
                if (com_ushareit_listenit_bss.m9720n() == f6542d) {
                    a = bjg.m8689a(this.f6545g, com_ushareit_listenit_bss, c, d);
                    com_ushareit_listenit_bhz.mo965b(this.f6545g.f6404c);
                }
            }
            a = null;
        }
        if (a != null) {
            return a;
        }
        com_ushareit_listenit_bhz.mo962a();
        com_ushareit_listenit_bhz.mo970c(this.f6544f.f7639a, 0, 4);
        this.f6544f.m9707c(0);
        bid.m8557a(this.f6544f.m9720n(), this.f6545g);
        return new bjb(com_ushareit_listenit_bhz.mo968c(), this.f6545g.f6407f, d);
    }
}
