package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpm implements OnClickListener {
    final /* synthetic */ MenuPopupView f14532a;

    public gpm(MenuPopupView menuPopupView) {
        this.f14532a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14532a.f16210e.mo2698o();
        fiq.m19373a(this.f14532a.getContext(), "UF_MenuDownloadClick", this.f14532a.f16211f, this.f14532a.f16208c.mo2562c(), "menu");
    }
}
