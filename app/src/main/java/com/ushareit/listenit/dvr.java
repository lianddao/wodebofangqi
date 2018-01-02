package com.ushareit.listenit;

class dvr implements Runnable {
    final /* synthetic */ dxb f10434a;
    final /* synthetic */ dvo f10435b;

    dvr(dvo com_ushareit_listenit_dvo, dxb com_ushareit_listenit_dxb) {
        this.f10435b = com_ushareit_listenit_dvo;
        this.f10434a = com_ushareit_listenit_dxb;
    }

    public void run() {
        synchronized (this.f10435b) {
            this.f10435b.f10428b = false;
            if (!this.f10435b.f10427a.m15800f()) {
                this.f10435b.f10427a.mo2096w().m16234D().m16263a("Connected to remote service");
                this.f10435b.f10427a.m15788a(this.f10434a);
            }
        }
    }
}
