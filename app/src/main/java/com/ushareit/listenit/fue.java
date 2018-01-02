package com.ushareit.listenit;

import com.ushareit.listenit.equalizer.EqualizerActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.EqualizerPresetsPopupView;

public class fue implements hbn {
    final /* synthetic */ EqualizerActivity f13513a;

    public fue(EqualizerActivity equalizerActivity) {
        this.f13513a = equalizerActivity;
    }

    public void mo2597a(int i, boolean z) {
        if (z) {
            BasePopupView equalizerPresetsPopupView = new EqualizerPresetsPopupView(this.f13513a);
            equalizerPresetsPopupView.setOnEqualizerPresetSelectListener(new fuf(this, equalizerPresetsPopupView));
            gyn.m23197a(this.f13513a, new fyi(equalizerPresetsPopupView));
            return;
        }
        gky a = this.f13513a.f11580q.m26819a(i);
        this.f13513a.m17505a(a);
        fum.m20996a().m21020i(a.m22271b());
        this.f13513a.f11568R = a.m22271b();
        fik.m19341a(this.f13513a, "equalizer_selected", "" + this.f13513a.f11568R);
    }
}
