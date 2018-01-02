package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class crm implements cph {
    final /* synthetic */ cqq f8798a;
    final /* synthetic */ List f8799b;
    final /* synthetic */ cqt f8800c;
    final /* synthetic */ cqt f8801d;

    crm(cqt com_ushareit_listenit_cqt, cqq com_ushareit_listenit_cqq, List list, cqt com_ushareit_listenit_cqt2) {
        this.f8801d = com_ushareit_listenit_cqt;
        this.f8798a = com_ushareit_listenit_cqq;
        this.f8799b = list;
        this.f8800c = com_ushareit_listenit_cqt2;
    }

    public void mo1571a(String str, String str2) {
        int i = 0;
        ece a = cqt.m12373b(str, str2);
        this.f8801d.m12367a("Transaction", this.f8798a, a);
        List arrayList = new ArrayList();
        if (a == null) {
            List arrayList2 = new ArrayList();
            for (crp com_ushareit_listenit_crp : this.f8799b) {
                com_ushareit_listenit_crp.f8809d = crq.COMPLETED;
                arrayList.addAll(this.f8801d.f8749q.m12509a(com_ushareit_listenit_crp.f8814i, false, false, this.f8801d.f8736d));
                arrayList2.add(new crn(this, com_ushareit_listenit_crp, eeh.m16842a(eeh.m16843a(this.f8800c, com_ushareit_listenit_crp.f8806a), cwt.m13242a(com_ushareit_listenit_crp.f8817l))));
                this.f8801d.m12391a(new ctb(this.f8801d, com_ushareit_listenit_crp.f8808c, cvg.m13000a(com_ushareit_listenit_crp.f8806a)));
            }
            this.f8801d.m12375b(this.f8801d.f8740h.m12763a(this.f8798a));
            this.f8801d.m12386f();
            this.f8800c.m12368a(arrayList);
            while (i < arrayList2.size()) {
                this.f8801d.m12403b((Runnable) arrayList2.get(i));
                i++;
            }
            return;
        }
        if (a.m16714a() == -1) {
            for (crp com_ushareit_listenit_crp2 : this.f8799b) {
                if (com_ushareit_listenit_crp2.f8809d == crq.SENT_NEEDS_ABORT) {
                    com_ushareit_listenit_crp2.f8809d = crq.NEEDS_ABORT;
                } else {
                    com_ushareit_listenit_crp2.f8809d = crq.RUN;
                }
            }
        } else {
            for (crp com_ushareit_listenit_crp22 : this.f8799b) {
                com_ushareit_listenit_crp22.f8809d = crq.NEEDS_ABORT;
                com_ushareit_listenit_crp22.f8813h = a;
            }
        }
        this.f8801d.m12350a(this.f8798a);
    }
}
