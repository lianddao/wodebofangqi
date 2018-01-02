package com.ushareit.listenit;

import java.util.Iterator;

class bqp implements Runnable {
    final /* synthetic */ bqn f7441a;
    final /* synthetic */ bqo f7442b;

    bqp(bqo com_ushareit_listenit_bqo, bqn com_ushareit_listenit_bqn) {
        this.f7442b = com_ushareit_listenit_bqo;
        this.f7441a = com_ushareit_listenit_bqn;
    }

    public void run() {
        Iterator it = this.f7442b.f7408b.iterator();
        while (it.hasNext()) {
            ((bqq) it.next()).mo917a(this.f7441a);
        }
    }
}
