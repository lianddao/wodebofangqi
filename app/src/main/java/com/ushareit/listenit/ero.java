package com.ushareit.listenit;

import android.view.View;
import java.util.ArrayList;

class ero implements epl, erf {
    final /* synthetic */ erm f11617a;

    private ero(erm com_ushareit_listenit_erm) {
        this.f11617a = com_ushareit_listenit_erm;
    }

    public void mo2229a(epk com_ushareit_listenit_epk) {
        if (this.f11617a.f11612i != null) {
            this.f11617a.f11612i.mo2229a(com_ushareit_listenit_epk);
        }
    }

    public void mo2231c(epk com_ushareit_listenit_epk) {
        if (this.f11617a.f11612i != null) {
            this.f11617a.f11612i.mo2231c(com_ushareit_listenit_epk);
        }
    }

    public void mo2232d(epk com_ushareit_listenit_epk) {
        if (this.f11617a.f11612i != null) {
            this.f11617a.f11612i.mo2232d(com_ushareit_listenit_epk);
        }
    }

    public void mo2230b(epk com_ushareit_listenit_epk) {
        if (this.f11617a.f11612i != null) {
            this.f11617a.f11612i.mo2230b(com_ushareit_listenit_epk);
        }
        this.f11617a.f11615l.remove(com_ushareit_listenit_epk);
        if (this.f11617a.f11615l.isEmpty()) {
            this.f11617a.f11612i = null;
        }
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float l = com_ushareit_listenit_eqy.m17400l();
        erq com_ushareit_listenit_erq = (erq) this.f11617a.f11615l.get(com_ushareit_listenit_eqy);
        if ((com_ushareit_listenit_erq.f11621a & 511) != 0) {
            View view = (View) this.f11617a.f11605b.get();
            if (view != null) {
                view.invalidate();
            }
        }
        ArrayList arrayList = com_ushareit_listenit_erq.f11622b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                erp com_ushareit_listenit_erp = (erp) arrayList.get(i);
                this.f11617a.m17600b(com_ushareit_listenit_erp.f11618a, com_ushareit_listenit_erp.f11619b + (com_ushareit_listenit_erp.f11620c * l));
            }
        }
        View view2 = (View) this.f11617a.f11605b.get();
        if (view2 != null) {
            view2.invalidate();
        }
    }
}
