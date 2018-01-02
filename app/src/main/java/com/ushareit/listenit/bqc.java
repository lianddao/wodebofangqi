package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;
import java.util.Arrays;

public abstract class bqc implements bql {
    protected final boj f7387a;
    protected final int f7388b;
    protected final int[] f7389c;
    private final Format[] f7390d;
    private final long[] f7391e;
    private int f7392f;

    public bqc(boj com_ushareit_listenit_boj, int... iArr) {
        int i = 0;
        bsg.m9658b(iArr.length > 0);
        this.f7387a = (boj) bsg.m9654a((Object) com_ushareit_listenit_boj);
        this.f7388b = iArr.length;
        this.f7390d = new Format[this.f7388b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f7390d[i2] = com_ushareit_listenit_boj.m9237a(iArr[i2]);
        }
        Arrays.sort(this.f7390d, new bqe());
        this.f7389c = new int[this.f7388b];
        while (i < this.f7388b) {
            this.f7389c[i] = com_ushareit_listenit_boj.m9236a(this.f7390d[i]);
            i++;
        }
        this.f7391e = new long[this.f7388b];
    }

    public final boj mo1079a() {
        return this.f7387a;
    }

    public final int mo1080b() {
        return this.f7389c.length;
    }

    public final Format mo1078a(int i) {
        return this.f7390d[i];
    }

    public final int mo1081b(int i) {
        return this.f7389c[i];
    }

    protected final boolean m9494a(int i, long j) {
        return this.f7391e[i] > j;
    }

    public int hashCode() {
        if (this.f7392f == 0) {
            this.f7392f = (System.identityHashCode(this.f7387a) * 31) + Arrays.hashCode(this.f7389c);
        }
        return this.f7392f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bqc com_ushareit_listenit_bqc = (bqc) obj;
        if (this.f7387a == com_ushareit_listenit_bqc.f7387a && Arrays.equals(this.f7389c, com_ushareit_listenit_bqc.f7389c)) {
            return true;
        }
        return false;
    }
}
