package com.ushareit.listenit;

public class bqa extends bqc {
    private final brd f7393d;
    private final int f7394e;
    private final long f7395f;
    private final long f7396g;
    private final long f7397h;
    private final float f7398i;
    private int f7399j = m9497a(Long.MIN_VALUE);
    private int f7400k = 1;

    public bqa(boj com_ushareit_listenit_boj, int[] iArr, brd com_ushareit_listenit_brd, int i, long j, long j2, long j3, float f) {
        super(com_ushareit_listenit_boj, iArr);
        this.f7393d = com_ushareit_listenit_brd;
        this.f7394e = i;
        this.f7395f = j * 1000;
        this.f7396g = j2 * 1000;
        this.f7397h = j3 * 1000;
        this.f7398i = f;
    }

    private int m9497a(long j) {
        int i = 0;
        long a = this.f7393d.mo1095a();
        a = a == -1 ? (long) this.f7394e : (long) (((float) a) * this.f7398i);
        int i2 = 0;
        while (i < this.b) {
            if (j == Long.MIN_VALUE || !m9494a(i, j)) {
                if (((long) mo1078a(i).f1428b) <= a) {
                    return i;
                }
                i2 = i;
            }
            i++;
        }
        return i2;
    }
}
