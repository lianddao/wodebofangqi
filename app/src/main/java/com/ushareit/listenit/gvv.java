package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvv implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14807a;

    public gvv(UserSettingsActivity userSettingsActivity) {
        this.f14807a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvj.m23000l(this.f14807a, z);
        if (this.f14807a.w != null) {
            this.f14807a.w.mo2449f(z);
        }
        fii.m19295a(this.f14807a, z ? "enableAudioFocus" : "disableAudioFocus");
    }
}
