package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.view.ScreenTimeView;

public class gdk implements erf {
    final /* synthetic */ ScreenTimeView f13956a;

    public gdk(ScreenTimeView screenTimeView) {
        this.f13956a = screenTimeView;
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float floatValue = ((Float) com_ushareit_listenit_eqy.m17399k()).floatValue();
        this.f13956a.f15721a.setTextSize(0, ((float) this.f13956a.f15726f) + (((float) (this.f13956a.f15725e - this.f13956a.f15726f)) * floatValue));
        gyn.m23237e(this.f13956a, (int) ((floatValue * ((float) (this.f13956a.f15727g - this.f13956a.f15728h))) + ((float) this.f13956a.f15728h)));
    }
}
