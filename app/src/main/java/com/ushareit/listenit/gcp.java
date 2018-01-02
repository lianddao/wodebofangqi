package com.ushareit.listenit;

import android.graphics.drawable.AnimationDrawable;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcp implements Runnable {
    final /* synthetic */ MusicLockScreenView f13921a;

    public gcp(MusicLockScreenView musicLockScreenView) {
        this.f13921a = musicLockScreenView;
    }

    public void run() {
        this.f13921a.f15680v = (AnimationDrawable) this.f13921a.getResources().getDrawable(C0349R.drawable.lock_arrow_flicker);
        this.f13921a.f15669k.setImageDrawable(this.f13921a.f15680v);
        this.f13921a.f15680v.start();
    }
}
