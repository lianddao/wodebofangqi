package com.ushareit.listenit;

class brn implements Runnable {
    final /* synthetic */ int f7528a;
    final /* synthetic */ long f7529b;
    final /* synthetic */ long f7530c;
    final /* synthetic */ brm f7531d;

    brn(brm com_ushareit_listenit_brm, int i, long j, long j2) {
        this.f7531d = com_ushareit_listenit_brm;
        this.f7528a = i;
        this.f7529b = j;
        this.f7530c = j2;
    }

    public void run() {
        this.f7531d.f7520b.m9578a(this.f7528a, this.f7529b, this.f7530c);
    }
}
