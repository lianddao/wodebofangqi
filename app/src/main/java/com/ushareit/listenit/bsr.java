package com.ushareit.listenit;

public final class bsr {
    public byte[] f7635a;
    private int f7636b;
    private int f7637c;
    private int f7638d;

    public bsr(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public bsr(byte[] bArr, int i) {
        this.f7635a = bArr;
        this.f7638d = i;
    }

    public int m9693a() {
        return (this.f7636b * 8) + this.f7637c;
    }

    public void m9694a(int i) {
        this.f7636b = i / 8;
        this.f7637c = i - (this.f7636b * 8);
        m9692c();
    }

    public void m9695b(int i) {
        this.f7636b += i / 8;
        this.f7637c += i % 8;
        if (this.f7637c > 7) {
            this.f7636b++;
            this.f7637c -= 8;
        }
        m9692c();
    }

    public boolean m9696b() {
        return m9697c(1) == 1;
    }

    public int m9697c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            int i4 = i / 8;
            int i5 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                if (this.f7637c != 0) {
                    i2 = ((this.f7635a[this.f7636b] & 255) << this.f7637c) | ((this.f7635a[this.f7636b + 1] & 255) >>> (8 - this.f7637c));
                } else {
                    i2 = this.f7635a[this.f7636b];
                }
                i -= 8;
                i5 |= (i2 & 255) << i;
                this.f7636b++;
            }
            if (i > 0) {
                i3 = this.f7637c + i;
                byte b = (byte) (255 >> (8 - i));
                if (i3 > 8) {
                    i2 = (b & (((this.f7635a[this.f7636b] & 255) << (i3 - 8)) | ((this.f7635a[this.f7636b + 1] & 255) >> (16 - i3)))) | i5;
                    this.f7636b++;
                } else {
                    i2 = (b & ((this.f7635a[this.f7636b] & 255) >> (8 - i3))) | i5;
                    if (i3 == 8) {
                        this.f7636b++;
                    }
                }
                this.f7637c = i3 % 8;
            } else {
                i2 = i5;
            }
            m9692c();
        }
        return i2;
    }

    private void m9692c() {
        boolean z = this.f7636b >= 0 && this.f7637c >= 0 && this.f7637c < 8 && (this.f7636b < this.f7638d || (this.f7636b == this.f7638d && this.f7637c == 0));
        bsg.m9658b(z);
    }
}
