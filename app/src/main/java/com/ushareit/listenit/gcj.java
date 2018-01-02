package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcj implements OnClickListener {
    final /* synthetic */ MusicLockScreenView f13915a;

    public gcj(MusicLockScreenView musicLockScreenView) {
        this.f13915a = musicLockScreenView;
    }

    public void onClick(View view) {
        if (this.f13915a.f15681w != null) {
            this.f13915a.f15681w.mo2451h();
            this.f13915a.f15642A = true;
            fii.m19311c(this.f13915a.getContext(), "lockscreen");
            fim.m19346a(this.f13915a.getContext(), "next");
        }
    }
}
