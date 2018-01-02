package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkt implements gop {
    final /* synthetic */ ConfirmPopupView f14238a;
    final /* synthetic */ gks f14239b;

    gkt(gks com_ushareit_listenit_gks, ConfirmPopupView confirmPopupView) {
        this.f14239b = com_ushareit_listenit_gks;
        this.f14238a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14239b.m20849u() != null) {
            this.f14239b.m22230a(this.f14238a.m25559h(), (glg) this.f14239b.m20849u());
            fiq.m19372a(this.f14239b.m20847s(), this.f14238a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14239b.m20846r(), "menu");
        } else if (this.f14239b.m20850v().size() > 0) {
            this.f14239b.m22231a(this.f14238a.m25559h(), this.f14239b.m20850v());
            fiq.m19372a(this.f14239b.m20847s(), this.f14238a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14239b.m20846r(), "batch");
        }
        this.f14239b.m20828a(true);
        heb.m23597a(this.f14239b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
