package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.view.ScreenTimeView;

public class gdl implements erf {
    final /* synthetic */ ScreenTimeView f13957a;

    public gdl(ScreenTimeView screenTimeView) {
        this.f13957a = screenTimeView;
    }

    public void mo2279a(eqy com_ushareit_listenit_eqy) {
        float floatValue = ((Float) com_ushareit_listenit_eqy.m17399k()).floatValue();
        this.f13957a.f15721a.setTextSize(0, ((float) this.f13957a.f15726f) + (((float) (this.f13957a.f15725e - this.f13957a.f15726f)) * floatValue));
        gyn.m23237e(this.f13957a, (int) ((floatValue * ((float) (this.f13957a.f15727g - this.f13957a.f15728h))) + ((float) this.f13957a.f15728h)));
    }
}
