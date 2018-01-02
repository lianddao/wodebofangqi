package com.ushareit.listenit;

import java.util.List;

class ctd implements cum<csz> {
    final /* synthetic */ boolean f8933a;
    final /* synthetic */ List f8934b;
    final /* synthetic */ cqq f8935c;
    final /* synthetic */ ctc f8936d;

    ctd(ctc com_ushareit_listenit_ctc, boolean z, List list, cqq com_ushareit_listenit_cqq) {
        this.f8936d = com_ushareit_listenit_ctc;
        this.f8933a = z;
        this.f8934b = list;
        this.f8935c = com_ushareit_listenit_cqq;
    }

    public boolean m12590a(csz com_ushareit_listenit_csz) {
        return (com_ushareit_listenit_csz.m12556f() || this.f8933a) && !this.f8934b.contains(Long.valueOf(com_ushareit_listenit_csz.m12551a())) && (com_ushareit_listenit_csz.m12552b().m12340b(this.f8935c) || this.f8935c.m12340b(com_ushareit_listenit_csz.m12552b()));
    }

    public /* synthetic */ boolean mo1587a(Object obj) {
        return m12590a((csz) obj);
    }
}
