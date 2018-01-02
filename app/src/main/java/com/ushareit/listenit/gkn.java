package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gkn implements gop {
    final /* synthetic */ ConfirmPopupView f14230a;
    final /* synthetic */ gkm f14231b;

    gkn(gkm com_ushareit_listenit_gkm, ConfirmPopupView confirmPopupView) {
        this.f14231b = com_ushareit_listenit_gkm;
        this.f14230a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14231b.m20849u() != null) {
            this.f14231b.m22188a(this.f14230a.m25559h(), (glg) this.f14231b.m20849u());
            fiq.m19372a(this.f14231b.m20847s(), this.f14230a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14231b.m20846r(), "menu");
        } else if (this.f14231b.m20850v().size() > 0) {
            this.f14231b.m22189a(this.f14230a.m25559h(), this.f14231b.m20850v());
            fiq.m19372a(this.f14231b.m20847s(), this.f14230a.m25559h() ? "UF_MenuDeleteSongFile" : "UF_MenuDeleteSong", this.f14231b.m20846r(), "batch");
        }
        this.f14231b.m20828a(true);
        heb.m23597a(this.f14231b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
