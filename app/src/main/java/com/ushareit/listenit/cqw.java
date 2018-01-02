package com.ushareit.listenit;

class cqw implements Runnable {
    final /* synthetic */ crp f8756a;
    final /* synthetic */ ece f8757b;
    final /* synthetic */ ecb f8758c;
    final /* synthetic */ cqt f8759d;

    cqw(cqt com_ushareit_listenit_cqt, crp com_ushareit_listenit_crp, ece com_ushareit_listenit_ece, ecb com_ushareit_listenit_ecb) {
        this.f8759d = com_ushareit_listenit_cqt;
        this.f8756a = com_ushareit_listenit_crp;
        this.f8757b = com_ushareit_listenit_ece;
        this.f8758c = com_ushareit_listenit_ecb;
    }

    public void run() {
        this.f8756a.f8807b.m16752a(this.f8757b, false, this.f8758c);
    }
}
