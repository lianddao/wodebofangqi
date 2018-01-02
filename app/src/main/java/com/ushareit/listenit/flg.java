package com.ushareit.listenit;

class flg {
    final /* synthetic */ fle f12910a;
    private int f12911b = 0;

    public flg(fle com_ushareit_listenit_fle) {
        this.f12910a = com_ushareit_listenit_fle;
    }

    public void m19759a(int i, boolean z) {
        int i2 = (this.f12911b >> i) & 1;
        if (z) {
            this.f12911b = i2 == 0 ? this.f12911b | (1 << i) : this.f12911b;
        } else {
            this.f12911b = i2 == 1 ? this.f12911b & ((1 << i) ^ -1) : this.f12911b;
        }
    }

    public void m19757a() {
        this.f12911b = 0;
    }

    public int m19760b() {
        return this.f12911b;
    }

    public void m19758a(int i) {
        this.f12911b = i;
    }

    public boolean m19761b(int i) {
        if (((this.f12911b >> i) & 1) == 1) {
            return true;
        }
        return false;
    }
}
