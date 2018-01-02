package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

class csj implements Callable<List<? extends cux>> {
    final /* synthetic */ csu f8871a;
    final /* synthetic */ cqq f8872b;
    final /* synthetic */ cxa f8873c;
    final /* synthetic */ csd f8874d;

    csj(csd com_ushareit_listenit_csd, csu com_ushareit_listenit_csu, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        this.f8874d = com_ushareit_listenit_csd;
        this.f8871a = com_ushareit_listenit_csu;
        this.f8872b = com_ushareit_listenit_cqq;
        this.f8873c = com_ushareit_listenit_cxa;
    }

    public List<? extends cux> m12529a() {
        cvg a = this.f8874d.m12500b(this.f8871a);
        if (a == null) {
            return Collections.emptyList();
        }
        cqq a2 = cqq.m12333a(a.m13002a(), this.f8872b);
        this.f8874d.f8851h.mo1602a(a2.m12347h() ? a : cvg.m13000a(this.f8872b), this.f8873c);
        return this.f8874d.m12491a(a, new cto(ctm.m12618a(a.m13003b()), a2, this.f8873c));
    }

    public /* synthetic */ Object call() {
        return m12529a();
    }
}
