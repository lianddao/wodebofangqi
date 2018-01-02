package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpv implements OnClickListener {
    final /* synthetic */ MenuPopupView f14541a;

    public gpv(MenuPopupView menuPopupView) {
        this.f14541a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14541a.f16210e.mo2570b();
        fiq.m19373a(this.f14541a.getContext(), "UF_MenuPlayNextClick", this.f14541a.f16211f, this.f14541a.f16208c.mo2562c(), "menu");
    }
}
