package com.ushareit.listenit;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.Collections;

final class bly extends blo {
    private bii f6977a;
    private bmg f6978b;
    private boolean f6979c;
    private final boolean[] f6980d = new boolean[3];
    private final bmc f6981e = new bmc(32, 128);
    private final bmc f6982f = new bmc(33, 128);
    private final bmc f6983g = new bmc(34, 128);
    private final bmc f6984h = new bmc(39, 128);
    private final bmc f6985i = new bmc(40, 128);
    private final blz f6986j = new blz(this.f6977a);
    private long f6987k;
    private long f6988l;
    private final bss f6989m = new bss();

    public void mo1007a() {
        bso.m9687a(this.f6980d);
        this.f6981e.m9015a();
        this.f6982f.m9015a();
        this.f6983g.m9015a();
        this.f6984h.m9015a();
        this.f6985i.m9015a();
        this.f6986j.m8998a();
        this.f6987k = 0;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6977a = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
        this.f6978b = new bmg(com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a()));
    }

    public void mo1008a(long j, boolean z) {
        this.f6988l = j;
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        while (com_ushareit_listenit_bss.m9704b() > 0) {
            int d = com_ushareit_listenit_bss.m9708d();
            int c = com_ushareit_listenit_bss.m9706c();
            byte[] bArr = com_ushareit_listenit_bss.f7639a;
            this.f6987k += (long) com_ushareit_listenit_bss.m9704b();
            this.f6977a.mo976a(com_ushareit_listenit_bss, com_ushareit_listenit_bss.m9704b());
            while (d < c) {
                int a = bso.m9683a(bArr, d, c, this.f6980d);
                if (a == c) {
                    m8989a(bArr, d, c);
                    return;
                }
                int c2 = bso.m9690c(bArr, a);
                int i = a - d;
                if (i > 0) {
                    m8989a(bArr, d, a);
                }
                int i2 = c - a;
                long j = this.f6987k - ((long) i2);
                m8990b(j, i2, i < 0 ? -i : 0, this.f6988l);
                m8987a(j, i2, c2, this.f6988l);
                d = a + 3;
            }
        }
    }

    public void mo1011b() {
    }

    private void m8987a(long j, int i, int i2, long j2) {
        if (this.f6979c) {
            this.f6986j.m9000a(j, i, i2, j2);
        } else {
            this.f6981e.m9016a(i2);
            this.f6982f.m9016a(i2);
            this.f6983g.m9016a(i2);
        }
        this.f6984h.m9016a(i2);
        this.f6985i.m9016a(i2);
    }

    private void m8989a(byte[] bArr, int i, int i2) {
        if (this.f6979c) {
            this.f6986j.m9001a(bArr, i, i2);
        } else {
            this.f6981e.m9017a(bArr, i, i2);
            this.f6982f.m9017a(bArr, i, i2);
            this.f6983g.m9017a(bArr, i, i2);
        }
        this.f6984h.m9017a(bArr, i, i2);
        this.f6985i.m9017a(bArr, i, i2);
    }

    private void m8990b(long j, int i, int i2, long j2) {
        if (this.f6979c) {
            this.f6986j.m8999a(j, i);
        } else {
            this.f6981e.m9019b(i2);
            this.f6982f.m9019b(i2);
            this.f6983g.m9019b(i2);
            if (this.f6981e.m9018b() && this.f6982f.m9018b() && this.f6983g.m9018b()) {
                this.f6977a.mo975a(m8986a(this.f6981e, this.f6982f, this.f6983g));
                this.f6979c = true;
            }
        }
        if (this.f6984h.m9019b(i2)) {
            this.f6989m.m9702a(this.f6984h.f7031a, bso.m9682a(this.f6984h.f7031a, this.f6984h.f7032b));
            this.f6989m.m9709d(5);
            this.f6978b.m9030a(j2, this.f6989m);
        }
        if (this.f6985i.m9019b(i2)) {
            this.f6989m.m9702a(this.f6985i.f7031a, bso.m9682a(this.f6985i.f7031a, this.f6985i.f7032b));
            this.f6989m.m9709d(5);
            this.f6978b.m9030a(j2, this.f6989m);
        }
    }

    private static Format m8986a(bmc com_ushareit_listenit_bmc, bmc com_ushareit_listenit_bmc2, bmc com_ushareit_listenit_bmc3) {
        int i;
        float f;
        Object obj = new byte[((com_ushareit_listenit_bmc.f7032b + com_ushareit_listenit_bmc2.f7032b) + com_ushareit_listenit_bmc3.f7032b)];
        System.arraycopy(com_ushareit_listenit_bmc.f7031a, 0, obj, 0, com_ushareit_listenit_bmc.f7032b);
        System.arraycopy(com_ushareit_listenit_bmc2.f7031a, 0, obj, com_ushareit_listenit_bmc.f7032b, com_ushareit_listenit_bmc2.f7032b);
        System.arraycopy(com_ushareit_listenit_bmc3.f7031a, 0, obj, com_ushareit_listenit_bmc.f7032b + com_ushareit_listenit_bmc2.f7032b, com_ushareit_listenit_bmc3.f7032b);
        bst com_ushareit_listenit_bst = new bst(com_ushareit_listenit_bmc2.f7031a, 0, com_ushareit_listenit_bmc2.f7032b);
        com_ushareit_listenit_bst.m9735a(44);
        int c = com_ushareit_listenit_bst.m9741c(3);
        com_ushareit_listenit_bst.m9735a(1);
        com_ushareit_listenit_bst.m9735a(88);
        com_ushareit_listenit_bst.m9735a(8);
        int i2 = 0;
        for (i = 0; i < c; i++) {
            if (com_ushareit_listenit_bst.m9737a()) {
                i2 += 89;
            }
            if (com_ushareit_listenit_bst.m9737a()) {
                i2 += 8;
            }
        }
        com_ushareit_listenit_bst.m9735a(i2);
        if (c > 0) {
            com_ushareit_listenit_bst.m9735a((8 - c) * 2);
        }
        com_ushareit_listenit_bst.m9740c();
        int c2 = com_ushareit_listenit_bst.m9740c();
        if (c2 == 3) {
            com_ushareit_listenit_bst.m9735a(1);
        }
        int c3 = com_ushareit_listenit_bst.m9740c();
        int c4 = com_ushareit_listenit_bst.m9740c();
        if (com_ushareit_listenit_bst.m9737a()) {
            int c5 = com_ushareit_listenit_bst.m9740c();
            int c6 = com_ushareit_listenit_bst.m9740c();
            int c7 = com_ushareit_listenit_bst.m9740c();
            int c8 = com_ushareit_listenit_bst.m9740c();
            i = (c2 == 1 || c2 == 2) ? 2 : 1;
            c3 -= i * (c5 + c6);
            c4 -= (c2 == 1 ? 2 : 1) * (c7 + c8);
        }
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        i = com_ushareit_listenit_bst.m9740c();
        i2 = com_ushareit_listenit_bst.m9737a() ? 0 : c;
        while (i2 <= c) {
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9740c();
            i2++;
        }
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        com_ushareit_listenit_bst.m9740c();
        if (com_ushareit_listenit_bst.m9737a() && com_ushareit_listenit_bst.m9737a()) {
            m8988a(com_ushareit_listenit_bst);
        }
        com_ushareit_listenit_bst.m9735a(2);
        if (com_ushareit_listenit_bst.m9737a()) {
            com_ushareit_listenit_bst.m9735a(8);
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9740c();
            com_ushareit_listenit_bst.m9735a(1);
        }
        m8991b(com_ushareit_listenit_bst);
        if (com_ushareit_listenit_bst.m9737a()) {
            for (i2 = 0; i2 < com_ushareit_listenit_bst.m9740c(); i2++) {
                com_ushareit_listenit_bst.m9735a((i + 4) + 1);
            }
        }
        com_ushareit_listenit_bst.m9735a(2);
        float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        if (com_ushareit_listenit_bst.m9737a() && com_ushareit_listenit_bst.m9737a()) {
            c = com_ushareit_listenit_bst.m9741c(8);
            if (c == 255) {
                c = com_ushareit_listenit_bst.m9741c(16);
                i = com_ushareit_listenit_bst.m9741c(16);
                if (!(c == 0 || i == 0)) {
                    f2 = ((float) c) / ((float) i);
                }
                f = f2;
            } else if (c < bso.f7619b.length) {
                f = bso.f7619b[c];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            return Format.m2064a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
        }
        f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        return Format.m2064a(null, "video/hevc", null, -1, -1, c3, c4, -1.0f, Collections.singletonList(obj), -1, f, null);
    }

    private static void m8988a(bst com_ushareit_listenit_bst) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (com_ushareit_listenit_bst.m9737a()) {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        com_ushareit_listenit_bst.m9742d();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        com_ushareit_listenit_bst.m9742d();
                    }
                } else {
                    com_ushareit_listenit_bst.m9740c();
                }
            }
            i++;
        }
    }

    private static void m8991b(bst com_ushareit_listenit_bst) {
        int c = com_ushareit_listenit_bst.m9740c();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < c) {
            boolean a;
            if (i != 0) {
                a = com_ushareit_listenit_bst.m9737a();
            } else {
                a = z;
            }
            int i3;
            if (a) {
                com_ushareit_listenit_bst.m9735a(1);
                com_ushareit_listenit_bst.m9740c();
                for (i3 = 0; i3 <= i2; i3++) {
                    if (com_ushareit_listenit_bst.m9737a()) {
                        com_ushareit_listenit_bst.m9735a(1);
                    }
                }
            } else {
                int c2 = com_ushareit_listenit_bst.m9740c();
                int c3 = com_ushareit_listenit_bst.m9740c();
                i2 = c2 + c3;
                for (i3 = 0; i3 < c2; i3++) {
                    com_ushareit_listenit_bst.m9740c();
                    com_ushareit_listenit_bst.m9735a(1);
                }
                for (i3 = 0; i3 < c3; i3++) {
                    com_ushareit_listenit_bst.m9740c();
                    com_ushareit_listenit_bst.m9735a(1);
                }
            }
            i++;
            z = a;
        }
    }
}
