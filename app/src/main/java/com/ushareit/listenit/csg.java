package com.ushareit.listenit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

class csg implements Callable<List<? extends cux>> {
    final /* synthetic */ Map f8864a;
    final /* synthetic */ cqq f8865b;
    final /* synthetic */ csd f8866c;

    csg(csd com_ushareit_listenit_csd, Map map, cqq com_ushareit_listenit_cqq) {
        this.f8866c = com_ushareit_listenit_csd;
        this.f8864a = map;
        this.f8865b = com_ushareit_listenit_cqq;
    }

    public List<? extends cux> m12526a() {
        cpz b = cpz.m12235b(this.f8864a);
        this.f8866c.f8851h.mo1605b(this.f8865b, b);
        return this.f8866c.m12487a(new ctj(ctm.f8955b, this.f8865b, b));
    }

    public /* synthetic */ Object call() {
        return m12526a();
    }
}
