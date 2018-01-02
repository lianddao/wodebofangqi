package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gki implements gop {
    final /* synthetic */ ConfirmPopupView f14224a;
    final /* synthetic */ gkg f14225b;

    gki(gkg com_ushareit_listenit_gkg, ConfirmPopupView confirmPopupView) {
        this.f14225b = com_ushareit_listenit_gkg;
        this.f14224a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14225b.m20849u() != null) {
            this.f14225b.m22149a((glc) this.f14225b.m20849u());
            fiq.m19372a(this.f14225b.m20847s(), this.f14224a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14225b.m20846r(), "menu");
        } else if (this.f14225b.m20850v().size() > 0) {
            this.f14225b.m22151b(this.f14225b.m20850v());
            fiq.m19372a(this.f14225b.m20847s(), this.f14224a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14225b.m20846r(), "batch");
        }
        this.f14225b.m20828a(true);
        heb.m23597a(this.f14225b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        fis.m19422a(this.f14225b.m20847s(), "UF_PlaylistDeleteList", "deletelist");
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
