package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpq implements OnClickListener {
    final /* synthetic */ MenuPopupView f14536a;

    public gpq(MenuPopupView menuPopupView) {
        this.f14536a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14536a.f16210e.mo2696m();
        fiq.m19373a(this.f14536a.getContext(), "UF_MenuSetAsAlarmClick", this.f14536a.f16211f, this.f14536a.f16208c.mo2562c(), "menu");
    }
}
