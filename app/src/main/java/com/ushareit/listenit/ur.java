package com.ushareit.listenit;

import com.umeng.analytics.pro.C0277j;
import java.io.OutputStream;

class ur {
    int f16964a;
    int f16965b = 12;
    int f16966c;
    int f16967d = 4096;
    int[] f16968e = new int[5003];
    int[] f16969f = new int[5003];
    int f16970g = 5003;
    int f16971h = 0;
    boolean f16972i = false;
    int f16973j;
    int f16974k;
    int f16975l;
    int f16976m = 0;
    int f16977n = 0;
    int[] f16978o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    int f16979p;
    byte[] f16980q = new byte[C0277j.f3694e];
    private int f16981r;
    private int f16982s;
    private byte[] f16983t;
    private int f16984u;
    private int f16985v;
    private int f16986w;

    ur(int i, int i2, byte[] bArr, int i3) {
        this.f16981r = i;
        this.f16982s = i2;
        this.f16983t = bArr;
        this.f16984u = Math.max(2, i3);
    }

    void m26600a(byte b, OutputStream outputStream) {
        byte[] bArr = this.f16980q;
        int i = this.f16979p;
        this.f16979p = i + 1;
        bArr[i] = b;
        if (this.f16979p >= 254) {
            m26607c(outputStream);
        }
    }

    void m26603a(OutputStream outputStream) {
        m26601a(this.f16970g);
        this.f16971h = this.f16974k + 2;
        this.f16972i = true;
        m26605b(this.f16974k, outputStream);
    }

    void m26601a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f16968e[i2] = -1;
        }
    }

    void m26602a(int i, OutputStream outputStream) {
        int i2;
        int i3 = 0;
        this.f16973j = i;
        this.f16972i = false;
        this.f16964a = this.f16973j;
        this.f16966c = m26604b(this.f16964a);
        this.f16974k = 1 << (i - 1);
        this.f16975l = this.f16974k + 1;
        this.f16971h = this.f16974k + 2;
        this.f16979p = 0;
        int a = m26599a();
        for (i2 = this.f16970g; i2 < 65536; i2 *= 2) {
            i3++;
        }
        int i4 = 8 - i3;
        int i5 = this.f16970g;
        m26601a(i5);
        m26605b(this.f16974k, outputStream);
        while (true) {
            i3 = m26599a();
            if (i3 != -1) {
                int i6 = (i3 << this.f16965b) + a;
                i2 = (i3 << i4) ^ a;
                if (this.f16968e[i2] == i6) {
                    a = this.f16969f[i2];
                } else if (this.f16968e[i2] >= 0) {
                    r3 = i5 - i2;
                    if (i2 == 0) {
                        r3 = 1;
                    }
                    do {
                        i2 -= r3;
                        if (i2 < 0) {
                            i2 += i5;
                        }
                        if (this.f16968e[i2] == i6) {
                            a = this.f16969f[i2];
                            break;
                        }
                    } while (this.f16968e[i2] >= 0);
                    m26605b(a, outputStream);
                    if (this.f16971h >= this.f16967d) {
                        r0 = this.f16969f;
                        r3 = this.f16971h;
                        this.f16971h = r3 + 1;
                        r0[i2] = r3;
                        this.f16968e[i2] = i6;
                        a = i3;
                    } else {
                        m26603a(outputStream);
                        a = i3;
                    }
                } else {
                    m26605b(a, outputStream);
                    if (this.f16971h >= this.f16967d) {
                        m26603a(outputStream);
                        a = i3;
                    } else {
                        r0 = this.f16969f;
                        r3 = this.f16971h;
                        this.f16971h = r3 + 1;
                        r0[i2] = r3;
                        this.f16968e[i2] = i6;
                        a = i3;
                    }
                }
            } else {
                m26605b(a, outputStream);
                m26605b(this.f16975l, outputStream);
                return;
            }
        }
    }

    void m26606b(OutputStream outputStream) {
        outputStream.write(this.f16984u);
        this.f16985v = this.f16981r * this.f16982s;
        this.f16986w = 0;
        m26602a(this.f16984u + 1, outputStream);
        outputStream.write(0);
    }

    void m26607c(OutputStream outputStream) {
        if (this.f16979p > 0) {
            outputStream.write(this.f16979p);
            outputStream.write(this.f16980q, 0, this.f16979p);
            this.f16979p = 0;
        }
    }

    final int m26604b(int i) {
        return (1 << i) - 1;
    }

    private int m26599a() {
        if (this.f16985v == 0) {
            return -1;
        }
        this.f16985v--;
        byte[] bArr = this.f16983t;
        int i = this.f16986w;
        this.f16986w = i + 1;
        return bArr[i] & 255;
    }

    void m26605b(int i, OutputStream outputStream) {
        this.f16976m &= this.f16978o[this.f16977n];
        if (this.f16977n > 0) {
            this.f16976m |= i << this.f16977n;
        } else {
            this.f16976m = i;
        }
        this.f16977n += this.f16964a;
        while (this.f16977n >= 8) {
            m26600a((byte) (this.f16976m & 255), outputStream);
            this.f16976m >>= 8;
            this.f16977n -= 8;
        }
        if (this.f16971h > this.f16966c || this.f16972i) {
            if (this.f16972i) {
                int i2 = this.f16973j;
                this.f16964a = i2;
                this.f16966c = m26604b(i2);
                this.f16972i = false;
            } else {
                this.f16964a++;
                if (this.f16964a == this.f16965b) {
                    this.f16966c = this.f16967d;
                } else {
                    this.f16966c = m26604b(this.f16964a);
                }
            }
        }
        if (i == this.f16975l) {
            while (this.f16977n > 0) {
                m26600a((byte) (this.f16976m & 255), outputStream);
                this.f16976m >>= 8;
                this.f16977n -= 8;
            }
            m26607c(outputStream);
        }
    }
}
