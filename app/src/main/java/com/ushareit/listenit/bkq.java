package com.ushareit.listenit;

final class bkq {
    private final bkr f6795a = new bkr();
    private final bss f6796b = new bss(new byte[65025], 0);
    private int f6797c = -1;
    private int f6798d;
    private boolean f6799e;

    bkq() {
    }

    public void m8868a() {
        this.f6795a.m8871a();
        this.f6796b.m9699a();
        this.f6797c = -1;
        this.f6799e = false;
    }

    public boolean m8869a(bhz com_ushareit_listenit_bhz) {
        bsg.m9658b(com_ushareit_listenit_bhz != null);
        if (this.f6799e) {
            this.f6799e = false;
            this.f6796b.m9699a();
        }
        while (!this.f6799e) {
            int i;
            int i2;
            if (this.f6797c < 0) {
                if (!this.f6795a.m8872a(com_ushareit_listenit_bhz, true)) {
                    return false;
                }
                i = this.f6795a.f6808h;
                if ((this.f6795a.f6802b & 1) == 1 && this.f6796b.m9706c() == 0) {
                    i += m8867a(0);
                    i2 = this.f6798d + 0;
                } else {
                    i2 = 0;
                }
                com_ushareit_listenit_bhz.mo965b(i);
                this.f6797c = i2;
            }
            i = m8867a(this.f6797c);
            i2 = this.f6797c + this.f6798d;
            if (i > 0) {
                boolean z;
                com_ushareit_listenit_bhz.mo966b(this.f6796b.f7639a, this.f6796b.m9706c(), i);
                this.f6796b.m9705b(i + this.f6796b.m9706c());
                if (this.f6795a.f6810j[i2 - 1] != 255) {
                    z = true;
                } else {
                    z = false;
                }
                this.f6799e = z;
            }
            if (i2 == this.f6795a.f6807g) {
                i = -1;
            } else {
                i = i2;
            }
            this.f6797c = i;
        }
        return true;
    }

    public bss m8870b() {
        return this.f6796b;
    }

    private int m8867a(int i) {
        int i2 = 0;
        this.f6798d = 0;
        while (this.f6798d + i < this.f6795a.f6807g) {
            int[] iArr = this.f6795a.f6810j;
            int i3 = this.f6798d;
            this.f6798d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
