package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpo implements OnClickListener {
    final /* synthetic */ MenuPopupView f14534a;

    public gpo(MenuPopupView menuPopupView) {
        this.f14534a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14534a.f16210e.mo2694k();
        fiq.m19373a(this.f14534a.getContext(), "UF_MenuSetAsRingClick", this.f14534a.f16211f, this.f14534a.f16208c.mo2562c(), "menu");
    }
}
