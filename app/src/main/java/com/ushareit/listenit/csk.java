package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

class csk implements Callable<List<? extends cux>> {
    final /* synthetic */ csu f8875a;
    final /* synthetic */ cqq f8876b;
    final /* synthetic */ Map f8877c;
    final /* synthetic */ csd f8878d;

    csk(csd com_ushareit_listenit_csd, csu com_ushareit_listenit_csu, cqq com_ushareit_listenit_cqq, Map map) {
        this.f8878d = com_ushareit_listenit_csd;
        this.f8875a = com_ushareit_listenit_csu;
        this.f8876b = com_ushareit_listenit_cqq;
        this.f8877c = map;
    }

    public List<? extends cux> m12530a() {
        cvg a = this.f8878d.m12500b(this.f8875a);
        if (a == null) {
            return Collections.emptyList();
        }
        cqq a2 = cqq.m12333a(a.m13002a(), this.f8876b);
        cpz b = cpz.m12235b(this.f8877c);
        this.f8878d.f8851h.mo1605b(this.f8876b, b);
        return this.f8878d.m12491a(a, new ctj(ctm.m12618a(a.m13003b()), a2, b));
    }

    public /* synthetic */ Object call() {
        return m12530a();
    }
}
