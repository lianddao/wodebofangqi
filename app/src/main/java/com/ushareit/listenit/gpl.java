package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpl implements OnClickListener {
    final /* synthetic */ MenuPopupView f14531a;

    public gpl(MenuPopupView menuPopupView) {
        this.f14531a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14531a.f16210e.mo2692q();
        fiq.m19373a(this.f14531a.getContext(), "UF_MenuShareHideClick", this.f14531a.f16211f, this.f14531a.f16208c.mo2562c(), "menu");
    }
}
