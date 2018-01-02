package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcw extends fjw {
    final /* synthetic */ MusicLockScreenView f13930a;

    public gcw(MusicLockScreenView musicLockScreenView) {
        this.f13930a = musicLockScreenView;
    }

    public void mo2389a(View view) {
        if (this.f13930a.f15681w != null && this.f13930a.f15681w.mo2462s() != 0) {
            if (this.f13930a.f15681w.mo2425a()) {
                fim.m19346a(this.f13930a.getContext(), "pause");
            } else {
                fim.m19346a(this.f13930a.getContext(), "play");
            }
            this.f13930a.f15681w.mo2442d();
        }
    }
}
