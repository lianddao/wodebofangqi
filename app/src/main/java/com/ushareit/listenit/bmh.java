package com.ushareit.listenit;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public final class bmh implements bhy {
    public static final bib f7053a = new bmi();
    private static final long f7054b = ((long) btc.m9777e("AC-3"));
    private static final long f7055c = ((long) btc.m9777e("EAC3"));
    private static final long f7056d = ((long) btc.m9777e("HEVC"));
    private final boolean f7057e;
    private final bih f7058f;
    private final bss f7059g;
    private final bsr f7060h;
    private final SparseIntArray f7061i;
    private final blq f7062j;
    private final SparseArray<bmm> f7063k;
    private final SparseBooleanArray f7064l;
    private bia f7065m;
    private boolean f7066n;
    private blo f7067o;

    public bmh() {
        this(new bih(0));
    }

    public bmh(bih com_ushareit_listenit_bih) {
        this(com_ushareit_listenit_bih, new blm(), false);
    }

    public bmh(bih com_ushareit_listenit_bih, blq com_ushareit_listenit_blq, boolean z) {
        this.f7058f = com_ushareit_listenit_bih;
        this.f7062j = (blq) bsg.m9654a((Object) com_ushareit_listenit_blq);
        this.f7057e = z;
        this.f7059g = new bss(940);
        this.f7060h = new bsr(new byte[3]);
        this.f7064l = new SparseBooleanArray();
        this.f7063k = new SparseArray();
        this.f7061i = new SparseIntArray();
        m9041e();
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        byte[] bArr = this.f7059g.f7639a;
        com_ushareit_listenit_bhz.mo970c(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] != (byte) 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            com_ushareit_listenit_bhz.mo965b(i);
            return true;
        }
        return false;
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f7065m = com_ushareit_listenit_bia;
        com_ushareit_listenit_bia.mo1028a(new big(-9223372036854775807L));
    }

    public void mo980a(long j) {
        this.f7058f.m8564a();
        this.f7059g.m9699a();
        this.f7061i.clear();
        m9041e();
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        int b;
        int a;
        byte[] bArr = this.f7059g.f7639a;
        if (940 - this.f7059g.m9708d() < 188) {
            b = this.f7059g.m9704b();
            if (b > 0) {
                System.arraycopy(bArr, this.f7059g.m9708d(), bArr, 0, b);
            }
            this.f7059g.m9702a(bArr, b);
        }
        while (this.f7059g.m9704b() < 188) {
            b = this.f7059g.m9706c();
            a = com_ushareit_listenit_bhz.mo961a(bArr, b, 940 - b);
            if (a == -1) {
                return -1;
            }
            this.f7059g.m9705b(b + a);
        }
        b = this.f7059g.m9706c();
        int d = this.f7059g.m9708d();
        while (d < b && bArr[d] != (byte) 71) {
            d++;
        }
        this.f7059g.m9707c(d);
        a = d + 188;
        if (a > b) {
            return 0;
        }
        this.f7059g.m9709d(1);
        this.f7059g.m9701a(this.f7060h, 3);
        if (this.f7060h.m9696b()) {
            this.f7059g.m9707c(a);
            return 0;
        }
        boolean b2 = this.f7060h.m9696b();
        this.f7060h.m9695b(1);
        d = this.f7060h.m9697c(13);
        this.f7060h.m9695b(2);
        boolean b3 = this.f7060h.m9696b();
        boolean b4 = this.f7060h.m9696b();
        int c = this.f7060h.m9697c(4);
        int i = this.f7061i.get(d, c - 1);
        this.f7061i.put(d, c);
        if (i == c) {
            this.f7059g.m9707c(a);
            return 0;
        }
        if (c != (i + 1) % 16) {
            c = 1;
        } else {
            c = 0;
        }
        if (b3) {
            this.f7059g.m9709d(this.f7059g.m9713g());
        }
        if (b4) {
            bmm com_ushareit_listenit_bmm = (bmm) this.f7063k.get(d);
            if (com_ushareit_listenit_bmm != null) {
                if (c != 0) {
                    com_ushareit_listenit_bmm.mo1013a();
                }
                this.f7059g.m9705b(a);
                com_ushareit_listenit_bmm.mo1014a(this.f7059g, b2, this.f7065m);
                bsg.m9658b(this.f7059g.m9708d() <= a);
                this.f7059g.m9705b(b);
            }
        }
        this.f7059g.m9707c(a);
        return 0;
    }

    private void m9041e() {
        this.f7064l.clear();
        this.f7063k.clear();
        this.f7063k.put(0, new bmj(this));
        this.f7067o = null;
    }
}
