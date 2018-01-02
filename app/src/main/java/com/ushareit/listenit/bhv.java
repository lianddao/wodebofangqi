package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

final class bhv {
    private int f6375a = 1000;
    private int[] f6376b = new int[this.f6375a];
    private long[] f6377c = new long[this.f6375a];
    private int[] f6378d = new int[this.f6375a];
    private int[] f6379e = new int[this.f6375a];
    private long[] f6380f = new long[this.f6375a];
    private byte[][] f6381g = new byte[this.f6375a][];
    private Format[] f6382h = new Format[this.f6375a];
    private int f6383i;
    private int f6384j;
    private int f6385k;
    private int f6386l;
    private long f6387m = Long.MIN_VALUE;
    private long f6388n = Long.MIN_VALUE;
    private boolean f6389o = true;
    private Format f6390p;
    private int f6391q;

    public void m8503a() {
        this.f6384j = 0;
        this.f6385k = 0;
        this.f6386l = 0;
        this.f6383i = 0;
    }

    public void m8506b() {
        this.f6387m = Long.MIN_VALUE;
        this.f6388n = Long.MIN_VALUE;
    }

    public int m8508c() {
        return this.f6384j + this.f6383i;
    }

    public long m8501a(int i) {
        int c = m8508c() - i;
        boolean z = c >= 0 && c <= this.f6383i;
        bsg.m9656a(z);
        int i2;
        if (c != 0) {
            this.f6383i -= c;
            this.f6386l = ((this.f6386l + this.f6375a) - c) % this.f6375a;
            this.f6388n = Long.MIN_VALUE;
            for (i2 = this.f6383i - 1; i2 >= 0; i2--) {
                c = (this.f6385k + i2) % this.f6375a;
                this.f6388n = Math.max(this.f6388n, this.f6380f[c]);
                if ((this.f6379e[c] & 1) != 0) {
                    break;
                }
            }
            return this.f6377c[this.f6386l];
        } else if (this.f6384j == 0) {
            return 0;
        } else {
            i2 = (this.f6386l == 0 ? this.f6375a : this.f6386l) - 1;
            return ((long) this.f6378d[i2]) + this.f6377c[i2];
        }
    }

    public synchronized boolean m8510d() {
        return this.f6383i == 0;
    }

    public synchronized Format m8511e() {
        return this.f6389o ? null : this.f6390p;
    }

    public synchronized long m8512f() {
        return Math.max(this.f6387m, this.f6388n);
    }

    public synchronized int m8500a(bfu com_ushareit_listenit_bfu, bhf com_ushareit_listenit_bhf, Format format, bhu com_ushareit_listenit_bhu) {
        int i = -5;
        synchronized (this) {
            if (this.f6383i == 0) {
                if (this.f6390p == null || this.f6390p == format) {
                    i = -3;
                } else {
                    com_ushareit_listenit_bfu.f6128a = this.f6390p;
                }
            } else if (this.f6382h[this.f6385k] != format) {
                com_ushareit_listenit_bfu.f6128a = this.f6382h[this.f6385k];
            } else {
                com_ushareit_listenit_bhf.f6322c = this.f6380f[this.f6385k];
                com_ushareit_listenit_bhf.a_(this.f6379e[this.f6385k]);
                com_ushareit_listenit_bhu.f6371a = this.f6378d[this.f6385k];
                com_ushareit_listenit_bhu.f6372b = this.f6377c[this.f6385k];
                com_ushareit_listenit_bhu.f6374d = this.f6381g[this.f6385k];
                this.f6387m = Math.max(this.f6387m, com_ushareit_listenit_bhf.f6322c);
                this.f6383i--;
                this.f6385k++;
                this.f6384j++;
                if (this.f6385k == this.f6375a) {
                    this.f6385k = 0;
                }
                com_ushareit_listenit_bhu.f6373c = this.f6383i > 0 ? this.f6377c[this.f6385k] : com_ushareit_listenit_bhu.f6372b + ((long) com_ushareit_listenit_bhu.f6371a);
                i = -4;
            }
        }
        return i;
    }

