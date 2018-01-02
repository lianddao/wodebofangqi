package com.ushareit.listenit;

public final class bhp implements bif {
    public final int f6341a;
    public final int[] f6342b;
    public final long[] f6343c;
    public final long[] f6344d;
    public final long[] f6345e;
    private final long f6346f;

    public bhp(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f6342b = iArr;
        this.f6343c = jArr;
        this.f6344d = jArr2;
        this.f6345e = jArr3;
        this.f6341a = iArr.length;
        this.f6346f = jArr2[this.f6341a - 1] + jArr3[this.f6341a - 1];
    }

    public int m8436a(long j) {
        return btc.m9762a(this.f6345e, j, true, true);
    }

    public boolean mo957a() {
        return true;
    }

    public long mo958b() {
        return this.f6346f;
    }

    public long mo959b(long j) {
        return this.f6343c[m8436a(j)];
    }
}
