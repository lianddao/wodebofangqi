package com.ushareit.listenit;

import android.util.Log;

final class bfr<T> {
    public final bob f6106a;
    public final Object f6107b;
    public final bof[] f6108c;
    public final boolean[] f6109d;
    public int f6110e;
    public long f6111f;
    public boolean f6112g;
    public boolean f6113h;
    public boolean f6114i;
    public long f6115j;
    public bfr<T> f6116k;
    public boolean f6117l;
    private final bfx[] f6118m;
    private final bfy[] f6119n;
    private final bqo<T> f6120o;
    private final bod f6121p;
    private bqn<T> f6122q;
    private bqn<T> f6123r;

    public bfr(bfx[] com_ushareit_listenit_bfxArr, bfy[] com_ushareit_listenit_bfyArr, bqo<T> com_ushareit_listenit_bqo_T, bod com_ushareit_listenit_bod, bob com_ushareit_listenit_bob, Object obj, long j) {
        this.f6118m = com_ushareit_listenit_bfxArr;
        this.f6119n = com_ushareit_listenit_bfyArr;
        this.f6120o = com_ushareit_listenit_bqo_T;
        this.f6121p = com_ushareit_listenit_bod;
        this.f6106a = com_ushareit_listenit_bob;
        this.f6107b = bsg.m9654a(obj);
        this.f6108c = new bof[com_ushareit_listenit_bfxArr.length];
        this.f6109d = new boolean[com_ushareit_listenit_bfxArr.length];
        this.f6111f = j;
    }

    public void m8120a(bfr<T> com_ushareit_listenit_bfr_T) {
        this.f6116k = com_ushareit_listenit_bfr_T;
    }

    public void m8121a(bgd com_ushareit_listenit_bgd, bgf com_ushareit_listenit_bgf, int i) {
        this.f6110e = i;
        boolean z = this.f6110e == com_ushareit_listenit_bgd.mo1055b() + -1 && !com_ushareit_listenit_bgf.f6165e;
        this.f6112g = z;
    }

    public boolean m8122a() {
        return this.f6113h && (!this.f6114i || this.f6106a.mo1038g() == Long.MIN_VALUE);
    }

    public void m8119a(long j, bfv com_ushareit_listenit_bfv) {
        this.f6113h = true;
        m8123b();
        this.f6111f = m8117a(j, com_ushareit_listenit_bfv, false);
    }

    public boolean m8123b() {
        bqn a = this.f6120o.mo1083a(this.f6119n, this.f6106a.mo1035d());
        if (a.equals(this.f6123r)) {
            return false;
        }
        this.f6122q = a;
        return true;
    }

    public long m8117a(long j, bfv com_ushareit_listenit_bfv, boolean z) {
        return m8118a(j, com_ushareit_listenit_bfv, z, new boolean[this.f6118m.length]);
    }

    public long m8118a(long j, bfv com_ushareit_listenit_bfv, boolean z, boolean[] zArr) {
        int i;
        for (i = 0; i < this.f6122q.f7438b; i++) {
            boolean z2;
            boolean[] zArr2 = this.f6109d;
            if (!z) {
                Object obj;
                if (this.f6123r == null) {
                    obj = null;
                } else {
                    obj = this.f6123r.m9530a(i);
                }
                if (btc.m9770a(obj, this.f6122q.m9530a(i))) {
                    z2 = true;
                    zArr2[i] = z2;
                }
            }
            z2 = false;
            zArr2[i] = z2;
        }
        long a = this.f6106a.mo1024a(this.f6122q.m9531a(), this.f6109d, this.f6108c, zArr, j);
        this.f6123r = this.f6122q;
        this.f6114i = false;
        for (i = 0; i < this.f6108c.length; i++) {
            if (this.f6108c[i] != null) {
                if (this.f6122q.m9530a(i) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bsg.m9658b(z2);
                this.f6114i = true;
            } else {
                bsg.m9658b(this.f6122q.m9530a(i) == null);
            }
        }
        com_ushareit_listenit_bfv.mo882a(this.f6118m, this.f6106a.mo1035d(), this.f6122q);
        return a;
    }

    public void m8124c() {
        try {
            this.f6121p.mo1048a(this.f6106a);
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
