package com.ushareit.listenit;

import java.util.List;

class fvg implements fyv {
    final /* synthetic */ gkf f13572a;
    final /* synthetic */ List f13573b;
    final /* synthetic */ fvf f13574c;

    fvg(fvf com_ushareit_listenit_fvf, gkf com_ushareit_listenit_gkf, List list) {
        this.f13574c = com_ushareit_listenit_fvf;
        this.f13572a = com_ushareit_listenit_gkf;
        this.f13573b = list;
    }

    public void mo2507a() {
        if (this.f13572a.m20852x()) {
            this.f13574c.f13571a.f13563g.m18901b(this.f13573b);
            this.f13574c.f13571a.aj.m26965a(false);
            this.f13574c.f13571a.m21061X();
            for (gla a : this.f13573b) {
                a.m20775a(false);
            }
            heb.m23597a(this.f13574c.f13571a.m1329n().getString(C0349R.string.toast_delete), 0).show();
        }
    }
}
