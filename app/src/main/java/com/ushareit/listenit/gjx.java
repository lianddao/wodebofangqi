package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class gjx implements gop {
    final /* synthetic */ ConfirmPopupView f14208a;
    final /* synthetic */ gjw f14209b;

    gjx(gjw com_ushareit_listenit_gjw, ConfirmPopupView confirmPopupView) {
        this.f14209b = com_ushareit_listenit_gjw;
        this.f14208a = confirmPopupView;
    }

    public boolean mo2508a(View view) {
        if (this.f14209b.m20849u() != null) {
            this.f14209b.m22097a(this.f14208a.m25559h(), (gkx) this.f14209b.m20849u());
            fiq.m19372a(this.f14209b.m20847s(), this.f14208a.m25559h() ? "UF_MenuDeleteClipFile" : "UF_MenuDeleteClip", this.f14209b.m20846r(), "menu");
        }
        this.f14209b.m20828a(true);
        heb.m23597a(this.f14209b.m20847s().getResources().getString(C0349R.string.toast_delete), 0).show();
        return false;
    }

    public boolean mo2509b(View view) {
        return false;
    }
}
