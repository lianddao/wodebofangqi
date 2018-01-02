package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gci implements Runnable {
    final /* synthetic */ MusicLockScreenView f13914a;

    public gci(MusicLockScreenView musicLockScreenView) {
        this.f13914a = musicLockScreenView;
    }

    public void run() {
        int measuredHeight = this.f13914a.f15660b.getMeasuredHeight() - (this.f13914a.getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_30dp) * 2);
        int c = fbb.m18762c(this.f13914a.getContext()) - (this.f13914a.getResources().getDimensionPixelOffset(C0349R.dimen.common_dimens_30dp) * 2);
        if (measuredHeight >= c) {
            measuredHeight = c;
        }
        gyn.m23192a(this.f13914a.f15664f, measuredHeight);
        gyn.m23192a(this.f13914a.f15665g, measuredHeight);
        gyn.m23192a(this.f13914a.f15676r.f12584b, measuredHeight);
    }
}
