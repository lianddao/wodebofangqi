package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcu implements OnClickListener {
    final /* synthetic */ MusicLockScreenView f13928a;

    public gcu(MusicLockScreenView musicLockScreenView) {
        this.f13928a = musicLockScreenView;
    }

    public void onClick(View view) {
        if (this.f13928a.f15681w != null) {
            boolean z;
            if (this.f13928a.f15681w.mo2453j()) {
                z = false;
            } else {
                z = true;
            }
            this.f13928a.f15681w.mo2436b(z);
            this.f13928a.f15667i.setImageDrawable(this.f13928a.m24493a(z));
            heb.m23596a(this.f13928a.m24498b(z), 0).show();
            fit.m19438f(this.f13928a.getContext(), "lockscreen");
        }
    }
}
