package com.ushareit.listenit;

class btr implements Runnable {
    final /* synthetic */ int f7736a;
    final /* synthetic */ int f7737b;
    final /* synthetic */ int f7738c;
    final /* synthetic */ float f7739d;
    final /* synthetic */ btm f7740e;

    btr(btm com_ushareit_listenit_btm, int i, int i2, int i3, float f) {
        this.f7740e = com_ushareit_listenit_btm;
        this.f7736a = i;
        this.f7737b = i2;
        this.f7738c = i3;
        this.f7739d = f;
    }

    public void run() {
        this.f7740e.f7724b.mo911a(this.f7736a, this.f7737b, this.f7738c, this.f7739d);
    }
}
