package com.ushareit.listenit;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.Arrays;
import java.util.Collections;

final class bls extends blo {
    private static final double[] f6913b = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private bii f6914a;
    private boolean f6915c;
    private long f6916d;
    private final boolean[] f6917e = new boolean[4];
    private final blt f6918f = new blt(128);
    private boolean f6919g;
    private long f6920h;
    private long f6921i;
    private boolean f6922j;
    private boolean f6923k;
    private long f6924l;
    private long f6925m;

    public void mo1007a() {
        bso.m9687a(this.f6917e);
        this.f6918f.m8961a();
        this.f6922j = false;
        this.f6919g = false;
        this.f6920h = 0;
    }

    public void mo1009a(bia com_ushareit_listenit_bia, blr com_ushareit_listenit_blr) {
        this.f6914a = com_ushareit_listenit_bia.mo1025a(com_ushareit_listenit_blr.m8954a());
    }

    public void mo1008a(long j, boolean z) {
        this.f6922j = j != -9223372036854775807L;
        if (this.f6922j) {
            this.f6921i = j;
        }
    }

    public void mo1010a(bss com_ushareit_listenit_bss) {
        int d = com_ushareit_listenit_bss.m9708d();
        int c = com_ushareit_listenit_bss.m9706c();
        byte[] bArr = com_ushareit_listenit_bss.f7639a;
        this.f6920h += (long) com_ushareit_listenit_bss.m9704b();
        this.f6914a.mo976a(com_ushareit_listenit_bss, com_ushareit_listenit_bss.m9704b());
        int i = d;
        while (true) {
            int a = bso.m9683a(bArr, d, c, this.f6917e);
            if (a == c) {
                break;
            }
            int i2 = com_ushareit_listenit_bss.f7639a[a + 3] & 255;
            if (!this.f6915c) {
                d = a - i;
                if (d > 0) {
                    this.f6918f.m8962a(bArr, i, a);
                }
                if (this.f6918f.m8963a(i2, d < 0 ? -d : 0)) {
                    Pair a2 = m8955a(this.f6918f);
                    this.f6914a.mo975a((Format) a2.first);
                    this.f6916d = ((Long) a2.second).longValue();
                    this.f6915c = true;
                }
            }
            if (this.f6915c && (i2 == 184 || i2 == 0)) {
                int i3 = c - a;
                if (this.f6919g) {
                    this.f6914a.mo974a(this.f6925m, this.f6923k ? 1 : 0, ((int) (this.f6920h - this.f6924l)) - i3, i3, null);
                    this.f6923k = false;
                }
                if (i2 == 184) {
                    this.f6919g = false;
                    this.f6923k = true;
                } else {
                    this.f6925m = this.f6922j ? this.f6921i : this.f6925m + this.f6916d;
                    this.f6924l = this.f6920h - ((long) i3);
                    this.f6922j = false;
                    this.f6919g = true;
                }
            }
            d = a + 3;
            i = a;
        }
        if (!this.f6915c) {
            this.f6918f.m8962a(bArr, i, c);
        }
    }

    public void mo1011b() {
    }

    private static Pair<Format, Long> m8955a(blt com_ushareit_listenit_blt) {
        Object copyOf = Arrays.copyOf(com_ushareit_listenit_blt.f6928c, com_ushareit_listenit_blt.f6926a);
        int i = copyOf[5] & 255;
        int i2 = i >> 4;
        i2 |= (copyOf[4] & 255) << 4;
        int i3 = ((i & 15) << 8) | (copyOf[6] & 255);
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = ((float) (i3 * 4)) / ((float) (i2 * 3));
                break;
            case 3:
                f = ((float) (i3 * 16)) / ((float) (i2 * 9));
                break;
            case 4:
                f = ((float) (i3 * 121)) / ((float) (i2 * 100));
                break;
        }
        Format a = Format.m2064a(null, "video/mpeg2", null, -1, -1, i2, i3, -1.0f, Collections.singletonList(copyOf), -1, f, null);
        long j = 0;
        int i4 = (copyOf[7] & 15) - 1;
        if (i4 >= 0 && i4 < f6913b.length) {
            double d = f6913b[i4];
            i4 = com_ushareit_listenit_blt.f6927b;
            int i5 = (copyOf[i4 + 9] & 96) >> 5;
            i4 = copyOf[i4 + 9] & 31;
            if (i5 != i4) {
                d *= (((double) i5) + 1.0d) / ((double) (i4 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a, Long.valueOf(j));
    }
}
