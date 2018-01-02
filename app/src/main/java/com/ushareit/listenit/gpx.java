package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gpx implements OnClickListener {
    final /* synthetic */ MenuPopupView f14543a;

    public gpx(MenuPopupView menuPopupView) {
        this.f14543a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14543a.f16210e.mo2693i();
        fiq.m19373a(this.f14543a.getContext(), "UF_MenuChangeAlbumArtClick", this.f14543a.f16211f, this.f14543a.f16208c.mo2562c(), "menu");
    }
}
