package com.ushareit.listenit;

public class cth extends ctk {
    private final boolean f8945a;
    private final cui<Boolean> f8946e;

    public cth(cqq com_ushareit_listenit_cqq, cui<Boolean> com_ushareit_listenit_cui_java_lang_Boolean, boolean z) {
        super(ctl.AckUserWrite, ctm.f8954a, com_ushareit_listenit_cqq);
        this.f8946e = com_ushareit_listenit_cui_java_lang_Boolean;
        this.f8945a = z;
    }

    public ctk mo1589a(cwc com_ushareit_listenit_cwc) {
        if (!this.d.m12347h()) {
            cyr.m13388a(this.d.m12343d().equals(com_ushareit_listenit_cwc), "operationForChild called for unrelated child.");
            return new cth(this.d.m12344e(), this.f8946e, this.f8945a);
        } else if (this.f8946e.m12746b() != null) {
            cyr.m13388a(this.f8946e.m12749c().mo1494d(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new cth(cqq.m12332a(), this.f8946e.m12750c(new cqq(com_ushareit_listenit_cwc)), this.f8945a);
        }
    }

    public cui<Boolean> m12613a() {
        return this.f8946e;
    }

    public boolean m12614b() {
        return this.f8945a;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", new Object[]{m12609c(), Boolean.valueOf(this.f8945a), this.f8946e});
    }
}
