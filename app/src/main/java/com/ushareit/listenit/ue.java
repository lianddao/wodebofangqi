package com.ushareit.listenit;

import java.util.concurrent.Callable;

class ue implements Callable<Void> {
    final /* synthetic */ ud f16872a;

    ue(ud udVar) {
        this.f16872a = udVar;
    }

    public /* synthetic */ Object call() {
        return m26521a();
    }

    public Void m26521a() {
        synchronized (this.f16872a) {
            if (this.f16872a.f16867j == null) {
            } else {
                this.f16872a.m26516g();
                if (this.f16872a.m26513e()) {
                    this.f16872a.m26509d();
                    this.f16872a.f16869l = 0;
                }
            }
        }
        return null;
    }
}
