package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.popupview.ConfirmPopupView;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwa extends gee {
    final /* synthetic */ UserSettingsActivity f14812a;

    public gwa(UserSettingsActivity userSettingsActivity) {
        this.f14812a = userSettingsActivity;
    }

    public void mo2664b(View view) {
        ak akVar = this.f14812a;
        this.f14812a.f16461F = new ConfirmPopupView(akVar);
        this.f14812a.f16461F.m25556d().setContent((int) C0349R.string.logout_dialog_content);
        this.f14812a.f16461F.setConfirmListener(new gwb(this));
        gyn.m23197a(akVar, new fyi(this.f14812a.f16461F));
    }
}
