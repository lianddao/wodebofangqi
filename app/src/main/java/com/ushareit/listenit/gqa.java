package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gqa implements OnClickListener {
    final /* synthetic */ MenuPopupView f14546a;

    public gqa(MenuPopupView menuPopupView) {
        this.f14546a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14546a.f16210e.mo2573e();
        fiq.m19373a(this.f14546a.getContext(), "UF_MenuEditId3TagClick", this.f14546a.f16211f, this.f14546a.f16208c.mo2562c(), "menu");
    }
}
