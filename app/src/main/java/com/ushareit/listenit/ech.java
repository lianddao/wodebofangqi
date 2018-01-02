package com.ushareit.listenit;

class ech implements Runnable {
    final /* synthetic */ cxa f10824a;
    final /* synthetic */ cyp f10825b;
    final /* synthetic */ ecg f10826c;

    ech(ecg com_ushareit_listenit_ecg, cxa com_ushareit_listenit_cxa, cyp com_ushareit_listenit_cyp) {
        this.f10826c = com_ushareit_listenit_ecg;
        this.f10824a = com_ushareit_listenit_cxa;
        this.f10825b = com_ushareit_listenit_cyp;
    }

    public void run() {
        this.f10826c.a.m12393a(this.f10826c.m16729c(), this.f10824a, (ecj) this.f10825b.m13381b());
    }
}
