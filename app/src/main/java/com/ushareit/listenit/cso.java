package com.ushareit.listenit;

import java.util.List;

class cso extends cnu<cwc, cui<csc>> {
    final /* synthetic */ cxa f8888a;
    final /* synthetic */ ctf f8889b;
    final /* synthetic */ ctk f8890c;
    final /* synthetic */ List f8891d;
    final /* synthetic */ csd f8892e;

    cso(csd com_ushareit_listenit_csd, cxa com_ushareit_listenit_cxa, ctf com_ushareit_listenit_ctf, ctk com_ushareit_listenit_ctk, List list) {
        this.f8892e = com_ushareit_listenit_csd;
        this.f8888a = com_ushareit_listenit_cxa;
        this.f8889b = com_ushareit_listenit_ctf;
        this.f8890c = com_ushareit_listenit_ctk;
        this.f8891d = list;
    }

    public void m12535a(cwc com_ushareit_listenit_cwc, cui<csc> com_ushareit_listenit_cui_com_ushareit_listenit_csc) {
        cxa com_ushareit_listenit_cxa = null;
        if (this.f8888a != null) {
            com_ushareit_listenit_cxa = this.f8888a.mo1637c(com_ushareit_listenit_cwc);
        }
        ctf a = this.f8889b.m12594a(com_ushareit_listenit_cwc);
        ctk a2 = this.f8890c.mo1589a(com_ushareit_listenit_cwc);
        if (a2 != null) {
            this.f8891d.addAll(this.f8892e.m12502b(a2, com_ushareit_listenit_cui_com_ushareit_listenit_csc, com_ushareit_listenit_cxa, a));
        }
    }

    public /* synthetic */ void mo1573a(Object obj, Object obj2) {
        m12535a((cwc) obj, (cui) obj2);
    }
}
