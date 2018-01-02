package com.ushareit.listenit;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.ushareit.listenit.login.UserProfileActivity;

public class gey implements Runnable {
    final /* synthetic */ UserProfileActivity f14014a;

    public gey(UserProfileActivity userProfileActivity) {
        this.f14014a = userProfileActivity;
    }

    public void run() {
        Drawable b = gyn.m23207b(C0349R.drawable.user_profile_background, this.f14014a.f15790I.getWidth(), this.f14014a.f15790I.getHeight());
        if (b != null) {
            this.f14014a.f15790I.setImageDrawable(b);
        } else {
            this.f14014a.f15790I.setImageDrawable(new ColorDrawable(CtaButton.BACKGROUND_COLOR));
        }
    }
}
