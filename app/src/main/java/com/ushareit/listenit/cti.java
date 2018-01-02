package com.ushareit.listenit;

public class cti extends ctk {
    static final /* synthetic */ boolean f8947a = (!cti.class.desiredAssertionStatus());

    public cti(ctm com_ushareit_listenit_ctm, cqq com_ushareit_listenit_cqq) {
        super(ctl.ListenComplete, com_ushareit_listenit_ctm, com_ushareit_listenit_cqq);
        if (!f8947a && com_ushareit_listenit_ctm.m12619a()) {
            throw new AssertionError("Can't have a listen complete from a user source");
        }
    }

    public ctk mo1589a(cwc com_ushareit_listenit_cwc) {
        return this.d.m12347h() ? new cti(this.c, cqq.m12332a()) : new cti(this.c, this.d.m12344e());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", new Object[]{m12609c(), m12610d()});
    }
}
