package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.MenuPopupView;

class fon implements OnClickListener {
    final /* synthetic */ gkx f13110a;
    final /* synthetic */ fom f13111b;

    fon(fom com_ushareit_listenit_fom, gkx com_ushareit_listenit_gkx) {
        this.f13111b = com_ushareit_listenit_fom;
        this.f13110a = com_ushareit_listenit_gkx;
    }

    public void onClick(View view) {
        BasePopupView menuPopupView = new MenuPopupView(this.f13111b.f13109f.f13101a, new gjw(14), this.f13110a);
        menuPopupView.setTitle(this.f13110a.mo2562c());
        fyi com_ushareit_listenit_fyi = new fyi(menuPopupView);
        com_ushareit_listenit_fyi.m21347a(new foo(this));
        gyn.m23197a(this.f13111b.f13109f.f13101a, com_ushareit_listenit_fyi);
    }
}
