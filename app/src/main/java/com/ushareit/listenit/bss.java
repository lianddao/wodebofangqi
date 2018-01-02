package com.ushareit.listenit;

import com.umeng.analytics.pro.dm;
import java.nio.charset.Charset;

public final class bss {
    public byte[] f7639a;
    private int f7640b;
    private int f7641c;

    public bss(int i) {
        this.f7639a = new byte[i];
        this.f7641c = i;
    }

    public bss(byte[] bArr) {
        this.f7639a = bArr;
        this.f7641c = bArr.length;
    }

    public bss(byte[] bArr, int i) {
        this.f7639a = bArr;
        this.f7641c = i;
    }

    public void m9700a(int i) {
        m9702a(m9710e() < i ? new byte[i] : this.f7639a, i);
    }

    public void m9702a(byte[] bArr, int i) {
        this.f7639a = bArr;
        this.f7641c = i;
        this.f7640b = 0;
    }

    public void m9699a() {
        this.f7640b = 0;
        this.f7641c = 0;
    }

    public int m9704b() {
        return this.f7641c - this.f7640b;
    }

    public int m9706c() {
        return this.f7641c;
    }

    public void m9705b(int i) {
        boolean z = i >= 0 && i <= this.f7639a.length;
        bsg.m9656a(z);
        this.f7641c = i;
    }

    public int m9708d() {
        return this.f7640b;
    }

    public int m9710e() {
        return this.f7639a == null ? 0 : this.f7639a.length;
    }

    public void m9707c(int i) {
        boolean z = i >= 0 && i <= this.f7641c;
        bsg.m9656a(z);
        this.f7640b = i;
    }

    public void m9709d(int i) {
        m9707c(this.f7640b + i);
    }

    public void m9701a(bsr com_ushareit_listenit_bsr, int i) {
        m9703a(com_ushareit_listenit_bsr.f7635a, 0, i);
        com_ushareit_listenit_bsr.m9694a(0);
    }

    public void m9703a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f7639a, this.f7640b, bArr, i, i2);
        this.f7640b += i2;
    }

    public int m9712f() {
        return this.f7639a[this.f7640b] & 255;
    }

    public int m9713g() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        return bArr[i] & 255;
    }

    public int m9714h() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int m9715i() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public short m9716j() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & 255));
    }

    public int m9717k() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7639a;
        i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public long m9718l() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f7639a;
        int i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m9719m() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f7639a;
        int i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public int m9720n() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f7639a;
        i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7639a;
        i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int m9721o() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f7639a;
        i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f7639a;
        i3 = this.f7640b;
        this.f7640b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public long m9722p() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f7639a;
        int i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public long m9723q() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f7639a;
        int i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f7639a;
        i2 = this.f7640b;
        this.f7640b = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    public int m9724r() {
        byte[] bArr = this.f7639a;
        int i = this.f7640b;
        this.f7640b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f7639a;
        int i3 = this.f7640b;
        this.f7640b = i3 + 1;
        i2 |= bArr2[i3] & 255;
        this.f7640b += 2;
        return i2;
    }

    public int m9725s() {
        return (((m9713g() << 21) | (m9713g() << 14)) | (m9713g() << 7)) | m9713g();
    }

    public int m9726t() {
        int n = m9720n();
        if (n >= 0) {
            return n;
        }
        throw new IllegalStateException("Top bit not zero: " + n);
    }

    public int m9727u() {
        int o = m9721o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public long m9728v() {
        long p = m9722p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public double m9729w() {
        return Double.longBitsToDouble(m9722p());
    }

    public String m9711e(int i) {
        return m9698a(i, Charset.defaultCharset());
    }

    public String m9698a(int i, Charset charset) {
        String str = new String(this.f7639a, this.f7640b, i, charset);
        this.f7640b += i;
        return str;
    }

    public String m9730x() {
        if (m9704b() == 0) {
            return null;
        }
        int i = this.f7640b;
        while (i < this.f7641c && this.f7639a[i] != (byte) 10 && this.f7639a[i] != dm.f3661k) {
            i++;
        }
        if (i - this.f7640b >= 3 && this.f7639a[this.f7640b] == (byte) -17 && this.f7639a[this.f7640b + 1] == (byte) -69 && this.f7639a[this.f7640b + 2] == (byte) -65) {
            this.f7640b += 3;
        }
        String str = new String(this.f7639a, this.f7640b, i - this.f7640b);
        this.f7640b = i;
        if (this.f7640b == this.f7641c) {
            return str;
        }
        if (this.f7639a[this.f7640b] == dm.f3661k) {
            this.f7640b++;
            if (this.f7640b == this.f7641c) {
                return str;
            }
        }
        if (this.f7639a[this.f7640b] == (byte) 10) {
            this.f7640b++;
        }
        return str;
    }

    public long m9731y() {
        int i = 1;
        int i2 = 0;
        long j = (long) this.f7639a[this.f7640b];
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b;
            if ((((long) (1 << i3)) & j) == 0) {
                if (i3 < 6) {
                    j &= (long) ((1 << i3) - 1);
                    i2 = 7 - i3;
                } else if (i3 == 7) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
                }
                while (i < i2) {
                    b = this.f7639a[this.f7640b + i];
                    if ((b & 192) == 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                    }
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                }
                this.f7640b += i2;
                return j;
            }
        }
        if (i2 != 0) {
            while (i < i2) {
                b = this.f7639a[this.f7640b + i];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.f7640b += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }
}
