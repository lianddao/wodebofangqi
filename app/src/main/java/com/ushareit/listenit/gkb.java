package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkb implements gop {
    final /* synthetic */ ConfirmPopupView f14216a;
    final /* synthetic */ gka f14217b;

    gkb(gka com_ushareit_listenit_gka, ConfirmPopupView confirmPopupView) {
        this.f14217b = com_ushareit_listenit_gka;
        this.f14216a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14217b.m20849u() != null) {
            this.f14217b.m22128a(this.f14216a.m25559h(), (glg) this.f14217b.m20849u());
            fiq.m19372a(this.f14217b.m20847s(), this.f14216a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14217b.m20846r(), "menu");
        } else if (this.f14217b.m20850v().size() > 0) {
            this.f14217b.m22129a(this.f14216a.m25559h(), this.f14217b.m20850v());
            fiq.m19372a(this.f14217b.m20847s(), this.f14216a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14217b.m20846r(), "batch");
        }
        this.f14217b.m20828a(true);
        heb.m23597a(this.f14217b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
