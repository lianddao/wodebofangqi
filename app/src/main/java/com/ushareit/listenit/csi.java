package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

class csi implements Callable<List<? extends cux>> {
    final /* synthetic */ csu f8869a;
    final /* synthetic */ csd f8870b;

    csi(csd com_ushareit_listenit_csd, csu com_ushareit_listenit_csu) {
        this.f8870b = com_ushareit_listenit_csd;
        this.f8869a = com_ushareit_listenit_csu;
    }

    public List<? extends cux> m12528a() {
        cvg a = this.f8870b.m12500b(this.f8869a);
        if (a == null) {
            return Collections.emptyList();
        }
        this.f8870b.f8851h.mo1608d(a);
        return this.f8870b.m12491a(a, new cti(ctm.m12618a(a.m13003b()), cqq.m12332a()));
    }

    public /* synthetic */ Object call() {
        return m12528a();
    }
}
