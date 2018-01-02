package com.ushareit.listenit;

class crn implements Runnable {
    final /* synthetic */ crp f8802a;
    final /* synthetic */ ecb f8803b;
    final /* synthetic */ crm f8804c;

    crn(crm com_ushareit_listenit_crm, crp com_ushareit_listenit_crp, ecb com_ushareit_listenit_ecb) {
        this.f8804c = com_ushareit_listenit_crm;
        this.f8802a = com_ushareit_listenit_crp;
        this.f8803b = com_ushareit_listenit_ecb;
    }

    public void run() {
        this.f8802a.f8807b.m16752a(null, true, this.f8803b);
    }
}
