package com.ushareit.listenit;

import java.util.ArrayList;

class epo extends epm {
    boolean f11446a = false;
    final /* synthetic */ ArrayList f11447b;
    final /* synthetic */ epn f11448c;

    epo(epn com_ushareit_listenit_epn, ArrayList arrayList) {
        this.f11448c = com_ushareit_listenit_epn;
        this.f11447b = arrayList;
    }

    public void mo2231c(epk com_ushareit_listenit_epk) {
        this.f11446a = true;
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        if (!this.f11446a) {
            int size = this.f11447b.size();
            for (int i = 0; i < size; i++) {
                ept com_ushareit_listenit_ept = (ept) this.f11447b.get(i);
                com_ushareit_listenit_ept.f11458a.mo2234a();
                this.f11448c.f11436c.add(com_ushareit_listenit_ept.f11458a);
            }
        }
    }
}
