package com.ushareit.listenit;

public final class bst {
    private byte[] f7642a;
    private int f7643b;
    private int f7644c;
    private int f7645d;

    public bst(byte[] bArr, int i, int i2) {
        m9736a(bArr, i, i2);
    }

    public void m9736a(byte[] bArr, int i, int i2) {
        this.f7642a = bArr;
        this.f7644c = i;
        this.f7643b = i2;
        this.f7645d = 0;
        m9734f();
    }

    public void m9735a(int i) {
        int i2 = this.f7644c;
        this.f7644c += i / 8;
        this.f7645d += i % 8;
        if (this.f7645d > 7) {
            this.f7644c++;
            this.f7645d -= 8;
        }
        i2++;
        while (i2 <= this.f7644c) {
            if (m9732d(i2)) {
                this.f7644c++;
                i2 += 2;
            }
            i2++;
        }
        m9734f();
    }

    public boolean m9739b(int i) {
        int i2 = this.f7644c;
        int i3 = (i / 8) + this.f7644c;
        int i4 = this.f7645d + (i % 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        int i5 = i2 + 1;
        i2 = i3;
        i3 = i5;
        while (i3 <= i2 && i2 < this.f7643b) {
            if (m9732d(i3)) {
                i2++;
                i3 += 2;
            }
            i3++;
        }
        return i2 < this.f7643b || (i2 == this.f7643b && i4 == 0);
    }

    public boolean m9737a() {
        return m9741c(1) == 1;
    }

    public int m9741c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4;
            int i5 = i / 8;
            int i6 = 0;
            for (i3 = 0; i3 < i5; i3++) {
                i2 = m9732d(this.f7644c + 1) ? this.f7644c + 2 : this.f7644c + 1;
                if (this.f7645d != 0) {
                    i4 = ((this.f7642a[this.f7644c] & 255) << this.f7645d) | ((this.f7642a[i2] & 255) >>> (8 - this.f7645d));
                } else {
                    i4 = this.f7642a[this.f7644c];
                }
                i -= 8;
                i6 |= (i4 & 255) << i;
                this.f7644c = i2;
            }
            if (i > 0) {
                i3 = this.f7645d + i;
                byte b = (byte) (255 >> (8 - i));
                i4 = m9732d(this.f7644c + 1) ? this.f7644c + 2 : this.f7644c + 1;
                if (i3 > 8) {
                    i2 = ((((this.f7642a[this.f7644c] & 255) << (i3 - 8)) | ((this.f7642a[i4] & 255) >> (16 - i3))) & b) | i6;
                    this.f7644c = i4;
                } else {
                    i2 = (((this.f7642a[this.f7644c] & 255) >> (8 - i3)) & b) | i6;
                    if (i3 == 8) {
                        this.f7644c = i4;
                    }
                }
                this.f7645d = i3 % 8;
            } else {
                i2 = i6;
            }
            m9734f();
        }
        return i2;
    }

    public boolean m9738b() {
        boolean z;
        int i = this.f7644c;
        int i2 = this.f7645d;
        int i3 = 0;
        while (this.f7644c < this.f7643b && !m9737a()) {
            i3++;
        }
        if (this.f7644c == this.f7643b) {
            z = true;
        } else {
            z = false;
        }
        this.f7644c = i;
        this.f7645d = i2;
        if (z || !m9739b((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public int m9740c() {
        return m9733e();
    }

    public int m9742d() {
        int e = m9733e();
        return (e % 2 == 0 ? -1 : 1) * ((e + 1) / 2);
    }

    private int m9733e() {
        int i = 0;
        int i2 = 0;
        while (!m9737a()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m9741c(i2);
        }
        return i3 + i;
    }

    private boolean m9732d(int i) {
        return 2 <= i && i < this.f7643b && this.f7642a[i] == (byte) 3 && this.f7642a[i - 2] == (byte) 0 && this.f7642a[i - 1] == (byte) 0;
    }

    private void m9734f() {
        boolean z = this.f7644c >= 0 && this.f7645d >= 0 && this.f7645d < 8 && (this.f7644c < this.f7643b || (this.f7644c == this.f7643b && this.f7645d == 0));
        bsg.m9658b(z);
    }
}
