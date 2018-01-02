package com.ushareit.listenit;

import java.io.IOException;

class bnu implements Runnable {
    final /* synthetic */ IOException f7187a;
    final /* synthetic */ bnq f7188b;

    bnu(bnq com_ushareit_listenit_bnq, IOException iOException) {
        this.f7188b = com_ushareit_listenit_bnq;
        this.f7187a = iOException;
    }

    public void run() {
        this.f7188b.f7161e.m9229a(this.f7187a);
    }
}
