package com.ushareit.listenit;

import java.util.ArrayList;

class epp implements epl {
    final /* synthetic */ epn f11449a;
    private epn f11450b;

    epp(epn com_ushareit_listenit_epn, epn com_ushareit_listenit_epn2) {
        this.f11449a = com_ushareit_listenit_epn;
        this.f11450b = com_ushareit_listenit_epn2;
    }

    public void mo2231c(epk com_ushareit_listenit_epk) {
        if (!this.f11449a.f11435b && this.f11449a.f11436c.size() == 0 && this.f11449a.a != null) {
            int size = this.f11449a.a.size();
            for (int i = 0; i < size; i++) {
                ((epl) this.f11449a.a.get(i)).mo2231c(this.f11450b);
            }
        }
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        com_ushareit_listenit_epk.m17276b(this);
        this.f11449a.f11436c.remove(com_ushareit_listenit_epk);
        ((ept) this.f11450b.f11437d.get(com_ushareit_listenit_epk)).f11463f = true;
        if (!this.f11449a.f11435b) {
            int i;
            boolean z;
            ArrayList c = this.f11450b.f11439f;
            int size = c.size();
            for (i = 0; i < size; i++) {
                if (!((ept) c.get(i)).f11463f) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                if (this.f11449a.a != null) {
                    ArrayList arrayList = (ArrayList) this.f11449a.a.clone();
                    int size2 = arrayList.size();
                    for (i = 0; i < size2; i++) {
                        ((epl) arrayList.get(i)).mo2230b(this.f11450b);
                    }
                }
                this.f11450b.f11442i = false;
            }
        }
    }

    public void mo2232d(epk com_ushareit_listenit_epk) {
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
    }
}
