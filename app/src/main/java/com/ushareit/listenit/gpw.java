package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpw implements OnClickListener {
    final /* synthetic */ MenuPopupView f14542a;

    public gpw(MenuPopupView menuPopupView) {
        this.f14542a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14542a.f16210e.mo2571c();
        fiq.m19373a(this.f14542a.getContext(), "UF_MenuAddToPlaylistClick", this.f14542a.f16211f, this.f14542a.f16208c.mo2562c(), "menu");
    }
}
