package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fwp implements OnClickListener {
    final /* synthetic */ fwf f13632a;

    fwp(fwf com_ushareit_listenit_fwf) {
        this.f13632a = com_ushareit_listenit_fwf;
    }

    public void onClick(View view) {
        if (this.f13632a.f13617e.getCount() > 0) {
            gyn.m23214b(this.f13632a.m1328m());
        }
        if (this.f13632a.f13617e.getCount() != 0) {
            fji com_ushareit_listenit_fva;
            if (this.f13632a.ao.mo2565a() == 8) {
                com_ushareit_listenit_fva = new fva(new gas(this.f13632a.ao.m20816e()), true);
                com_ushareit_listenit_fva.mo2604c(this.f13632a.c);
                gyn.m23186a(this.f13632a.m1326l(), com_ushareit_listenit_fva);
                return;
            }
            com_ushareit_listenit_fva = new fww(this.f13632a.ao, false);
            com_ushareit_listenit_fva.m21232a(this.f13632a.f13617e.m18924b());
            gyn.m23186a(this.f13632a.m1326l(), com_ushareit_listenit_fva);
        }
    }
}
