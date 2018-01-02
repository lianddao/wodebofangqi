package com.ushareit.listenit;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class dno extends PhantomReference<ceo<?>> {
    final /* synthetic */ dnn f10045a;
    private final int f10046b;

    public dno(dnn com_ushareit_listenit_dnn, ceo com_ushareit_listenit_ceo, int i, ReferenceQueue<ceo<?>> referenceQueue) {
        this.f10045a = com_ushareit_listenit_dnn;
        super(com_ushareit_listenit_ceo, referenceQueue);
        this.f10046b = i;
    }

    public void m15097a() {
        this.f10045a.f10041n.sendMessage(this.f10045a.f10041n.obtainMessage(2, this.f10046b, 2));
    }
}
