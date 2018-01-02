package com.ushareit.listenit;

class bto implements Runnable {
    final /* synthetic */ String f7727a;
    final /* synthetic */ long f7728b;
    final /* synthetic */ long f7729c;
    final /* synthetic */ btm f7730d;

    bto(btm com_ushareit_listenit_btm, String str, long j, long j2) {
        this.f7730d = com_ushareit_listenit_btm;
        this.f7727a = str;
        this.f7728b = j;
        this.f7729c = j2;
    }

    public void run() {
        this.f7730d.f7724b.mo919a(this.f7727a, this.f7728b, this.f7729c);
    }
}
