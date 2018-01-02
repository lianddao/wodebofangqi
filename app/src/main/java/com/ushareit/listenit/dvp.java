package com.ushareit.listenit;

class dvp implements Runnable {
    final /* synthetic */ dxb f10430a;
    final /* synthetic */ dvo f10431b;

    dvp(dvo com_ushareit_listenit_dvo, dxb com_ushareit_listenit_dxb) {
        this.f10431b = com_ushareit_listenit_dvo;
        this.f10430a = com_ushareit_listenit_dxb;
    }

    public void run() {
        synchronized (this.f10431b) {
            this.f10431b.f10428b = false;
            if (!this.f10431b.f10427a.m15800f()) {
                this.f10431b.f10427a.mo2096w().m16235E().m16263a("Connected to service");
                this.f10431b.f10427a.m15788a(this.f10430a);
            }
        }
    }
}
