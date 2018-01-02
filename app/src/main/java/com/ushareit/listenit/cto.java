package com.ushareit.listenit;

public class cto extends ctk {
    private final cxa f8963a;

    public cto(ctm com_ushareit_listenit_ctm, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        super(ctl.Overwrite, com_ushareit_listenit_ctm, com_ushareit_listenit_cqq);
        this.f8963a = com_ushareit_listenit_cxa;
    }

    public ctk mo1589a(cwc com_ushareit_listenit_cwc) {
        return this.d.m12347h() ? new cto(this.c, cqq.m12332a(), this.f8963a.mo1637c(com_ushareit_listenit_cwc)) : new cto(this.c, this.d.m12344e(), this.f8963a);
    }

    public cxa m12624a() {
        return this.f8963a;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", new Object[]{m12609c(), m12610d(), this.f8963a});
    }
}
