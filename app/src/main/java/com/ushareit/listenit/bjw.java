package com.ushareit.listenit;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.umeng.analytics.pro.C0277j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class bjw implements bhy {
    public static final bib f6655a = new bjx();
    private static final int f6656b = btc.m9777e("seig");
    private static final byte[] f6657c = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private final int f6658d;
    private final bke f6659e;
    private final SparseArray<bjy> f6660f;
    private final bss f6661g;
    private final bss f6662h;
    private final bss f6663i;
    private final bih f6664j;
    private final bss f6665k;
    private final byte[] f6666l;
    private final Stack<bjj> f6667m;
    private int f6668n;
    private int f6669o;
    private long f6670p;
    private int f6671q;
    private bss f6672r;
    private long f6673s;
    private long f6674t;
    private bjy f6675u;
    private int f6676v;
    private int f6677w;
    private int f6678x;
    private bia f6679y;
    private boolean f6680z;

    public bjw() {
        this(0, null);
    }

    public bjw(int i, bih com_ushareit_listenit_bih) {
        this(i, null, com_ushareit_listenit_bih);
    }

    public bjw(int i, bke com_ushareit_listenit_bke, bih com_ushareit_listenit_bih) {
        this.f6659e = com_ushareit_listenit_bke;
        this.f6658d = (com_ushareit_listenit_bke != null ? 4 : 0) | i;
        this.f6664j = com_ushareit_listenit_bih;
        this.f6665k = new bss(16);
        this.f6661g = new bss(bso.f7618a);
        this.f6662h = new bss(4);
        this.f6663i = new bss(1);
        this.f6666l = new byte[16];
        this.f6667m = new Stack();
        this.f6660f = new SparseArray();
        this.f6674t = -9223372036854775807L;
        m8749a();
    }

    public boolean mo982a(bhz com_ushareit_listenit_bhz) {
        return bkd.m8803a(com_ushareit_listenit_bhz);
    }

    public void mo981a(bia com_ushareit_listenit_bia) {
        this.f6679y = com_ushareit_listenit_bia;
        if (this.f6659e != null) {
            bjy com_ushareit_listenit_bjy = new bjy(com_ushareit_listenit_bia.mo1025a(0));
            com_ushareit_listenit_bjy.m8780a(this.f6659e, new bjs(0, 0, 0, 0));
            this.f6660f.put(0, com_ushareit_listenit_bjy);
            this.f6679y.mo1026a();
        }
    }

    public void mo980a(long j) {
        int size = this.f6660f.size();
        for (int i = 0; i < size; i++) {
            ((bjy) this.f6660f.valueAt(i)).m8778a();
        }
        this.f6667m.clear();
        m8749a();
    }

    public void mo983c() {
    }

    public int mo979a(bhz com_ushareit_listenit_bhz, bie com_ushareit_listenit_bie) {
        while (true) {
            switch (this.f6668n) {
                case 0:
                    if (m8766b(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return -1;
                case 1:
                    m8768c(com_ushareit_listenit_bhz);
                    break;
                case 2:
                    m8770d(com_ushareit_listenit_bhz);
                    break;
                default:
                    if (!m8771e(com_ushareit_listenit_bhz)) {
                        break;
                    }
                    return 0;
            }
        }
    }

    private void m8749a() {
        this.f6668n = 0;
        this.f6671q = 0;
    }

    private boolean m8766b(bhz com_ushareit_listenit_bhz) {
        if (this.f6671q == 0) {
            if (!com_ushareit_listenit_bhz.mo963a(this.f6665k.f7639a, 0, 8, true)) {
                return false;
            }
            this.f6671q = 8;
            this.f6665k.m9707c(0);
            this.f6670p = this.f6665k.m9718l();
            this.f6669o = this.f6665k.m9720n();
        }
        if (this.f6670p == 1) {
            com_ushareit_listenit_bhz.mo966b(this.f6665k.f7639a, 8, 8);
            this.f6671q += 8;
            this.f6670p = this.f6665k.m9728v();
        }
        long c = com_ushareit_listenit_bhz.mo968c() - ((long) this.f6671q);
        if (this.f6669o == bji.f6572J) {
            int size = this.f6660f.size();
            for (int i = 0; i < size; i++) {
                bkg com_ushareit_listenit_bkg = ((bjy) this.f6660f.valueAt(i)).f6681a;
                com_ushareit_listenit_bkg.f6733b = c;
                com_ushareit_listenit_bkg.f6735d = c;
                com_ushareit_listenit_bkg.f6734c = c;
            }
        }
        if (this.f6669o == bji.f6596h) {
            this.f6675u = null;
            this.f6673s = this.f6670p + c;
            if (!this.f6680z) {
                this.f6679y.mo1028a(new big(this.f6674t));
                this.f6680z = true;
            }
            this.f6668n = 2;
            return true;
        }
        if (m8765b(this.f6669o)) {
            long c2 = (com_ushareit_listenit_bhz.mo968c() + this.f6670p) - 8;
            this.f6667m.add(new bjj(this.f6669o, c2));
            if (this.f6670p == ((long) this.f6671q)) {
                m8761b(c2);
            } else {
                m8749a();
            }
        } else if (m8759a(this.f6669o)) {
            if (this.f6671q != 8) {
                throw new bfw("Leaf atom defines extended atom size (unsupported).");
            } else if (this.f6670p > 2147483647L) {
                throw new bfw("Leaf atom with length > 2147483647 (unsupported).");
            } else {
                this.f6672r = new bss((int) this.f6670p);
                System.arraycopy(this.f6665k.f7639a, 0, this.f6672r.f7639a, 0, 8);
                this.f6668n = 1;
            }
        } else if (this.f6670p > 2147483647L) {
            throw new bfw("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.f6672r = null;
            this.f6668n = 1;
        }
        return true;
    }

    private void m8768c(bhz com_ushareit_listenit_bhz) {
        int i = ((int) this.f6670p) - this.f6671q;
        if (this.f6672r != null) {
            com_ushareit_listenit_bhz.mo966b(this.f6672r.f7639a, 8, i);
            m8753a(new bjk(this.f6669o, this.f6672r), com_ushareit_listenit_bhz.mo968c());
        } else {
            com_ushareit_listenit_bhz.mo965b(i);
        }
        m8761b(com_ushareit_listenit_bhz.mo968c());
    }

    private void m8761b(long j) {
        while (!this.f6667m.isEmpty() && ((bjj) this.f6667m.peek()).aN == j) {
            m8750a((bjj) this.f6667m.pop());
        }
        m8749a();
    }

    private void m8753a(bjk com_ushareit_listenit_bjk, long j) {
        if (!this.f6667m.isEmpty()) {
            ((bjj) this.f6667m.peek()).m8704a(com_ushareit_listenit_bjk);
        } else if (com_ushareit_listenit_bjk.aM == bji.f6614z) {
            this.f6679y.mo1028a(m8746a(com_ushareit_listenit_bjk.aN, j));
            this.f6680z = true;
        }
    }

    private void m8750a(bjj com_ushareit_listenit_bjj) {
        if (com_ushareit_listenit_bjj.aM == bji.f6563A) {
            m8762b(com_ushareit_listenit_bjj);
        } else if (com_ushareit_listenit_bjj.aM == bji.f6572J) {
            m8769c(com_ushareit_listenit_bjj);
        } else if (!this.f6667m.isEmpty()) {
            ((bjj) this.f6667m.peek()).m8703a(com_ushareit_listenit_bjj);
        }
    }

    private void m8762b(bjj com_ushareit_listenit_bjj) {
        int i;
        boolean z = true;
        int i2 = 0;
        bsg.m9659b(this.f6659e == null, "Unexpected moov box.");
        DrmInitData a = m8745a(com_ushareit_listenit_bjj.aO);
        bjj e = com_ushareit_listenit_bjj.m8706e(bji.f6574L);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = e.aO.size();
        for (i = 0; i < size; i++) {
            bjk com_ushareit_listenit_bjk = (bjk) e.aO.get(i);
            if (com_ushareit_listenit_bjk.aM == bji.f6612x) {
                Pair a2 = m8744a(com_ushareit_listenit_bjk.aN);
                sparseArray.put(((Integer) a2.first).intValue(), a2.second);
            } else if (com_ushareit_listenit_bjk.aM == bji.f6575M) {
                j = m8760b(com_ushareit_listenit_bjk.aN);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = com_ushareit_listenit_bjj.aP.size();
        for (int i3 = 0; i3 < size2; i3++) {
            bke a3;
            bjj com_ushareit_listenit_bjj2 = (bjj) com_ushareit_listenit_bjj.aP.get(i3);
            if (com_ushareit_listenit_bjj2.aM == bji.f6565C) {
                a3 = bjl.m8713a(com_ushareit_listenit_bjj2, com_ushareit_listenit_bjj.m8705d(bji.f6564B), j, a, false);
                if (a3 != null) {
                    sparseArray2.put(a3.f6718a, a3);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.f6660f.size() == 0) {
            for (i = 0; i < size3; i++) {
                a3 = (bke) sparseArray2.valueAt(i);
                this.f6660f.put(a3.f6718a, new bjy(this.f6679y.mo1025a(i)));
                this.f6674t = Math.max(this.f6674t, a3.f6722e);
            }
            this.f6679y.mo1026a();
        } else {
            if (this.f6660f.size() != size3) {
                z = false;
            }
            bsg.m9658b(z);
        }
        while (i2 < size3) {
            a3 = (bke) sparseArray2.valueAt(i2);
            ((bjy) this.f6660f.get(a3.f6718a)).m8780a(a3, (bjs) sparseArray.get(a3.f6718a));
            i2++;
        }
    }

    private void m8769c(bjj com_ushareit_listenit_bjj) {
        m8751a(com_ushareit_listenit_bjj, this.f6660f, this.f6658d, this.f6666l);
        DrmInitData a = m8745a(com_ushareit_listenit_bjj.aO);
        if (a != null) {
            int size = this.f6660f.size();
            for (int i = 0; i < size; i++) {
                ((bjy) this.f6660f.valueAt(i)).m8779a(a);
            }
        }
    }

    private static Pair<Integer, bjs> m8744a(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(12);
        return Pair.create(Integer.valueOf(com_ushareit_listenit_bss.m9720n()), new bjs(com_ushareit_listenit_bss.m9726t() - 1, com_ushareit_listenit_bss.m9726t(), com_ushareit_listenit_bss.m9726t(), com_ushareit_listenit_bss.m9720n()));
    }

    private static long m8760b(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(8);
        return bji.m8700a(com_ushareit_listenit_bss.m9720n()) == 0 ? com_ushareit_listenit_bss.m9718l() : com_ushareit_listenit_bss.m9728v();
    }

    private static void m8751a(bjj com_ushareit_listenit_bjj, SparseArray<bjy> sparseArray, int i, byte[] bArr) {
        int size = com_ushareit_listenit_bjj.aP.size();
        for (int i2 = 0; i2 < size; i2++) {
            bjj com_ushareit_listenit_bjj2 = (bjj) com_ushareit_listenit_bjj.aP.get(i2);
            if (com_ushareit_listenit_bjj2.aM == bji.f6573K) {
                m8763b(com_ushareit_listenit_bjj2, sparseArray, i, bArr);
            }
        }
    }

    private static void m8763b(bjj com_ushareit_listenit_bjj, SparseArray<bjy> sparseArray, int i, byte[] bArr) {
        bjy a = m8748a(com_ushareit_listenit_bjj.m8705d(bji.f6611w).aN, (SparseArray) sparseArray, i);
        if (a != null) {
            bkg com_ushareit_listenit_bkg = a.f6681a;
            long j = com_ushareit_listenit_bkg.f6750s;
            a.m8778a();
            if (com_ushareit_listenit_bjj.m8705d(bji.f6610v) != null && (i & 2) == 0) {
                j = m8767c(com_ushareit_listenit_bjj.m8705d(bji.f6610v).aN);
            }
            m8752a(com_ushareit_listenit_bjj, a, j, i);
            bjk d = com_ushareit_listenit_bjj.m8705d(bji.ab);
            if (d != null) {
                m8754a(a.f6683c.f6725h[com_ushareit_listenit_bkg.f6732a.f6646a], d.aN, com_ushareit_listenit_bkg);
            }
            d = com_ushareit_listenit_bjj.m8705d(bji.ac);
            if (d != null) {
                m8756a(d.aN, com_ushareit_listenit_bkg);
            }
            d = com_ushareit_listenit_bjj.m8705d(bji.ag);
            if (d != null) {
                m8764b(d.aN, com_ushareit_listenit_bkg);
            }
            d = com_ushareit_listenit_bjj.m8705d(bji.ad);
            bjk d2 = com_ushareit_listenit_bjj.m8705d(bji.ae);
            if (!(d == null || d2 == null)) {
                m8758a(d.aN, d2.aN, com_ushareit_listenit_bkg);
            }
            int size = com_ushareit_listenit_bjj.aO.size();
            for (int i2 = 0; i2 < size; i2++) {
                d = (bjk) com_ushareit_listenit_bjj.aO.get(i2);
                if (d.aM == bji.af) {
                    m8757a(d.aN, com_ushareit_listenit_bkg, bArr);
                }
            }
        }
    }

    private static void m8752a(bjj com_ushareit_listenit_bjj, bjy com_ushareit_listenit_bjy, long j, int i) {
        List list = com_ushareit_listenit_bjj.aO;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int t;
            bjk com_ushareit_listenit_bjk = (bjk) list.get(i2);
            if (com_ushareit_listenit_bjk.aM == bji.f6613y) {
                bss com_ushareit_listenit_bss = com_ushareit_listenit_bjk.aN;
                com_ushareit_listenit_bss.m9707c(12);
                t = com_ushareit_listenit_bss.m9726t();
                if (t > 0) {
                    t += i3;
                    i3 = i4 + 1;
                    i2++;
                    i4 = i3;
                    i3 = t;
                }
            }
            t = i3;
            i3 = i4;
            i2++;
            i4 = i3;
            i3 = t;
        }
        com_ushareit_listenit_bjy.f6687g = 0;
        com_ushareit_listenit_bjy.f6686f = 0;
        com_ushareit_listenit_bjy.f6685e = 0;
        com_ushareit_listenit_bjy.f6681a.m8808a(i4, i3);
        int i5 = 0;
        i3 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            com_ushareit_listenit_bjk = (bjk) list.get(i6);
            if (com_ushareit_listenit_bjk.aM == bji.f6613y) {
                int i7 = i3 + 1;
                i5 = m8743a(com_ushareit_listenit_bjy, i3, j, i, com_ushareit_listenit_bjk.aN, i5);
                i3 = i7;
            }
        }
    }

    private static void m8754a(bkf com_ushareit_listenit_bkf, bss com_ushareit_listenit_bss, bkg com_ushareit_listenit_bkg) {
        boolean z = true;
        int i = com_ushareit_listenit_bkf.f6730b;
        com_ushareit_listenit_bss.m9707c(8);
        if ((bji.m8701b(com_ushareit_listenit_bss.m9720n()) & 1) == 1) {
            com_ushareit_listenit_bss.m9709d(8);
        }
        int g = com_ushareit_listenit_bss.m9713g();
        int t = com_ushareit_listenit_bss.m9726t();
        if (t != com_ushareit_listenit_bkg.f6737f) {
            throw new bfw("Length mismatch: " + t + ", " + com_ushareit_listenit_bkg.f6737f);
        }
        if (g == 0) {
            boolean[] zArr = com_ushareit_listenit_bkg.f6745n;
            int i2 = 0;
            g = 0;
            while (i2 < t) {
                boolean z2;
                int g2 = com_ushareit_listenit_bss.m9713g();
                int i3 = g + g2;
                if (g2 > i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i2] = z2;
                i2++;
                g = i3;
            }
        } else {
            if (g <= i) {
                z = false;
            }
            g = (g * t) + 0;
            Arrays.fill(com_ushareit_listenit_bkg.f6745n, 0, t, z);
        }
        com_ushareit_listenit_bkg.m8807a(g);
    }

    private static void m8756a(bss com_ushareit_listenit_bss, bkg com_ushareit_listenit_bkg) {
        com_ushareit_listenit_bss.m9707c(8);
        int n = com_ushareit_listenit_bss.m9720n();
        if ((bji.m8701b(n) & 1) == 1) {
            com_ushareit_listenit_bss.m9709d(8);
        }
        int t = com_ushareit_listenit_bss.m9726t();
        if (t != 1) {
            throw new bfw("Unexpected saio entry count: " + t);
        }
        n = bji.m8700a(n);
        com_ushareit_listenit_bkg.f6735d = (n == 0 ? com_ushareit_listenit_bss.m9718l() : com_ushareit_listenit_bss.m9728v()) + com_ushareit_listenit_bkg.f6735d;
    }

    private static bjy m8748a(bss com_ushareit_listenit_bss, SparseArray<bjy> sparseArray, int i) {
        com_ushareit_listenit_bss.m9707c(8);
        int b = bji.m8701b(com_ushareit_listenit_bss.m9720n());
        int n = com_ushareit_listenit_bss.m9720n();
        if ((i & 4) != 0) {
            n = 0;
        }
        bjy com_ushareit_listenit_bjy = (bjy) sparseArray.get(n);
        if (com_ushareit_listenit_bjy == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long v = com_ushareit_listenit_bss.m9728v();
            com_ushareit_listenit_bjy.f6681a.f6734c = v;
            com_ushareit_listenit_bjy.f6681a.f6735d = v;
        }
        bjs com_ushareit_listenit_bjs = com_ushareit_listenit_bjy.f6684d;
        com_ushareit_listenit_bjy.f6681a.f6732a = new bjs((b & 2) != 0 ? com_ushareit_listenit_bss.m9726t() - 1 : com_ushareit_listenit_bjs.f6646a, (b & 8) != 0 ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bjs.f6647b, (b & 16) != 0 ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bjs.f6648c, (b & 32) != 0 ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bjs.f6649d);
        return com_ushareit_listenit_bjy;
    }

    private static long m8767c(bss com_ushareit_listenit_bss) {
        com_ushareit_listenit_bss.m9707c(8);
        return bji.m8700a(com_ushareit_listenit_bss.m9720n()) == 1 ? com_ushareit_listenit_bss.m9728v() : com_ushareit_listenit_bss.m9718l();
    }

    private static int m8743a(bjy com_ushareit_listenit_bjy, int i, long j, int i2, bss com_ushareit_listenit_bss, int i3) {
        Object obj;
        long a;
        com_ushareit_listenit_bss.m9707c(8);
        int b = bji.m8701b(com_ushareit_listenit_bss.m9720n());
        bke com_ushareit_listenit_bke = com_ushareit_listenit_bjy.f6683c;
        bkg com_ushareit_listenit_bkg = com_ushareit_listenit_bjy.f6681a;
        bjs com_ushareit_listenit_bjs = com_ushareit_listenit_bkg.f6732a;
        com_ushareit_listenit_bkg.f6739h[i] = com_ushareit_listenit_bss.m9726t();
        com_ushareit_listenit_bkg.f6738g[i] = com_ushareit_listenit_bkg.f6734c;
        if ((b & 1) != 0) {
            long[] jArr = com_ushareit_listenit_bkg.f6738g;
            jArr[i] = jArr[i] + ((long) com_ushareit_listenit_bss.m9720n());
        }
        Object obj2 = (b & 4) != 0 ? 1 : null;
        int i4 = com_ushareit_listenit_bjs.f6649d;
        if (obj2 != null) {
            i4 = com_ushareit_listenit_bss.m9726t();
        }
        Object obj3 = (b & C0277j.f3694e) != 0 ? 1 : null;
        Object obj4 = (b & C0277j.f3696g) != 0 ? 1 : null;
        Object obj5 = (b & 1024) != 0 ? 1 : null;
        if ((b & 2048) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (com_ushareit_listenit_bke.f6726i != null && com_ushareit_listenit_bke.f6726i.length == 1 && com_ushareit_listenit_bke.f6726i[0] == 0) {
            a = btc.m9763a(com_ushareit_listenit_bke.f6727j[0], 1000, com_ushareit_listenit_bke.f6720c);
        } else {
            a = 0;
        }
        int[] iArr = com_ushareit_listenit_bkg.f6740i;
        int[] iArr2 = com_ushareit_listenit_bkg.f6741j;
        long[] jArr2 = com_ushareit_listenit_bkg.f6742k;
        boolean[] zArr = com_ushareit_listenit_bkg.f6743l;
        Object obj6 = (com_ushareit_listenit_bke.f6719b != 2 || (i2 & 1) == 0) ? null : 1;
        int i5 = i3 + com_ushareit_listenit_bkg.f6739h[i];
        long j2 = com_ushareit_listenit_bke.f6720c;
        if (i > 0) {
            j = com_ushareit_listenit_bkg.f6750s;
        }
        long j3 = j;
        while (i3 < i5) {
            int t = obj3 != null ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bjs.f6647b;
            int t2 = obj4 != null ? com_ushareit_listenit_bss.m9726t() : com_ushareit_listenit_bjs.f6648c;
            int n = (i3 != 0 || obj2 == null) ? obj5 != null ? com_ushareit_listenit_bss.m9720n() : com_ushareit_listenit_bjs.f6649d : i4;
            if (obj != null) {
                iArr2[i3] = (int) (((long) (com_ushareit_listenit_bss.m9720n() * 1000)) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = btc.m9763a(j3, 1000, j2) - a;
            iArr[i3] = t2;
            boolean z = ((n >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j3 += (long) t;
            i3++;
        }
        com_ushareit_listenit_bkg.f6750s = j3;
        return i5;
    }

    private static void m8757a(bss com_ushareit_listenit_bss, bkg com_ushareit_listenit_bkg, byte[] bArr) {
        com_ushareit_listenit_bss.m9707c(8);
        com_ushareit_listenit_bss.m9703a(bArr, 0, 16);
        if (Arrays.equals(bArr, f6657c)) {
            m8755a(com_ushareit_listenit_bss, 16, com_ushareit_listenit_bkg);
        }
    }

    private static void m8764b(bss com_ushareit_listenit_bss, bkg com_ushareit_listenit_bkg) {
        m8755a(com_ushareit_listenit_bss, 0, com_ushareit_listenit_bkg);
    }

    private static void m8755a(bss com_ushareit_listenit_bss, int i, bkg com_ushareit_listenit_bkg) {
        com_ushareit_listenit_bss.m9707c(i + 8);
        int b = bji.m8701b(com_ushareit_listenit_bss.m9720n());
        if ((b & 1) != 0) {
            throw new bfw("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z;
        if ((b & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int t = com_ushareit_listenit_bss.m9726t();
        if (t != com_ushareit_listenit_bkg.f6737f) {
            throw new bfw("Length mismatch: " + t + ", " + com_ushareit_listenit_bkg.f6737f);
        }
        Arrays.fill(com_ushareit_listenit_bkg.f6745n, 0, t, z);
        com_ushareit_listenit_bkg.m8807a(com_ushareit_listenit_bss.m9704b());
        com_ushareit_listenit_bkg.m8810a(com_ushareit_listenit_bss);
    }

    private static void m8758a(bss com_ushareit_listenit_bss, bss com_ushareit_listenit_bss2, bkg com_ushareit_listenit_bkg) {
        com_ushareit_listenit_bss.m9707c(8);
        int n = com_ushareit_listenit_bss.m9720n();
        if (com_ushareit_listenit_bss.m9720n() == f6656b) {
            if (bji.m8700a(n) == 1) {
                com_ushareit_listenit_bss.m9709d(4);
            }
            if (com_ushareit_listenit_bss.m9720n() != 1) {
                throw new bfw("Entry count in sbgp != 1 (unsupported).");
            }
            com_ushareit_listenit_bss2.m9707c(8);
            n = com_ushareit_listenit_bss2.m9720n();
            if (com_ushareit_listenit_bss2.m9720n() == f6656b) {
                n = bji.m8700a(n);
                if (n == 1) {
                    if (com_ushareit_listenit_bss2.m9718l() == 0) {
                        throw new bfw("Variable length decription in sgpd found (unsupported)");
                    }
                } else if (n >= 2) {
                    com_ushareit_listenit_bss2.m9709d(4);
                }
                if (com_ushareit_listenit_bss2.m9718l() != 1) {
                    throw new bfw("Entry count in sgpd != 1 (unsupported).");
                }
                com_ushareit_listenit_bss2.m9709d(2);
                boolean z = com_ushareit_listenit_bss2.m9713g() == 1;
                if (z) {
                    int g = com_ushareit_listenit_bss2.m9713g();
                    byte[] bArr = new byte[16];
                    com_ushareit_listenit_bss2.m9703a(bArr, 0, bArr.length);
                    com_ushareit_listenit_bkg.f6744m = true;
                    com_ushareit_listenit_bkg.f6746o = new bkf(z, g, bArr);
                }
            }
        }
    }

    private static bhp m8746a(bss com_ushareit_listenit_bss, long j) {
        long l;
        long l2;
        com_ushareit_listenit_bss.m9707c(8);
        int a = bji.m8700a(com_ushareit_listenit_bss.m9720n());
        com_ushareit_listenit_bss.m9709d(4);
        long l3 = com_ushareit_listenit_bss.m9718l();
        if (a == 0) {
            l = com_ushareit_listenit_bss.m9718l() + j;
            l2 = com_ushareit_listenit_bss.m9718l();
        } else {
            l = com_ushareit_listenit_bss.m9728v() + j;
            l2 = com_ushareit_listenit_bss.m9728v();
        }
        com_ushareit_listenit_bss.m9709d(2);
        int h = com_ushareit_listenit_bss.m9714h();
        int[] iArr = new int[h];
        long[] jArr = new long[h];
        long[] jArr2 = new long[h];
        long[] jArr3 = new long[h];
        long j2 = l;
        int i = 0;
        long j3 = l2;
        l2 = btc.m9763a(l2, 1000000, l3);
        while (i < h) {
            int n = com_ushareit_listenit_bss.m9720n();
            if ((Integer.MIN_VALUE & n) != 0) {
                throw new bfw("Unhandled indirect reference");
            }
            long l4 = com_ushareit_listenit_bss.m9718l();
            iArr[i] = n & MoPubClientPositioning.NO_REPEAT;
            jArr[i] = j2;
            jArr3[i] = l2;
            l2 = j3 + l4;
            l4 = btc.m9763a(l2, 1000000, l3);
            jArr2[i] = l4 - jArr3[i];
            com_ushareit_listenit_bss.m9709d(4);
            j2 += (long) iArr[i];
            i++;
            j3 = l2;
            l2 = l4;
        }
        return new bhp(iArr, jArr, jArr2, jArr3);
    }

    private void m8770d(bhz com_ushareit_listenit_bhz) {
        bjy com_ushareit_listenit_bjy = null;
        long j = Long.MAX_VALUE;
        int size = this.f6660f.size();
        int i = 0;
        while (i < size) {
            bjy com_ushareit_listenit_bjy2;
            long j2;
            bkg com_ushareit_listenit_bkg = ((bjy) this.f6660f.valueAt(i)).f6681a;
            long j3;
            if (!com_ushareit_listenit_bkg.f6749r || com_ushareit_listenit_bkg.f6735d >= j) {
                j3 = j;
                com_ushareit_listenit_bjy2 = com_ushareit_listenit_bjy;
                j2 = j3;
            } else {
                j3 = com_ushareit_listenit_bkg.f6735d;
                com_ushareit_listenit_bjy2 = (bjy) this.f6660f.valueAt(i);
                j2 = j3;
            }
            i++;
            com_ushareit_listenit_bjy = com_ushareit_listenit_bjy2;
            j = j2;
        }
        if (com_ushareit_listenit_bjy == null) {
            this.f6668n = 3;
            return;
        }
        int c = (int) (j - com_ushareit_listenit_bhz.mo968c());
        if (c < 0) {
            throw new bfw("Offset to encryption data was negative.");
        }
        com_ushareit_listenit_bhz.mo965b(c);
        com_ushareit_listenit_bjy.f6681a.m8809a(com_ushareit_listenit_bhz);
    }

    private boolean m8771e(bhz com_ushareit_listenit_bhz) {
        int c;
        long j;
        int i;
        byte[] bArr;
        if (this.f6668n == 3) {
            if (this.f6675u == null) {
                bjy a = m8747a(this.f6660f);
                if (a == null) {
                    c = (int) (this.f6673s - com_ushareit_listenit_bhz.mo968c());
                    if (c < 0) {
                        throw new bfw("Offset to end of mdat was negative.");
                    }
                    com_ushareit_listenit_bhz.mo965b(c);
                    m8749a();
                    return false;
                }
                j = a.f6681a.f6738g[a.f6687g];
                c = (int) (j - com_ushareit_listenit_bhz.mo968c());
                if (c < 0) {
                    if (j == a.f6681a.f6733b) {
                        Log.w("FragmentedMp4Extractor", "Offset to sample data was missing.");
                        c = 0;
                    } else {
                        throw new bfw("Offset to sample data was negative.");
                    }
                }
                com_ushareit_listenit_bhz.mo965b(c);
                this.f6675u = a;
            }
            this.f6676v = this.f6675u.f6681a.f6740i[this.f6675u.f6685e];
            if (this.f6675u.f6681a.f6744m) {
                this.f6677w = m8742a(this.f6675u);
                this.f6676v += this.f6677w;
            } else {
                this.f6677w = 0;
            }
            if (this.f6675u.f6683c.f6724g == 1) {
                this.f6676v -= 8;
                com_ushareit_listenit_bhz.mo965b(8);
            }
            this.f6668n = 4;
            this.f6678x = 0;
        }
        bkg com_ushareit_listenit_bkg = this.f6675u.f6681a;
        bke com_ushareit_listenit_bke = this.f6675u.f6683c;
        bii com_ushareit_listenit_bii = this.f6675u.f6682b;
        int i2 = this.f6675u.f6685e;
        if (com_ushareit_listenit_bke.f6728k != 0) {
            byte[] bArr2 = this.f6662h.f7639a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            c = com_ushareit_listenit_bke.f6728k;
            i = 4 - com_ushareit_listenit_bke.f6728k;
            while (this.f6677w < this.f6676v) {
                if (this.f6678x == 0) {
                    com_ushareit_listenit_bhz.mo966b(this.f6662h.f7639a, i, c);
                    this.f6662h.m9707c(0);
                    this.f6678x = this.f6662h.m9726t();
                    this.f6661g.m9707c(0);
                    com_ushareit_listenit_bii.mo976a(this.f6661g, 4);
                    this.f6677w += 4;
                    this.f6676v += i;
                } else {
                    int a2 = com_ushareit_listenit_bii.mo973a(com_ushareit_listenit_bhz, this.f6678x, false);
                    this.f6677w += a2;
                    this.f6678x -= a2;
                }
            }
        } else {
            while (this.f6677w < this.f6676v) {
                this.f6677w = com_ushareit_listenit_bii.mo973a(com_ushareit_listenit_bhz, this.f6676v - this.f6677w, false) + this.f6677w;
            }
        }
        long b = 1000 * com_ushareit_listenit_bkg.m8811b(i2);
        i = (com_ushareit_listenit_bkg.f6744m ? 1073741824 : 0) | (com_ushareit_listenit_bkg.f6743l[i2] ? 1 : 0);
        c = com_ushareit_listenit_bkg.f6732a.f6646a;
        if (com_ushareit_listenit_bkg.f6744m) {
            bArr = com_ushareit_listenit_bkg.f6746o != null ? com_ushareit_listenit_bkg.f6746o.f6731c : com_ushareit_listenit_bke.f6725h[c].f6731c;
        } else {
            bArr = null;
        }
        if (this.f6664j != null) {
            j = this.f6664j.m8565b(b);
        } else {
            j = b;
        }
        com_ushareit_listenit_bii.mo974a(j, i, this.f6676v, 0, bArr);
        bjy com_ushareit_listenit_bjy = this.f6675u;
        com_ushareit_listenit_bjy.f6685e++;
        com_ushareit_listenit_bjy = this.f6675u;
        com_ushareit_listenit_bjy.f6686f++;
        if (this.f6675u.f6686f == com_ushareit_listenit_bkg.f6739h[this.f6675u.f6687g]) {
            com_ushareit_listenit_bjy = this.f6675u;
            com_ushareit_listenit_bjy.f6687g++;
            this.f6675u.f6686f = 0;
            this.f6675u = null;
        }
        this.f6668n = 3;
        return true;
    }

    private static bjy m8747a(SparseArray<bjy> sparseArray) {
        bjy com_ushareit_listenit_bjy = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            bjy com_ushareit_listenit_bjy2;
            long j2;
            bjy com_ushareit_listenit_bjy3 = (bjy) sparseArray.valueAt(i);
            long j3;
            if (com_ushareit_listenit_bjy3.f6687g == com_ushareit_listenit_bjy3.f6681a.f6736e) {
                j3 = j;
                com_ushareit_listenit_bjy2 = com_ushareit_listenit_bjy;
                j2 = j3;
            } else {
                long j4 = com_ushareit_listenit_bjy3.f6681a.f6738g[com_ushareit_listenit_bjy3.f6687g];
                if (j4 < j) {
                    com_ushareit_listenit_bjy2 = com_ushareit_listenit_bjy3;
                    j2 = j4;
                } else {
                    j3 = j;
                    com_ushareit_listenit_bjy2 = com_ushareit_listenit_bjy;
                    j2 = j3;
                }
            }
            i++;
            com_ushareit_listenit_bjy = com_ushareit_listenit_bjy2;
            j = j2;
        }
        return com_ushareit_listenit_bjy;
    }

    private int m8742a(bjy com_ushareit_listenit_bjy) {
        int i;
        bkg com_ushareit_listenit_bkg = com_ushareit_listenit_bjy.f6681a;
        bss com_ushareit_listenit_bss = com_ushareit_listenit_bkg.f6748q;
        int i2 = (com_ushareit_listenit_bkg.f6746o != null ? com_ushareit_listenit_bkg.f6746o : com_ushareit_listenit_bjy.f6683c.f6725h[com_ushareit_listenit_bkg.f6732a.f6646a]).f6730b;
        boolean z = com_ushareit_listenit_bkg.f6745n[com_ushareit_listenit_bjy.f6685e];
        byte[] bArr = this.f6663i.f7639a;
        if (z) {
            i = 128;
        } else {
            i = 0;
        }
        bArr[0] = (byte) (i | i2);
        this.f6663i.m9707c(0);
        bii com_ushareit_listenit_bii = com_ushareit_listenit_bjy.f6682b;
        com_ushareit_listenit_bii.mo976a(this.f6663i, 1);
        com_ushareit_listenit_bii.mo976a(com_ushareit_listenit_bss, i2);
        if (!z) {
            return i2 + 1;
        }
        int h = com_ushareit_listenit_bss.m9714h();
        com_ushareit_listenit_bss.m9709d(-2);
        h = (h * 6) + 2;
        com_ushareit_listenit_bii.mo976a(com_ushareit_listenit_bss, h);
        return (i2 + 1) + h;
    }

    private static DrmInitData m8745a(List<bjk> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            bjk com_ushareit_listenit_bjk = (bjk) list.get(i);
            if (com_ushareit_listenit_bjk.aM == bji.f6582T) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = com_ushareit_listenit_bjk.aN.f7639a;
                UUID a = bkc.m8800a(bArr);
                if (a == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    list2.add(new SchemeData(a, "video/mp4", bArr));
                }
            }
        }
        return list2 == null ? null : new DrmInitData(list2);
    }

    private static boolean m8759a(int i) {
        return i == bji.f6580R || i == bji.f6579Q || i == bji.f6564B || i == bji.f6614z || i == bji.f6581S || i == bji.f6610v || i == bji.f6611w || i == bji.f6576N || i == bji.f6612x || i == bji.f6613y || i == bji.f6582T || i == bji.ab || i == bji.ac || i == bji.ag || i == bji.af || i == bji.ad || i == bji.ae || i == bji.f6578P || i == bji.f6575M;
    }

    private static boolean m8765b(int i) {
        return i == bji.f6563A || i == bji.f6565C || i == bji.f6566D || i == bji.f6567E || i == bji.f6568F || i == bji.f6572J || i == bji.f6573K || i == bji.f6574L || i == bji.f6577O;
    }
}
