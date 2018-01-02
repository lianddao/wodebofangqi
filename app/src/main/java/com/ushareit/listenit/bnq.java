package com.ushareit.listenit;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import java.io.IOException;

final class bnq implements bhw, bia, bob, bsb<bnv> {
    private long f7153A;
    private int f7154B;
    private boolean f7155C;
    private boolean f7156D;
    private final Uri f7157a;
    private final brh f7158b;
    private final int f7159c;
    private final Handler f7160d;
    private final bnz f7161e;
    private final boe f7162f;
    private final bra f7163g;
    private final bsa f7164h = new bsa("Loader:ExtractorMediaPeriod");
    private final bnw f7165i;
    private final bsj f7166j;
    private final Runnable f7167k;
    private final Runnable f7168l;
    private final Handler f7169m;
    private final SparseArray<bhs> f7170n;
    private boc f7171o;
    private bif f7172p;
    private boolean f7173q;
    private boolean f7174r;
    private boolean f7175s;
    private boolean f7176t;
    private int f7177u;
    private bok f7178v;
    private long f7179w;
    private boolean[] f7180x;
    private long f7181y;
    private long f7182z;

    public bnq(Uri uri, brh com_ushareit_listenit_brh, bhy[] com_ushareit_listenit_bhyArr, int i, Handler handler, bnz com_ushareit_listenit_bnz, boe com_ushareit_listenit_boe, bra com_ushareit_listenit_bra) {
        this.f7157a = uri;
        this.f7158b = com_ushareit_listenit_brh;
        this.f7159c = i;
        this.f7160d = handler;
        this.f7161e = com_ushareit_listenit_bnz;
        this.f7162f = com_ushareit_listenit_boe;
        this.f7163g = com_ushareit_listenit_bra;
        this.f7165i = new bnw(com_ushareit_listenit_bhyArr, this);
        this.f7166j = new bsj();
        this.f7167k = new bnr(this);
        this.f7168l = new bns(this);
        this.f7169m = new Handler();
        this.f7153A = -9223372036854775807L;
        this.f7170n = new SparseArray();
        this.f7181y = -1;
    }

    public void m9191b() {
        this.f7164h.m9643a(new bnt(this, this.f7165i));
        this.f7169m.removeCallbacksAndMessages(null);
        this.f7156D = true;
    }

    public void mo1029a(boc com_ushareit_listenit_boc) {
        this.f7171o = com_ushareit_listenit_boc;
        this.f7166j.m9668a();
        m9172j();
    }

    public void mo1034c() {
        m9198h();
    }

