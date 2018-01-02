package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.MenuPopupView;

public class gps implements OnClickListener {
    final /* synthetic */ MenuPopupView f14538a;

    public gps(MenuPopupView menuPopupView) {
        this.f14538a = menuPopupView;
    }

    public void onClick(View view) {
        this.f14538a.f16210e.mo2574f();
        fiq.m19373a(this.f14538a.getContext(), "UF_MenuEditLyric", this.f14538a.f16211f, this.f14538a.f16208c.mo2562c(), "menu");
        fin.m19355c(this.f14538a.getContext(), "song_item_menu");
    }
}
