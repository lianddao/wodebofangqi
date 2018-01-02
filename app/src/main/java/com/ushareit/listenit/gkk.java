package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkk implements gop {
    final /* synthetic */ ConfirmPopupView f14226a;
    final /* synthetic */ gkj f14227b;

    gkk(gkj com_ushareit_listenit_gkj, ConfirmPopupView confirmPopupView) {
        this.f14227b = com_ushareit_listenit_gkj;
        this.f14226a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14227b.m20849u() != null) {
            this.f14227b.m22165a(this.f14226a.m25559h(), (glg) this.f14227b.m20849u());
            fiq.m19372a(this.f14227b.m20847s(), this.f14226a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14227b.m20846r(), "menu");
        } else if (this.f14227b.m20850v().size() > 0) {
            this.f14227b.m22166a(this.f14226a.m25559h(), this.f14227b.m20850v());
            fiq.m19372a(this.f14227b.m20847s(), this.f14226a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14227b.m20846r(), "batch");
        }
        this.f14227b.m20828a(true);
        heb.m23597a(this.f14227b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        fis.m19422a(this.f14227b.m20847s(), "UF_PlaylistDeleteSong", "deletesong");
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