    public bok mo1035d() {
        return this.f7178v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo1024a(com.ushareit.listenit.bql[] r8, boolean[] r9, com.ushareit.listenit.bof[] r10, boolean[] r11, long r12) {
        /*
        r7 = this;
        r3 = 1;
        r2 = 0;
        r0 = r7.f7174r;
        com.ushareit.listenit.bsg.m9658b(r0);
        r1 = r2;
    L_0x0008:
        r0 = r8.length;
        if (r1 >= r0) goto L_0x0042;
    L_0x000b:
        r0 = r10[r1];
        if (r0 == 0) goto L_0x003e;
    L_0x000f:
        r0 = r8[r1];
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        r0 = r9[r1];
        if (r0 != 0) goto L_0x003e;
    L_0x0017:
        r0 = r10[r1];
        r0 = (com.ushareit.listenit.bnx) r0;
        r0 = r0.f7202b;
        r4 = r7.f7180x;
        r4 = r4[r0];
        com.ushareit.listenit.bsg.m9658b(r4);
        r4 = r7.f7177u;
        r4 = r4 + -1;
        r7.f7177u = r4;
        r4 = r7.f7180x;
        r4[r0] = r2;
        r4 = r7.f7170n;
        r0 = r4.valueAt(r0);
        r0 = (com.ushareit.listenit.bhs) r0;
        r0.m8496b();
        r0 = 0;
        r10[r1] = r0;
    L_0x003e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0008;
    L_0x0042:
        r0 = r2;
        r1 = r2;
    L_0x0044:
        r4 = r8.length;
        if (r0 >= r4) goto L_0x0096;
    L_0x0047:
        r4 = r10[r0];
        if (r4 != 0) goto L_0x008d;
    L_0x004b:
        r4 = r8[r0];
        if (r4 == 0) goto L_0x008d;
    L_0x004f:
        r4 = r8[r0];
        r1 = r4.mo1080b();
        if (r1 != r3) goto L_0x0090;
    L_0x0057:
        r1 = r3;
    L_0x0058:
        com.ushareit.listenit.bsg.m9658b(r1);
        r1 = r4.mo1081b(r2);
        if (r1 != 0) goto L_0x0092;
    L_0x0061:
        r1 = r3;
    L_0x0062:
        com.ushareit.listenit.bsg.m9658b(r1);
        r1 = r7.f7178v;
        r4 = r4.mo1079a();
        r4 = r1.m9238a(r4);
        r1 = r7.f7180x;
        r1 = r1[r4];
        if (r1 != 0) goto L_0x0094;
    L_0x0075:
        r1 = r3;
    L_0x0076:
        com.ushareit.listenit.bsg.m9658b(r1);
        r1 = r7.f7177u;
        r1 = r1 + 1;
        r7.f7177u = r1;
        r1 = r7.f7180x;
        r1[r4] = r3;
        r1 = new com.ushareit.listenit.bnx;
        r1.<init>(r7, r4);
        r10[r0] = r1;
        r11[r0] = r3;
        r1 = r3;
    L_0x008d:
        r0 = r0 + 1;
        goto L_0x0044;
    L_0x0090:
        r1 = r2;
        goto L_0x0058;
    L_0x0092:
        r1 = r2;
        goto L_0x0062;
    L_0x0094:
        r1 = r2;
        goto L_0x0076;
    L_0x0096:
        r0 = r7.f7175s;
        if (r0 != 0) goto L_0x00b8;
    L_0x009a:
        r0 = r7.f7170n;
        r5 = r0.size();
        r4 = r2;
    L_0x00a1:
        if (r4 >= r5) goto L_0x00b8;
    L_0x00a3:
        r0 = r7.f7180x;
        r0 = r0[r4];
        if (r0 != 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r7.f7170n;
        r0 = r0.valueAt(r4);
        r0 = (com.ushareit.listenit.bhs) r0;
        r0.m8496b();
    L_0x00b4:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00a1;
    L_0x00b8:
        r0 = r7.f7177u;
        if (r0 != 0) goto L_0x00ce;
    L_0x00bc:
        r7.f7176t = r2;
        r0 = r7.f7164h;
        r0 = r0.m9644a();
        if (r0 == 0) goto L_0x00cb;
    L_0x00c6:
        r0 = r7.f7164h;
        r0.m9645b();
    L_0x00cb:
        r7.f7175s = r3;
        return r12;
    L_0x00ce:
        r0 = r7.f7175s;
        if (r0 == 0) goto L_0x00e4;
    L_0x00d2:
        if (r1 == 0) goto L_0x00cb;
    L_0x00d4:
        r12 = r7.mo1033b(r12);
    L_0x00d8:
        r0 = r10.length;
        if (r2 >= r0) goto L_0x00cb;
    L_0x00db:
        r0 = r10[r2];
        if (r0 == 0) goto L_0x00e1;
    L_0x00df:
        r11[r2] = r3;
    L_0x00e1:
        r2 = r2 + 1;
        goto L_0x00d8;
    L_0x00e4:
        r0 = 0;
        r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00cb;
    L_0x00ea:
        goto L_0x00d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bnq.a(com.ushareit.listenit.bql[], boolean[], com.ushareit.listenit.bof[], boolean[], long):long");
    }

    public boolean mo1032a(long j) {
        if (this.f7155C) {
            return false;
        }
        boolean a = this.f7166j.m9668a();
        if (this.f7164h.m9644a()) {
            return a;
        }
        m9172j();
        return true;
    }

    public long mo1036e() {
        return mo1038g();
    }

    public long mo1037f() {
        if (!this.f7176t) {
            return -9223372036854775807L;
        }
        this.f7176t = false;
        return this.f7182z;
    }

    public long mo1038g() {
        if (this.f7155C) {
            return Long.MIN_VALUE;
        }
        if (m9175m()) {
            return this.f7153A;
        }
        long l = m9174l();
        return l == Long.MIN_VALUE ? this.f7182z : l;
    }

    public long mo1033b(long j) {
        boolean z;
        if (!this.f7172p.mo957a()) {
            j = 0;
        }
        this.f7182z = j;
        int size = this.f7170n.size();
        if (m9175m()) {
            z = false;
        } else {
            z = true;
        }
        int i = 0;
        while (z && i < size) {
            if (this.f7180x[i]) {
                z = ((bhs) this.f7170n.valueAt(i)).m8495a(j);
            }
            i++;
        }
        if (!z) {
            this.f7153A = j;
            this.f7155C = false;
            if (this.f7164h.m9644a()) {
                this.f7164h.m9645b();
            } else {
                for (i = 0; i < size; i++) {
                    ((bhs) this.f7170n.valueAt(i)).m8494a(this.f7180x[i]);
                }
            }
        }
        this.f7176t = false;
        return j;
    }

    boolean m9192b(int i) {
        return this.f7155C || !(m9175m() || ((bhs) this.f7170n.valueAt(i)).m8497c());
    }

    void m9198h() {
        this.f7164h.m9646c();
    }

    int m9176a(int i, bfu com_ushareit_listenit_bfu, bhf com_ushareit_listenit_bhf) {
        if (this.f7176t || m9175m()) {
            return -3;
        }
        return ((bhs) this.f7170n.valueAt(i)).m8488a(com_ushareit_listenit_bfu, com_ushareit_listenit_bhf, this.f7155C, this.f7182z);
    }

    public void m9184a(bnv com_ushareit_listenit_bnv, long j, long j2) {
        m9161a(com_ushareit_listenit_bnv);
        this.f7155C = true;
        if (this.f7179w == -9223372036854775807L) {
            long l = m9174l();
            this.f7179w = l == Long.MIN_VALUE ? 0 : l + 10000;
            this.f7162f.mo907a(new boi(this.f7179w, this.f7172p.mo957a()), null);
        }
    }

    public void m9185a(bnv com_ushareit_listenit_bnv, long j, long j2, boolean z) {
        m9161a(com_ushareit_listenit_bnv);
        if (!z && this.f7177u > 0) {
            int size = this.f7170n.size();
            for (int i = 0; i < size; i++) {
                ((bhs) this.f7170n.valueAt(i)).m8494a(this.f7180x[i]);
            }
            this.f7171o.mo909a(this);
        }
    }

    public int m9177a(bnv com_ushareit_listenit_bnv, long j, long j2, IOException iOException) {
        m9161a(com_ushareit_listenit_bnv);
        m9164b(iOException);
        if (m9162a(iOException)) {
            return 3;
        }
        int i;
        if (m9173k() > this.f7154B) {
            i = 1;
        } else {
            i = 0;
        }
        m9163b(com_ushareit_listenit_bnv);
        this.f7154B = m9173k();
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    public bii mo1025a(int i) {
        bhs com_ushareit_listenit_bhs = (bhs) this.f7170n.get(i);
        if (com_ushareit_listenit_bhs != null) {
            return com_ushareit_listenit_bhs;
        }
        bii com_ushareit_listenit_bhs2 = new bhs(this.f7163g);
        com_ushareit_listenit_bhs2.m8492a((bhw) this);
        this.f7170n.put(i, com_ushareit_listenit_bhs2);
        return com_ushareit_listenit_bhs2;
    }

    public void mo1026a() {
        this.f7173q = true;
        this.f7169m.post(this.f7167k);
    }

    public void mo1028a(bif com_ushareit_listenit_bif) {
        this.f7172p = com_ushareit_listenit_bif;
        this.f7169m.post(this.f7167k);
    }

    public void mo1027a(Format format) {
        this.f7169m.post(this.f7167k);
    }

    private void m9171i() {
        if (!this.f7156D && !this.f7174r && this.f7172p != null && this.f7173q) {
            int size = this.f7170n.size();
            int i = 0;
            while (i < size) {
                if (((bhs) this.f7170n.valueAt(i)).m8498d() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.f7166j.m9669b();
            boj[] com_ushareit_listenit_bojArr = new boj[size];
            this.f7180x = new boolean[size];
            this.f7179w = this.f7172p.mo958b();
            for (i = 0; i < size; i++) {
                com_ushareit_listenit_bojArr[i] = new boj(((bhs) this.f7170n.valueAt(i)).m8498d());
            }
            this.f7178v = new bok(com_ushareit_listenit_bojArr);
            this.f7174r = true;
            this.f7162f.mo907a(new boi(this.f7179w, this.f7172p.mo957a()), null);
            this.f7171o.mo908a(this);
        }
    }

    private void m9161a(bnv com_ushareit_listenit_bnv) {
        if (this.f7181y == -1) {
            this.f7181y = com_ushareit_listenit_bnv.f7197i;
        }
    }

    private void m9172j() {
        bsd com_ushareit_listenit_bnv = new bnv(this, this.f7157a, this.f7158b, this.f7165i, this.f7166j);
        if (this.f7174r) {
            bsg.m9658b(m9175m());
            if (this.f7179w == -9223372036854775807L || this.f7153A < this.f7179w) {
                com_ushareit_listenit_bnv.m9204a(this.f7172p.mo959b(this.f7153A));
                this.f7153A = -9223372036854775807L;
            } else {
                this.f7155C = true;
                this.f7153A = -9223372036854775807L;
                return;
            }
        }
        this.f7154B = m9173k();
        int i = this.f7159c;
        if (i == -1) {
            i = (this.f7174r && this.f7181y == -1 && (this.f7172p == null || this.f7172p.mo958b() == -9223372036854775807L)) ? 6 : 3;
        }
        this.f7164h.m9641a(com_ushareit_listenit_bnv, this, i);
    }

    private void m9163b(bnv com_ushareit_listenit_bnv) {
        if (this.f7181y != -1) {
            return;
        }
        if (this.f7172p == null || this.f7172p.mo958b() == -9223372036854775807L) {
            this.f7182z = 0;
            this.f7176t = this.f7174r;
            int size = this.f7170n.size();
            int i = 0;
            while (i < size) {
                boolean z;
                bhs com_ushareit_listenit_bhs = (bhs) this.f7170n.valueAt(i);
                if (!this.f7174r || this.f7180x[i]) {
                    z = true;
                } else {
                    z = false;
                }
                com_ushareit_listenit_bhs.m8494a(z);
                i++;
            }
            com_ushareit_listenit_bnv.m9204a(0);
        }
    }

    private int m9173k() {
        int i = 0;
        for (int i2 = 0; i2 < this.f7170n.size(); i2++) {
            i += ((bhs) this.f7170n.valueAt(i2)).m8487a();
        }
        return i;
    }

    private long m9174l() {
        long j = Long.MIN_VALUE;
        int size = this.f7170n.size();
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((bhs) this.f7170n.valueAt(i)).m8499e());
        }
        return j;
    }

    private boolean m9175m() {
        return this.f7153A != -9223372036854775807L;
    }

    private boolean m9162a(IOException iOException) {
        return iOException instanceof boa;
    }

    private void m9164b(IOException iOException) {
        if (this.f7160d != null && this.f7161e != null) {
            this.f7160d.post(new bnu(this, iOException));
        }
    }
}
