package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcr implements erf {
    final /* synthetic */ int f13923a;
    final /* synthetic */ int f13924b;
    final /* synthetic */ MusicLockScreenView f13925c;

    public gcr(MusicLockScreenView musicLockScreenView, int i, int i2) {
        this.f13925c = musicLockScreenView;
        this.f13923a = i;
        this.f13924b = i2;
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        Float f = (Float) com_ushareit_listenit_eqy.m17399k();
        erj.m17574e(this.f13925c.f15664f, (-f.floatValue()) * ((float) this.f13923a));
        erj.m17574e(this.f13925c.f15676r.f12584b, (-f.floatValue()) * ((float) this.f13923a));
        erj.m17574e(this.f13925c.f15665g, (((float) this.f13924b) - f.floatValue()) * ((float) this.f13923a));
    }
}
