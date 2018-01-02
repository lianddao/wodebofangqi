package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.login.UserProfileActivity;
import com.ushareit.listenit.popupview.EditUserPhotoPopupView;

public class gfm implements OnClickListener {
    final /* synthetic */ UserProfileActivity f14031a;

    public gfm(UserProfileActivity userProfileActivity) {
        this.f14031a = userProfileActivity;
    }

    public void onClick(View view) {
        gyn.m23197a(this.f14031a, new fyi(new EditUserPhotoPopupView(this.f14031a, this.f14031a.f15796O)));
    }
}
