package com.ushareit.listenit;

import android.view.View;
import java.util.ArrayList;

class erv implements epl, erf {
    final /* synthetic */ ert f11640a;

    private erv(ert com_ushareit_listenit_ert) {
        this.f11640a = com_ushareit_listenit_ert;
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
        if (this.f11640a.f11635j != null) {
            this.f11640a.f11635j.mo2229a(com_ushareit_listenit_epk);
        }
    }

    public void mo2231c(epk com_ushareit_listenit_epk) {
        if (this.f11640a.f11635j != null) {
            this.f11640a.f11635j.mo2231c(com_ushareit_listenit_epk);
        }
    }

    public void mo2232d(epk com_ushareit_listenit_epk) {
        if (this.f11640a.f11635j != null) {
            this.f11640a.f11635j.mo2232d(com_ushareit_listenit_epk);
        }
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        if (this.f11640a.f11635j != null) {
            this.f11640a.f11635j.mo2230b(com_ushareit_listenit_epk);
        }
        this.f11640a.f11638m.remove(com_ushareit_listenit_epk);
        if (this.f11640a.f11638m.isEmpty()) {
            this.f11640a.f11635j = null;
        }
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float l = com_ushareit_listenit_eqy.m17400l();
        erx com_ushareit_listenit_erx = (erx) this.f11640a.f11638m.get(com_ushareit_listenit_eqy);
        if ((com_ushareit_listenit_erx.f11644a & 511) != 0) {
            View view = (View) this.f11640a.f11628c.get();
            if (view != null) {
                view.invalidate();
            }
        }
        ArrayList arrayList = com_ushareit_listenit_erx.f11645b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                erw com_ushareit_listenit_erw = (erw) arrayList.get(i);
                this.f11640a.m17633b(com_ushareit_listenit_erw.f11641a, com_ushareit_listenit_erw.f11642b + (com_ushareit_listenit_erw.f11643c * l));
            }
        }
        View view2 = (View) this.f11640a.f11628c.get();
        if (view2 != null) {
            view2.invalidate();
        }
    }
}
