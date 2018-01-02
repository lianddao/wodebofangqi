package com.ushareit.listenit;

import java.util.Arrays;

final class bmc {
    public byte[] f7031a;
    public int f7032b;
    private final int f7033c;
    private boolean f7034d;
    private boolean f7035e;

    public bmc(int i, int i2) {
        this.f7033c = i;
        this.f7031a = new byte[(i2 + 3)];
        this.f7031a[2] = (byte) 1;
    }

    public void m9015a() {
        this.f7034d = false;
        this.f7035e = false;
    }

    public boolean m9018b() {
        return this.f7035e;
    }

    public void m9016a(int i) {
        boolean z = true;
        bsg.m9658b(!this.f7034d);
        if (i != this.f7033c) {
            z = false;
        }
        this.f7034d = z;
        if (this.f7034d) {
            this.f7032b = 3;
            this.f7035e = false;
        }
    }

    public void m9017a(byte[] bArr, int i, int i2) {
        if (this.f7034d) {
            int i3 = i2 - i;
            if (this.f7031a.length < this.f7032b + i3) {
                this.f7031a = Arrays.copyOf(this.f7031a, (this.f7032b + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f7031a, this.f7032b, i3);
            this.f7032b = i3 + this.f7032b;
        }
    }

    public boolean m9019b(int i) {
        if (!this.f7034d) {
            return false;
        }
        this.f7032b -= i;
        this.f7034d = false;
        this.f7035e = true;
        return true;
    }
}
