package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gfl implements gop {
    final /* synthetic */ ConfirmPopupView f14029a;
    final /* synthetic */ gfk f14030b;

    gfl(gfk com_ushareit_listenit_gfk, ConfirmPopupView confirmPopupView) {
        this.f14030b = com_ushareit_listenit_gfk;
        this.f14029a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        this.f14030b.f14028a.f15804p.setText(this.f14029a.getInput());
        fle.m19717b().m19736d(true);
        if (gef.m21805a().m21835e()) {
            fle.m19717b().m19725a(this.f14029a.getInput());
            gef.m21805a().m21832b(this.f14029a.getInput(), null);
        }
        fiw.m19467c(this.f14030b.f14028a);
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
