package com.ushareit.listenit;

class bgl implements Runnable {
    final /* synthetic */ String f6184a;
    final /* synthetic */ long f6185b;
    final /* synthetic */ long f6186c;
    final /* synthetic */ bgj f6187d;

    bgl(bgj com_ushareit_listenit_bgj, String str, long j, long j2) {
        this.f6187d = com_ushareit_listenit_bgj;
        this.f6184a = str;
        this.f6185b = j;
        this.f6186c = j2;
    }

    public void run() {
        this.f6187d.f6181b.mo922b(this.f6184a, this.f6185b, this.f6186c);
    }
}
