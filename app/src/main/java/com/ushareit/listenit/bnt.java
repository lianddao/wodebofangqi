package com.ushareit.listenit;

class bnt implements Runnable {
    final /* synthetic */ bnw f7185a;
    final /* synthetic */ bnq f7186b;

    bnt(bnq com_ushareit_listenit_bnq, bnw com_ushareit_listenit_bnw) {
        this.f7186b = com_ushareit_listenit_bnq;
        this.f7185a = com_ushareit_listenit_bnw;
    }

    public void run() {
        this.f7185a.m9208a();
        int size = this.f7186b.f7170n.size();
        for (int i = 0; i < size; i++) {
            ((bhs) this.f7186b.f7170n.valueAt(i)).m8496b();
        }
    }
}
