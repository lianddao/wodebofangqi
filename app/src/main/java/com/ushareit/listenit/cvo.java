package com.ushareit.listenit;

class cvo implements cvt {
    private final ctf f9216a;
    private final cvj f9217b;
    private final cxa f9218c;

    public cvo(ctf com_ushareit_listenit_ctf, cvj com_ushareit_listenit_cvj, cxa com_ushareit_listenit_cxa) {
        this.f9216a = com_ushareit_listenit_ctf;
        this.f9217b = com_ushareit_listenit_cvj;
        this.f9218c = com_ushareit_listenit_cxa;
    }

    public cwz mo1614a(cws com_ushareit_listenit_cws, cwz com_ushareit_listenit_cwz, boolean z) {
        return this.f9216a.m12595a(this.f9218c != null ? this.f9218c : this.f9217b.m13022d(), com_ushareit_listenit_cwz, z, com_ushareit_listenit_cws);
    }

    public cxa mo1615a(cwc com_ushareit_listenit_cwc) {
        cut a = this.f9217b.m13017a();
        if (a.m12779a(com_ushareit_listenit_cwc)) {
            return a.m12781c().mo1637c(com_ushareit_listenit_cwc);
        }
        return this.f9216a.m12598a(com_ushareit_listenit_cwc, this.f9218c != null ? new cut(cwt.m13243a(this.f9218c, cwu.m13253d()), true, false) : this.f9217b.m13021c());
    }
}
