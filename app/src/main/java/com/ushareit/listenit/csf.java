package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.Callable;

class csf implements Callable<List<? extends cux>> {
    final /* synthetic */ cqq f8861a;
    final /* synthetic */ cxa f8862b;
    final /* synthetic */ csd f8863c;

    csf(csd com_ushareit_listenit_csd, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        this.f8863c = com_ushareit_listenit_csd;
        this.f8861a = com_ushareit_listenit_cqq;
        this.f8862b = com_ushareit_listenit_cxa;
    }

    public List<? extends cux> m12525a() {
        this.f8863c.f8851h.mo1602a(cvg.m13000a(this.f8861a), this.f8862b);
        return this.f8863c.m12487a(new cto(ctm.f8955b, this.f8861a, this.f8862b));
    }

    public /* synthetic */ Object call() {
        return m12525a();
    }
}
