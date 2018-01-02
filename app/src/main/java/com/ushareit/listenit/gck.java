package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gck implements OnClickListener {
    final /* synthetic */ MusicLockScreenView f13916a;

    public gck(MusicLockScreenView musicLockScreenView) {
        this.f13916a = musicLockScreenView;
    }

    public void onClick(View view) {
        if (this.f13916a.f15681w != null) {
            this.f13916a.f15681w.mo2424a(gvj.aj(this.f13916a.getContext()));
            this.f13916a.f15642A = false;
            fii.m19311c(this.f13916a.getContext(), "lockscreen");
            fim.m19346a(this.f13916a.getContext(), "prev");
        }
    }
}
