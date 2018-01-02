package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwj implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14821a;

    public gwj(UserSettingsActivity userSettingsActivity) {
        this.f14821a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = !z;
        gvk.m23056e(z2);
        if (z2) {
            fus.m21028a(this.f14821a, this.f14821a.m4860n());
        }
        fii.m19295a(this.f14821a, z2 ? "VolumeBoosterOn" : "VolumeBoosterOff");
    }
}
