package com.ushareit.listenit;

import java.io.EOFException;

class cpr implements Runnable {
    final /* synthetic */ cxy f8655a;
    final /* synthetic */ cpn f8656b;

    cpr(cpn com_ushareit_listenit_cpn, cxy com_ushareit_listenit_cxy) {
        this.f8656b = com_ushareit_listenit_cpn;
        this.f8655a = com_ushareit_listenit_cxy;
    }

    public void run() {
        if (this.f8655a.getCause() == null || !(this.f8655a.getCause() instanceof EOFException)) {
            this.f8656b.f8649a.f8646l.m13092a("WebSocket error.", this.f8655a, new Object[0]);
        } else {
            this.f8656b.f8649a.f8646l.m13093a("WebSocket reached EOF.", new Object[0]);
        }
        this.f8656b.f8649a.m12191g();
    }
}
