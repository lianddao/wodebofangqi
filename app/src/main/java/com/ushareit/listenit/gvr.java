package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvr implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14803a;

    public gvr(UserSettingsActivity userSettingsActivity) {
        this.f14803a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvj.m22982j(this.f14803a, z);
        if (this.f14803a.w != null) {
            this.f14803a.w.mo2446e(z);
        }
        fii.m19295a(this.f14803a, z ? "enableCutSilence" : "disableCutSilence");
    }
}
