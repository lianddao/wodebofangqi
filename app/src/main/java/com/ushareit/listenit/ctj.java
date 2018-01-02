package com.ushareit.listenit;

public class ctj extends ctk {
    private final cpz f8948a;

    public ctj(ctm com_ushareit_listenit_ctm, cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        super(ctl.Merge, com_ushareit_listenit_ctm, com_ushareit_listenit_cqq);
        this.f8948a = com_ushareit_listenit_cpz;
    }

    public cpz m12616a() {
        return this.f8948a;
    }

    public ctk mo1589a(cwc com_ushareit_listenit_cwc) {
        if (!this.d.m12347h()) {
            return this.d.m12343d().equals(com_ushareit_listenit_cwc) ? new ctj(this.c, this.d.m12344e(), this.f8948a) : null;
        } else {
            cpz d = this.f8948a.m12246d(new cqq(com_ushareit_listenit_cwc));
            return d.m12248e() ? null : d.m12242b() != null ? new cto(this.c, cqq.m12332a(), d.m12242b()) : new ctj(this.c, cqq.m12332a(), d);
        }
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{m12609c(), m12610d(), this.f8948a});
    }
}
