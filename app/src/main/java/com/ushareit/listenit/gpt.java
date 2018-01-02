package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpt implements OnClickListener {
    final /* synthetic */ MenuPopupView f14539a;

    public gpt(MenuPopupView menuPopupView) {
        this.f14539a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14539a.f16210e.mo2572d();
        fii.m19321g(this.f14539a.getContext(), "menu");
        fiq.m19373a(this.f14539a.getContext(), "UF_MenuAddToFavorite", this.f14539a.f16211f, this.f14539a.f16208c.mo2562c(), "menu");
    }
}
