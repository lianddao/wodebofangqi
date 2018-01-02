package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpu implements OnClickListener {
    final /* synthetic */ MenuPopupView f14540a;

    public gpu(MenuPopupView menuPopupView) {
        this.f14540a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14540a.f16210e.mo2579h();
        fiq.m19373a(this.f14540a.getContext(), "UF_MenuPlayClick", this.f14540a.f16211f, this.f14540a.f16208c.mo2562c(), "menu");
    }
}
