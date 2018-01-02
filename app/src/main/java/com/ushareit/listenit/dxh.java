package com.ushareit.listenit;

class dxh implements Runnable {
    final /* synthetic */ String f10563a;
    final /* synthetic */ dxg f10564b;

    dxh(dxg com_ushareit_listenit_dxg, String str) {
        this.f10564b = com_ushareit_listenit_dxg;
        this.f10563a = str;
    }

    public void run() {
        dxr e = this.f10564b.n.m16454e();
        if (!e.m15694a() || e.m15695b()) {
            this.f10564b.m16237a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            e.f10593b.m16334a(this.f10563a);
        }
    }
}
