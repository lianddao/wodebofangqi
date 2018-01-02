package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkq implements gop {
    final /* synthetic */ ConfirmPopupView f14234a;
    final /* synthetic */ gkp f14235b;

    gkq(gkp com_ushareit_listenit_gkp, ConfirmPopupView confirmPopupView) {
        this.f14235b = com_ushareit_listenit_gkp;
        this.f14234a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14235b.m20849u() != null) {
            this.f14235b.m22208a(this.f14234a.m25559h(), (glg) this.f14235b.m20849u());
            fiq.m19372a(this.f14235b.m20847s(), this.f14234a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14235b.m20846r(), "menu");
        } else if (this.f14235b.m20850v().size() > 0) {
            this.f14235b.m22209a(this.f14234a.m25559h(), this.f14235b.m20850v());
            fiq.m19372a(this.f14235b.m20847s(), this.f14234a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14235b.m20846r(), "batch");
        }
        this.f14235b.m20828a(true);
        heb.m23597a(this.f14235b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
