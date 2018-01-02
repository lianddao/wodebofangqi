package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.AddToPlaylistPopupView;
import com.ushareit.listenit.popupview.BasePopupView;

class fwl implements OnClickListener {
    final /* synthetic */ fwf f13628a;

    fwl(fwf com_ushareit_listenit_fwf) {
        this.f13628a = com_ushareit_listenit_fwf;
    }

    public void onClick(View view) {
        BasePopupView addToPlaylistPopupView = new AddToPlaylistPopupView(this.f13628a.m1326l(), this.f13628a.ao.mo2565a(), gyn.m23181a(this.f13628a.ao.mo2565a()) + (this.f13628a.f13620h != null ? "_recom" : "_btn"));
        addToPlaylistPopupView.setItem(this.f13628a.ao.m20816e());
        addToPlaylistPopupView.setItems(this.f13628a.ao.mo2568d());
        addToPlaylistPopupView.setSaveListener(new fwm(this));
        gyn.m23197a((ak) this.f13628a.m1326l(), new fyi(addToPlaylistPopupView));
    }
}
