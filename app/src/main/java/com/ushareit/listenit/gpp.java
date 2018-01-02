package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpp implements OnClickListener {
    final /* synthetic */ MenuPopupView f14535a;

    public gpp(MenuPopupView menuPopupView) {
        this.f14535a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14535a.f16210e.mo2695l();
        fiq.m19373a(this.f14535a.getContext(), "UF_MenuSetAsNotificationClick", this.f14535a.f16211f, this.f14535a.f16208c.mo2562c(), "menu");
    }
}
