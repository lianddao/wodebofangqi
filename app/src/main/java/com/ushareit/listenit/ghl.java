package com.ushareit.listenit;

import com.ushareit.listenit.lyrics.LyricEditorActivity;
import com.ushareit.listenit.popupview.ConfirmPopupView;

public class ghl extends hib {
    final /* synthetic */ ConfirmPopupView f14125a;
    final /* synthetic */ LyricEditorActivity f14126b;

    public ghl(LyricEditorActivity lyricEditorActivity, ConfirmPopupView confirmPopupView) {
        this.f14126b = lyricEditorActivity;
        this.f14125a = confirmPopupView;
    }

    public void callback() {
        if (this.f14126b.f15856n.m23325a()) {
            this.f14126b.f15856n;
            gyw.m23323b(this.f14126b, this.f14126b.f15834E.getEditText());
        }
        gyn.m23197a(this.f14126b, new fyi(this.f14125a));
    }
}
