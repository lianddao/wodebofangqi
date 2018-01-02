package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpz implements OnClickListener {
    final /* synthetic */ MenuPopupView f14545a;

    public gpz(MenuPopupView menuPopupView) {
        this.f14545a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14545a.f16210e.mo2700z();
        fiq.m19373a(this.f14545a.getContext(), "UF_MenuRenameClick", this.f14545a.f16211f, this.f14545a.f16208c.mo2562c(), "menu");
    }
}
