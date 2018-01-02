package com.ushareit.listenit;

class btq implements Runnable {
    final /* synthetic */ int f7733a;
    final /* synthetic */ long f7734b;
    final /* synthetic */ btm f7735c;

    btq(btm com_ushareit_listenit_btm, int i, long j) {
        this.f7735c = com_ushareit_listenit_btm;
        this.f7733a = i;
        this.f7734b = j;
    }

    public void run() {
        this.f7735c.f7724b.mo912a(this.f7733a, this.f7734b);
    }
}
