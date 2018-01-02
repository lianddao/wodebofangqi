package com.ushareit.listenit;

final class bky {
    public final byte[] f6817a;
    private int f6818b;
    private int f6819c;
    private int f6820d;

    public bky(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public bky(byte[] bArr, int i) {
        this.f6817a = bArr;
        this.f6818b = i * 8;
    }

    public boolean m8882a() {
        return m8881a(1) == 1;
    }

    public int m8881a(int i) {
        bsg.m9658b(m8883b() + i <= this.f6818b);
        if (i == 0) {
            return 0;
        }
        long min;
        int i2;
        int i3;
        int i4;
        if (this.f6820d != 0) {
            min = Math.min(i, 8 - this.f6820d);
            i2 = (255 >>> (8 - min)) & (this.f6817a[this.f6819c] >>> this.f6820d);
            this.f6820d += min;
            if (this.f6820d == 8) {
                this.f6819c++;
                this.f6820d = 0;
            }
        } else {
            min = 0;
            i2 = 0;
        }
        if (i - min > 7) {
            int i5 = (i - min) / 8;
            i3 = i2;
            i2 = 0;
            while (i2 < i5) {
                long j = (long) i3;
                byte[] bArr = this.f6817a;
                int i6 = this.f6819c;
                this.f6819c = i6 + 1;
                min += 8;
                i2++;
                i3 = (int) (j | ((((long) bArr[i6]) & 255) << min));
            }
            int i7 = min;
            i4 = i3;
            i3 = i7;
        } else {
            i3 = min;
            i4 = i2;
        }
        if (i > i3) {
            i2 = i - i3;
            i4 |= ((255 >>> (8 - i2)) & this.f6817a[this.f6819c]) << i3;
            this.f6820d += i2;
        }
        return i4;
    }

    public void m8884b(int i) {
        bsg.m9658b(m8883b() + i <= this.f6818b);
        this.f6819c += i / 8;
        this.f6820d += i % 8;
        if (this.f6820d > 7) {
            this.f6819c++;
            this.f6820d -= 8;
        }
    }

    public int m8883b() {
        return (this.f6819c * 8) + this.f6820d;
    }
}
