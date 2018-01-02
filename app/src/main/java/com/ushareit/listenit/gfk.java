package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.login.UserProfileActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class gfk extends gee {
    final /* synthetic */ UserProfileActivity f14028a;

    public gfk(UserProfileActivity userProfileActivity) {
        this.f14028a = userProfileActivity;
    }

    public void mo2664b(View view) {
        BasePopupView confirmPopupView = new ConfirmPopupView(this.f14028a);
        confirmPopupView.m25554a().setTitle((int) C0349R.string.profile_edit_name_title);
        confirmPopupView.m25558g().setInputDesc("0/40");
        confirmPopupView.setHint("");
        confirmPopupView.setEditText(this.f14028a.f15804p.getText().toString());
        confirmPopupView.setConfirmListener(new gfl(this, confirmPopupView));
        gyn.m23197a(this.f14028a, new fyi(confirmPopupView));
    }
}
