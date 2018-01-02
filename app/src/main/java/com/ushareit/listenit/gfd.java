package com.ushareit.listenit;

import android.widget.ProgressBar;
import com.ushareit.listenit.login.UserProfileActivity;

public class gfd implements Runnable {
    final /* synthetic */ UserProfileActivity f14021a;

    public gfd(UserProfileActivity userProfileActivity) {
        this.f14021a = userProfileActivity;
    }

    public void run() {
        int i = 98;
        this.f14021a.f15786E.setMax(100);
        int progress = this.f14021a.f15786E.getProgress() + 5;
        ProgressBar b = this.f14021a.f15786E;
        if (progress < 98) {
            i = progress;
        }
        b.setProgress(i);
        this.f14021a.f15786E.postDelayed(this.f14021a.f15801T, 500);
    }
}
