package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpy implements OnClickListener {
    final /* synthetic */ MenuPopupView f14544a;

    public gpy(MenuPopupView menuPopupView) {
        this.f14544a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14544a.f16210e.mo2691j();
        fiq.m19373a(this.f14544a.getContext(), "UF_MenuDeleteClick", this.f14544a.f16211f, this.f14544a.f16208c.mo2562c(), "menu");
    }
}
