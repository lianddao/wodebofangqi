package com.ushareit.listenit;

import android.util.SparseArray;
import java.util.Arrays;

final class blw {
    private final bii f6943a;
    private final boolean f6944b;
    private final boolean f6945c;
    private final SparseArray<bsq> f6946d = new SparseArray();
    private final SparseArray<bsp> f6947e = new SparseArray();
    private final bst f6948f = new bst(this.f6949g, 0, 0);
    private byte[] f6949g = new byte[128];
    private int f6950h;
    private int f6951i;
    private long f6952j;
    private boolean f6953k;
    private long f6954l;
    private blx f6955m = new blx();
    private blx f6956n = new blx();
    private boolean f6957o;
    private long f6958p;
    private long f6959q;
    private boolean f6960r;

    public blw(bii com_ushareit_listenit_bii, boolean z, boolean z2) {
        this.f6943a = com_ushareit_listenit_bii;
        this.f6944b = z;
        this.f6945c = z2;
        m8979b();
    }

    public boolean m8978a() {
        return this.f6945c;
    }

    public void m8976a(bsq com_ushareit_listenit_bsq) {
        this.f6946d.append(com_ushareit_listenit_bsq.f7625a, com_ushareit_listenit_bsq);
    }

    public void m8975a(bsp com_ushareit_listenit_bsp) {
        this.f6947e.append(com_ushareit_listenit_bsp.f7622a, com_ushareit_listenit_bsp);
    }

    public void m8979b() {
        this.f6953k = false;
        this.f6957o = false;
        this.f6956n.m8982a();
    }

    public void m8974a(long j, int i, long j2) {
        this.f6951i = i;
        this.f6954l = j2;
        this.f6952j = j;
        if (!(this.f6944b && this.f6951i == 1)) {
            if (!this.f6945c) {
                return;
            }
            if (!(this.f6951i == 5 || this.f6951i == 1 || this.f6951i == 2)) {
                return;
            }
        }
        blx com_ushareit_listenit_blx = this.f6955m;
        this.f6955m = this.f6956n;
        this.f6956n = com_ushareit_listenit_blx;
        this.f6956n.m8982a();
        this.f6950h = 0;
        this.f6953k = true;
    }

    public void m8977a(byte[] bArr, int i, int i2) {
        if (this.f6953k) {
            int i3 = i2 - i;
            if (this.f6949g.length < this.f6950h + i3) {
                this.f6949g = Arrays.copyOf(this.f6949g, (this.f6950h + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f6949g, this.f6950h, i3);
            this.f6950h = i3 + this.f6950h;
            this.f6948f.m9736a(this.f6949g, 0, this.f6950h);
            if (this.f6948f.m9739b(8)) {
                this.f6948f.m9735a(1);
                int c = this.f6948f.m9741c(2);
                this.f6948f.m9735a(5);
                if (this.f6948f.m9738b()) {
                    this.f6948f.m9740c();
                    if (this.f6948f.m9738b()) {
                        int c2 = this.f6948f.m9740c();
                        if (!this.f6945c) {
                            this.f6953k = false;
                            this.f6956n.m8983a(c2);
                        } else if (this.f6948f.m9738b()) {
                            int c3 = this.f6948f.m9740c();
                            if (this.f6947e.indexOfKey(c3) < 0) {
                                this.f6953k = false;
                                return;
                            }
                            bsp com_ushareit_listenit_bsp = (bsp) this.f6947e.get(c3);
                            bsq com_ushareit_listenit_bsq = (bsq) this.f6946d.get(com_ushareit_listenit_bsp.f7623b);
                            if (com_ushareit_listenit_bsq.f7629e) {
                                if (this.f6948f.m9739b(2)) {
                                    this.f6948f.m9735a(2);
                                } else {
                                    return;
                                }
                            }
                            if (this.f6948f.m9739b(com_ushareit_listenit_bsq.f7631g)) {
                                boolean z = false;
                                boolean z2 = false;
                                boolean z3 = false;
                                int c4 = this.f6948f.m9741c(com_ushareit_listenit_bsq.f7631g);
                                if (!com_ushareit_listenit_bsq.f7630f) {
                                    if (this.f6948f.m9739b(1)) {
                                        z = this.f6948f.m9737a();
                                        if (z) {
                                            if (this.f6948f.m9739b(1)) {
                                                z3 = this.f6948f.m9737a();
                                                z2 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                boolean z4 = this.f6951i == 5;
                                int i4 = 0;
                                if (z4) {
                                    if (this.f6948f.m9738b()) {
                                        i4 = this.f6948f.m9740c();
                                    } else {
                                        return;
                                    }
                                }
                                int i5 = 0;
                                int i6 = 0;
                                int i7 = 0;
                                int i8 = 0;
                                if (com_ushareit_listenit_bsq.f7632h == 0) {
                                    if (this.f6948f.m9739b(com_ushareit_listenit_bsq.f7633i)) {
                                        i5 = this.f6948f.m9741c(com_ushareit_listenit_bsq.f7633i);
                                        if (com_ushareit_listenit_bsp.f7624c && !z) {
                                            if (this.f6948f.m9738b()) {
                                                i6 = this.f6948f.m9742d();
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                } else if (com_ushareit_listenit_bsq.f7632h == 1 && !com_ushareit_listenit_bsq.f7634j) {
                                    if (this.f6948f.m9738b()) {
                                        i7 = this.f6948f.m9742d();
                                        if (com_ushareit_listenit_bsp.f7624c && !z) {
                                            if (this.f6948f.m9738b()) {
                                                i8 = this.f6948f.m9742d();
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                this.f6956n.m8984a(com_ushareit_listenit_bsq, c, c2, c4, c3, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                this.f6953k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public void m8973a(long j, int i) {
        int i2 = 0;
        if (this.f6951i == 9 || (this.f6945c && this.f6956n.m8980a(this.f6955m))) {
            if (this.f6957o) {
                m8972a(((int) (j - this.f6952j)) + i);
            }
            this.f6958p = this.f6952j;
            this.f6959q = this.f6954l;
            this.f6960r = false;
            this.f6957o = true;
        }
        boolean z = this.f6960r;
        if (this.f6951i == 5 || (this.f6944b && this.f6951i == 1 && this.f6956n.m8985b())) {
            i2 = 1;
        }
        this.f6960r = i2 | z;
    }

    private void m8972a(int i) {
        this.f6943a.mo974a(this.f6959q, this.f6960r ? 1 : 0, (int) (this.f6952j - this.f6958p), i, null);
    }
}
