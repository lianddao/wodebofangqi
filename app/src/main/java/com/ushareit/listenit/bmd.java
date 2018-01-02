package com.ushareit.listenit;

import android.util.SparseArray;
import com.umeng.analytics.pro.C0277j;

public final class bmd implements bhy {
    public static final bib f7036a = new bme();
    private final bih f7037b;
    private final SparseArray<bmf> f7038c;
    private final bss f7039d;
    private boolean f7040e;
    private boolean f7041f;
    private boolean f7042g;
    private bia f7043h;

    public bmd() {
        this(new bih(0));
    }

    public bmd(bih com_ushareit_listenit_bih) {
        this.f7037b = com_ushareit_listenit_bih;
        this.f7039d = new bss(4096);
        this.f7038c = new SparseArray();
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        boolean z = true;
        byte[] bArr = new byte[14];
        com_ushareit_listenit_bhz.mo970c(bArr, 0, 14);
        if (442 != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        com_ushareit_listenit_bhz.mo969c(bArr[13] & 7);
        com_ushareit_listenit_bhz.mo970c(bArr, 0, 3);
        if (1 != ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)))) {
            z = false;
        }
        return z;
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f7043h = com_ushareit_listenit_bia;
        com_ushareit_listenit_bia.mo1028a(new big(-9223372036854775807L));
    }

    public void mo980a(long j) {
        this.f7037b.m8564a();
        for (int i = 0; i < this.f7038c.size(); i++) {
            ((bmf) this.f7038c.valueAt(i)).m9028a();
        }
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        if (!com_ushareit_listenit_bhz.mo967b(this.f7039d.f7639a, 0, 4, true)) {
            return -1;
        }
        this.f7039d.m9707c(0);
        int n = this.f7039d.m9720n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            com_ushareit_listenit_bhz.mo970c(this.f7039d.f7639a, 0, 10);
            this.f7039d.m9707c(9);
            com_ushareit_listenit_bhz.mo965b((this.f7039d.m9713g() & 7) + 14);
            return 0;
        } else if (n == 443) {
            com_ushareit_listenit_bhz.mo970c(this.f7039d.f7639a, 0, 2);
            this.f7039d.m9707c(0);
            com_ushareit_listenit_bhz.mo965b(this.f7039d.m9714h() + 6);
            return 0;
        } else if (((n & -256) >> 8) != 1) {
            com_ushareit_listenit_bhz.mo965b(1);
            return 0;
        } else {
            int i = n & 255;
            bmf com_ushareit_listenit_bmf = (bmf) this.f7038c.get(i);
            if (!this.f7040e) {
                if (com_ushareit_listenit_bmf == null) {
                    blo com_ushareit_listenit_blo = null;
                    if (!this.f7041f && i == 189) {
                        com_ushareit_listenit_blo = new bli();
                        this.f7041f = true;
                    } else if (!this.f7041f && (i & 224) == 192) {
                        com_ushareit_listenit_blo = new bmb();
                        this.f7041f = true;
                    } else if (!this.f7042g && (i & 240) == 224) {
                        com_ushareit_listenit_blo = new bls();
                        this.f7042g = true;
                    }
                    if (com_ushareit_listenit_blo != null) {
                        com_ushareit_listenit_blo.mo1009a(this.f7043h, new blr(i, C0277j.f3694e));
                        com_ushareit_listenit_bmf = new bmf(com_ushareit_listenit_blo, this.f7037b);
                        this.f7038c.put(i, com_ushareit_listenit_bmf);
                    }
                }
                if ((this.f7041f && this.f7042g) || com_ushareit_listenit_bhz.mo968c() > 1048576) {
                    this.f7040e = true;
                    this.f7043h.mo1026a();
                }
            }
            com_ushareit_listenit_bhz.mo970c(this.f7039d.f7639a, 0, 2);
            this.f7039d.m9707c(0);
            n = this.f7039d.m9714h() + 6;
            if (com_ushareit_listenit_bmf == null) {
                com_ushareit_listenit_bhz.mo965b(n);
            } else {
                this.f7039d.m9700a(n);
                com_ushareit_listenit_bhz.mo966b(this.f7039d.f7639a, 0, n);
                this.f7039d.m9707c(6);
                com_ushareit_listenit_bmf.m9029a(this.f7039d);
                this.f7039d.m9705b(this.f7039d.m9710e());
            }
            return 0;
        }
    }
}
