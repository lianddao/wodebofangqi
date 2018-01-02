package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcv implements OnClickListener {
    final /* synthetic */ MusicLockScreenView f13929a;

    public gcv(MusicLockScreenView musicLockScreenView) {
        this.f13929a = musicLockScreenView;
    }

    public void onClick(View view) {
        if (this.f13929a.f15681w != null) {
            if (this.f13929a.f15668j.getTag() == null || this.f13929a.f15668j.getTag() != Boolean.TRUE) {
                this.f13929a.f15668j.setImageResource(C0349R.drawable.player_like_it);
                this.f13929a.f15668j.setTag(Boolean.TRUE);
                fre.m20626a(this.f13929a.f15681w.mo2465v(), true);
                fit.m19430a(this.f13929a.getContext(), "like", this.f13929a.f15681w.mo2465v());
                fim.m19346a(this.f13929a.getContext(), "like");
            } else {
                this.f13929a.f15668j.setImageResource(C0349R.drawable.player_unlike_it);
                this.f13929a.f15668j.setTag(null);
                fre.m20626a(this.f13929a.f15681w.mo2465v(), false);
                fit.m19430a(this.f13929a.getContext(), "unlike", this.f13929a.f15681w.mo2465v());
                fim.m19346a(this.f13929a.getContext(), "unlike");
            }
            fii.m19321g(this.f13929a.getContext(), "lockScreen");
        }
    }
}
