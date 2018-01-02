package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class fvb extends hhw {
    List<gla> f13566a = new ArrayList();
    final /* synthetic */ fva f13567b;

    fvb(fva com_ushareit_listenit_fva) {
        this.f13567b = com_ushareit_listenit_fva;
    }

    public void execute() {
        if (this.f13567b.am.mo2565a() == 8) {
            this.f13567b.f13561e = fqs.m20473h(frd.m20621e(this.f13567b.al));
        }
        this.f13566a.addAll(this.f13567b.am.mo2568d());
    }

    public void callback() {
        try {
            this.f13567b.f13563g.m18898a(this.f13566a);
            this.f13567b.f13564h.setVisibility(8);
            this.f13567b.m21061X();
        } catch (Exception e) {
            this.f13567b.ak = true;
        }
    }
}
