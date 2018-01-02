package com.ushareit.listenit;

class bgn implements Runnable {
    final /* synthetic */ int f6190a;
    final /* synthetic */ long f6191b;
    final /* synthetic */ long f6192c;
    final /* synthetic */ bgj f6193d;

    bgn(bgj com_ushareit_listenit_bgj, int i, long j, long j2) {
        this.f6193d = com_ushareit_listenit_bgj;
        this.f6190a = i;
        this.f6191b = j;
        this.f6192c = j2;
    }

    public void run() {
        this.f6193d.f6181b.mo913a(this.f6190a, this.f6191b, this.f6192c);
    }
}
