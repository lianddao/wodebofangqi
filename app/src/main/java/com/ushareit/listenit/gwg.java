package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwg implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14818a;

    public gwg(UserSettingsActivity userSettingsActivity) {
        this.f14818a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvk.m23055d(z);
        fii.m19295a(this.f14818a, z ? "ChargingLockScreenOn" : "ChargingLockScreenOff");
    }
}
