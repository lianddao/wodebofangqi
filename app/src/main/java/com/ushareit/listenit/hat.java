package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.MenuPopupView;

class hat extends fdw {
    final /* synthetic */ hap f15095a;

    hat(hap com_ushareit_listenit_hap) {
        this.f15095a = com_ushareit_listenit_hap;
    }

    public void mo2608a(View view, int i) {
        gla com_ushareit_listenit_gla = (glc) this.f15095a.f15081q.m18923b(i);
        fji com_ushareit_listenit_fwf = new fwf(new gas(com_ushareit_listenit_gla), true);
        com_ushareit_listenit_fwf.mo2604c(com_ushareit_listenit_gla.f14285e);
        com_ushareit_listenit_fwf.m21192a(com_ushareit_listenit_gla);
        gyn.m23186a(this.f15095a.o, com_ushareit_listenit_fwf);
        fii.m19288a(this.f15095a.o, this.f15095a.f15087w.mo2565a(), com_ushareit_listenit_gla);
    }

    public void mo2610b(gla com_ushareit_listenit_gla) {
        BasePopupView menuPopupView = new MenuPopupView(this.f15095a.o, this.f15095a.f15087w.mo2566b(), com_ushareit_listenit_gla);
        menuPopupView.setTitle(com_ushareit_listenit_gla.mo2562c());
        menuPopupView.setParentName("");
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(this.f15095a.f15072E);
        gyn.m23197a((ak) this.f15095a.o, com_ushareit_listenit_fyi);
    }
}
