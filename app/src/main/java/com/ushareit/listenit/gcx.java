package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.lockscreen.MusicLockScreenView;

public class gcx extends qe {
    final /* synthetic */ MusicLockScreenView f13931a;

    private gcx(MusicLockScreenView musicLockScreenView) {
        this.f13931a = musicLockScreenView;
    }

    public boolean mo2646a(View view, int i) {
        return view == this.f13931a.f15659a;
    }

    public int mo2644a(View view, int i, int i2) {
        return i > 0 ? i : 0;
    }

    public void mo2645a(View view, float f, float f2) {
        if (((double) view.getLeft()) > ((double) this.f13931a.f15644C) * 0.3d) {
            this.f13931a.f15678t.m25689a(this.f13931a.f15644C, 0);
            this.f13931a.f15643B = 2;
        } else {
            this.f13931a.f15678t.m25689a(0, 0);
            this.f13931a.f15643B = 1;
        }
        this.f13931a.invalidate();
    }
}
