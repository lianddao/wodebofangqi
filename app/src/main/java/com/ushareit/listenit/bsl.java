package com.ushareit.listenit;

import java.util.Arrays;

public final class bsl {
    private int f7616a;
    private long[] f7617b;

    public bsl() {
        this(32);
    }

    public bsl(int i) {
        this.f7617b = new long[i];
    }

    public void m9675a(long j) {
        if (this.f7616a == this.f7617b.length) {
            this.f7617b = Arrays.copyOf(this.f7617b, this.f7616a * 2);
        }
        long[] jArr = this.f7617b;
        int i = this.f7616a;
        this.f7616a = i + 1;
        jArr[i] = j;
    }

    public long m9674a(int i) {
        if (i >= 0 && i < this.f7616a) {
            return this.f7617b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f7616a);
    }

    public int m9673a() {
        return this.f7616a;
    }

    public long[] m9676b() {
        return Arrays.copyOf(this.f7617b, this.f7616a);
    }
}
