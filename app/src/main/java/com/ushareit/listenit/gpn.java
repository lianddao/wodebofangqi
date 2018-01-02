package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpn implements OnClickListener {
    final /* synthetic */ MenuPopupView f14533a;

    public gpn(MenuPopupView menuPopupView) {
        this.f14533a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14533a.f16210e.mo2699p();
        fiq.m19373a(this.f14533a.getContext(), "UF_MenuDisappearClick", this.f14533a.f16211f, this.f14533a.f16208c.mo2562c(), "menu");
    }
}
