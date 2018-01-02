package com.ushareit.listenit;

import com.ushareit.listenit.login.UserProfileActivity;

public class gff extends hib {
    final /* synthetic */ UserProfileActivity f14023a;

    public gff(UserProfileActivity userProfileActivity) {
        this.f14023a = userProfileActivity;
    }

    public void callback() {
        if (this.f14023a.f15786E.getProgress() == this.f14023a.f15786E.getMax()) {
            this.f14023a.f15786E.setProgress(0);
        }
    }
}
