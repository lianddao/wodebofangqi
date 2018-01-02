package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.Callable;

class csp implements Callable<List<? extends cux>> {
    final /* synthetic */ boolean f8893a;
    final /* synthetic */ cqq f8894b;
    final /* synthetic */ cpz f8895c;
    final /* synthetic */ long f8896d;
    final /* synthetic */ cpz f8897e;
    final /* synthetic */ csd f8898f;

    csp(csd com_ushareit_listenit_csd, boolean z, cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, long j, cpz com_ushareit_listenit_cpz2) {
        this.f8898f = com_ushareit_listenit_csd;
        this.f8893a = z;
        this.f8894b = com_ushareit_listenit_cqq;
        this.f8895c = com_ushareit_listenit_cpz;
        this.f8896d = j;
        this.f8897e = com_ushareit_listenit_cpz2;
    }

    public List<? extends cux> m12537a() {
        if (this.f8893a) {
            this.f8898f.f8851h.mo1599a(this.f8894b, this.f8895c, this.f8896d);
        }
        this.f8898f.f8846c.m12585a(this.f8894b, this.f8897e, Long.valueOf(this.f8896d));
        return this.f8898f.m12487a(new ctj(ctm.f8954a, this.f8894b, this.f8897e));
    }

    public /* synthetic */ Object call() {
        return m12537a();
    }
}
