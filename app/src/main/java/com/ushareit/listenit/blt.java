package com.ushareit.listenit;

import java.util.Arrays;

final class blt {
    public int f6926a;
    public int f6927b;
    public byte[] f6928c;
    private boolean f6929d;

    public blt(int i) {
        this.f6928c = new byte[i];
    }

    public void m8961a() {
        this.f6929d = false;
        this.f6926a = 0;
        this.f6927b = 0;
    }

    public boolean m8963a(int i, int i2) {
        if (this.f6929d) {
            if (this.f6927b == 0 && i == 181) {
                this.f6927b = this.f6926a;
            } else {
                this.f6926a -= i2;
                this.f6929d = false;
                return true;
            }
        } else if (i == 179) {
            this.f6929d = true;
        }
        return false;
    }

    public void m8962a(byte[] bArr, int i, int i2) {
        if (this.f6929d) {
            int i3 = i2 - i;
            if (this.f6928c.length < this.f6926a + i3) {
                this.f6928c = Arrays.copyOf(this.f6928c, (this.f6926a + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f6928c, this.f6926a, i3);
            this.f6926a = i3 + this.f6926a;
        }
    }
}
