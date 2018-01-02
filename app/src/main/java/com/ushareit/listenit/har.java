package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

class har implements OnClickListener {
    final /* synthetic */ hap f15092a;

    har(hap com_ushareit_listenit_hap) {
        this.f15092a = com_ushareit_listenit_hap;
    }

    public void onClick(View view) {
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f15092a.o);
        confirmPopupView.m25554a().setTitle((int) C0349R.string.confirm_view_new_playlist);
        confirmPopupView.m25558g().setInputDesc("0/40");
        confirmPopupView.m25557f().setSelectDesc((int) C0349R.string.confirm_view_playlist_visibility);
        confirmPopupView.setConfirmListener(new has(this, confirmPopupView));
        fyi com_ushareit_listenit_fyi = new fyi(confirmPopupView);
        com_ushareit_listenit_fyi.m21347a(this.f15092a.f15072E);
        gyn.m23197a((ak) this.f15092a.o, com_ushareit_listenit_fyi);
        esr.m17807a(this.f15092a.o, "UF_MainMyplPopupNew");
    }
}
