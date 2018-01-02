package com.ushareit.listenit;

import android.view.View;

class gqf implements Runnable {
    final /* synthetic */ View f14552a;
    final /* synthetic */ gqe f14553b;

    gqf(gqe com_ushareit_listenit_gqe, View view) {
        this.f14553b = com_ushareit_listenit_gqe;
        this.f14552a = view;
    }

    public void run() {
        this.f14553b.f14551a.f16231b.removeViewFromRootView(this.f14552a);
        this.f14553b.f14551a.f16231b.m24826a(this.f14553b.f14551a.f16230a.m21286Z());
        this.f14553b.f14551a.f16230a.m21285Y();
    }
}
