package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gqn implements gop {
    final /* synthetic */ ConfirmPopupView f14561a;
    final /* synthetic */ gqm f14562b;

    gqn(gqm com_ushareit_listenit_gqm, ConfirmPopupView confirmPopupView) {
        this.f14562b = com_ushareit_listenit_gqm;
        this.f14561a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        glg o = gyp.m23301o();
        if (o != null) {
            this.f14562b.f14560a.m25613a(this.f14561a.m25559h(), o);
            String str;
            if (this.f14561a.m25559h()) {
                str = "UF_MenuDeleteSongFile";
            } else {
                str = "UF_MenuDeleteSong";
            }
            fit.m19433b(this.f14562b.f14560a.getContext(), "delete");
        }
        heb.m23597a(this.f14562b.f14560a.getContext().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
