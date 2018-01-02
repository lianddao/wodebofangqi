package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.Callable;

class csh implements Callable<List<? extends cux>> {
    final /* synthetic */ cqq f8867a;
    final /* synthetic */ csd f8868b;

    csh(csd com_ushareit_listenit_csd, cqq com_ushareit_listenit_cqq) {
        this.f8868b = com_ushareit_listenit_csd;
        this.f8867a = com_ushareit_listenit_cqq;
    }

    public List<? extends cux> m12527a() {
        this.f8868b.f8851h.mo1608d(cvg.m13000a(this.f8867a));
        return this.f8868b.m12487a(new cti(ctm.f8955b, this.f8867a));
    }

    public /* synthetic */ Object call() {
        return m12527a();
    }
}
