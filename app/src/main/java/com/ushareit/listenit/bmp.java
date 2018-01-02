package com.ushareit.listenit;

final class bmp {
    private final int f7099a;
    private final int f7100b;
    private final int f7101c;
    private final int f7102d;
    private final int f7103e;
    private final int f7104f;
    private long f7105g;
    private long f7106h;

    public bmp(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f7099a = i;
        this.f7100b = i2;
        this.f7101c = i3;
        this.f7102d = i4;
        this.f7103e = i5;
        this.f7104f = i6;
    }

    public long m9072a() {
        return ((this.f7106h / ((long) this.f7102d)) * 1000000) / ((long) this.f7100b);
    }

    public int m9075b() {
        return this.f7102d;
    }

    public int m9077c() {
        return (this.f7100b * this.f7103e) * this.f7099a;
    }

    public int m9078d() {
        return this.f7100b;
    }

    public int m9079e() {
        return this.f7099a;
    }

    public long m9073a(long j) {
        return Math.min((((((long) this.f7101c) * j) / 1000000) / ((long) this.f7102d)) * ((long) this.f7102d), this.f7106h - ((long) this.f7102d)) + this.f7105g;
    }

    public long m9076b(long j) {
        return (1000000 * j) / ((long) this.f7101c);
    }

    public boolean m9080f() {
        return (this.f7105g == 0 || this.f7106h == 0) ? false : true;
    }

    public void m9074a(long j, long j2) {
        this.f7105g = j;
        this.f7106h = j2;
    }

    public int m9081g() {
        return this.f7104f;
    }
}
