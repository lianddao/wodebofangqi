package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gke implements gop {
    final /* synthetic */ ConfirmPopupView f14220a;
    final /* synthetic */ gkd f14221b;

    gke(gkd com_ushareit_listenit_gkd, ConfirmPopupView confirmPopupView) {
        this.f14221b = com_ushareit_listenit_gkd;
        this.f14220a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14221b.m20849u() != null) {
            this.f14221b.m22086a(this.f14220a.m25559h(), this.f14221b.m20849u());
            fiq.m19372a(this.f14221b.m20847s(), this.f14220a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14221b.m20846r(), "menu");
        } else if (this.f14221b.m20850v().size() > 0) {
            this.f14221b.m22087a(this.f14220a.m25559h(), this.f14221b.m20850v());
            fiq.m19372a(this.f14221b.m20847s(), this.f14220a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14221b.m20846r(), "batch");
        }
        this.f14221b.m20828a(true);
        heb.m23597a(this.f14221b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
