package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpr implements OnClickListener {
    final /* synthetic */ MenuPopupView f14537a;

    public gpr(MenuPopupView menuPopupView) {
        this.f14537a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14537a.f16210e.mo2697n();
        fiq.m19373a(this.f14537a.getContext(), "UF_MenuEditClipClick", this.f14537a.f16211f, this.f14537a.f16208c.mo2562c(), "menu");
    }
}
