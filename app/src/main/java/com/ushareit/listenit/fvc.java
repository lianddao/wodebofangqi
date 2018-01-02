package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fvc implements OnClickListener {
    final /* synthetic */ fva f13568a;

    fvc(fva com_ushareit_listenit_fva) {
        this.f13568a = com_ushareit_listenit_fva;
    }

    public void onClick(View view) {
        if (this.f13568a.f13563g.m18894a() == this.f13568a.f13563g.getCount()) {
            this.f13568a.f13563g.m18902c();
            fip.m19369a(this.f13568a.m1326l(), "UF_ManageCancelAll", this.f13568a.am.mo2565a());
        } else {
            this.f13568a.f13563g.m18903d();
            fip.m19369a(this.f13568a.m1326l(), "UF_ManageSelectAll", this.f13568a.am.mo2565a());
        }
        this.f13568a.m21061X();
        this.f13568a.aj.m26965a(this.f13568a.f13563g.m18894a() > 0);
    }
}
