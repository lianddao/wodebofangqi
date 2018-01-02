package com.ushareit.listenit;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.ushareit.listenit.login.LoginActivity;

public class gdw implements Runnable {
    final /* synthetic */ LoginActivity f13976a;

    public gdw(LoginActivity loginActivity) {
        this.f13976a = loginActivity;
    }

    public void run() {
        Drawable b = gyn.m23207b(C0349R.drawable.login_background, this.f13976a.f15763E.getWidth() != 0 ? this.f13976a.f15763E.getWidth() : 480, this.f13976a.f15763E.getHeight() != 0 ? this.f13976a.f15763E.getHeight() : 720);
        if (b != null) {
            this.f13976a.f15763E.setImageDrawable(b);
        } else {
            this.f13976a.f15763E.setImageDrawable(new ColorDrawable(CtaButton.BACKGROUND_COLOR));
        }
    }
}