    public synchronized long m8502a(long j) {
        long j2 = -1;
        synchronized (this) {
            if (this.f6383i != 0 && j >= this.f6380f[this.f6385k]) {
                if (j <= this.f6380f[(this.f6386l == 0 ? this.f6375a : this.f6386l) - 1]) {
                    int i = 0;
                    int i2 = this.f6385k;
                    int i3 = -1;
                    while (i2 != this.f6386l && this.f6380f[i2] <= j) {
                        if ((this.f6379e[i2] & 1) != 0) {
                            i3 = i;
                        }
                        i2 = (i2 + 1) % this.f6375a;
                        i++;
                    }
                    if (i3 != -1) {
                        this.f6383i -= i3;
                        this.f6385k = (this.f6385k + i3) % this.f6375a;
                        this.f6384j += i3;
                        j2 = this.f6377c[this.f6385k];
                    }
                }
            }
        }
        return j2;
    }

    public synchronized boolean m8505a(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.f6389o = true;
            } else {
                this.f6389o = false;
                if (!btc.m9770a((Object) format, this.f6390p)) {
                    this.f6390p = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void m8504a(long j, int i, long j2, int i2, byte[] bArr) {
        bsg.m9658b(!this.f6389o);
        m8507b(j);
        this.f6380f[this.f6386l] = j;
        this.f6377c[this.f6386l] = j2;
        this.f6378d[this.f6386l] = i2;
        this.f6379e[this.f6386l] = i;
        this.f6381g[this.f6386l] = bArr;
        this.f6382h[this.f6386l] = this.f6390p;
        this.f6376b[this.f6386l] = this.f6391q;
        this.f6383i++;
        if (this.f6383i == this.f6375a) {
            int i3 = this.f6375a + 1000;
            Object obj = new int[i3];
            Object obj2 = new long[i3];
            Object obj3 = new long[i3];
            Object obj4 = new int[i3];
            Object obj5 = new int[i3];
            Object obj6 = new byte[i3][];
            Object obj7 = new Format[i3];
            int i4 = this.f6375a - this.f6385k;
            System.arraycopy(this.f6377c, this.f6385k, obj2, 0, i4);
            System.arraycopy(this.f6380f, this.f6385k, obj3, 0, i4);
            System.arraycopy(this.f6379e, this.f6385k, obj4, 0, i4);
            System.arraycopy(this.f6378d, this.f6385k, obj5, 0, i4);
            System.arraycopy(this.f6381g, this.f6385k, obj6, 0, i4);
            System.arraycopy(this.f6382h, this.f6385k, obj7, 0, i4);
            System.arraycopy(this.f6376b, this.f6385k, obj, 0, i4);
            int i5 = this.f6385k;
            System.arraycopy(this.f6377c, 0, obj2, i4, i5);
            System.arraycopy(this.f6380f, 0, obj3, i4, i5);
            System.arraycopy(this.f6379e, 0, obj4, i4, i5);
            System.arraycopy(this.f6378d, 0, obj5, i4, i5);
            System.arraycopy(this.f6381g, 0, obj6, i4, i5);
            System.arraycopy(this.f6382h, 0, obj7, i4, i5);
            System.arraycopy(this.f6376b, 0, obj, i4, i5);
            this.f6377c = obj2;
            this.f6380f = obj3;
            this.f6379e = obj4;
            this.f6378d = obj5;
            this.f6381g = obj6;
            this.f6382h = obj7;
            this.f6376b = obj;
            this.f6385k = 0;
            this.f6386l = this.f6375a;
            this.f6383i = this.f6375a;
            this.f6375a = i3;
        } else {
            this.f6386l++;
            if (this.f6386l == this.f6375a) {
                this.f6386l = 0;
            }
        }
    }

    public synchronized void m8507b(long j) {
        this.f6388n = Math.max(this.f6388n, j);
    }

    public synchronized boolean m8509c(long j) {
        boolean z;
        if (this.f6387m >= j) {
            z = false;
        } else {
            int i = this.f6383i;
            while (i > 0 && this.f6380f[((this.f6385k + i) - 1) % this.f6375a] >= j) {
                i--;
            }
            m8501a(i + this.f6384j);
            z = true;
        }
        return z;
    }
}
