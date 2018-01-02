package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gqb implements OnClickListener {
    final /* synthetic */ MenuPopupView f14547a;

    public gqb(MenuPopupView menuPopupView) {
        this.f14547a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14547a.f16210e.mo2575g();
        fiq.m19373a(this.f14547a.getContext(), "UF_MenuShareClick", this.f14547a.f16211f, this.f14547a.f16208c.mo2562c(), "menu");
    }
}
