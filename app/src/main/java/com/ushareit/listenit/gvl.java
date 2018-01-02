package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvl implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14797a;

    public gvl(UserSettingsActivity userSettingsActivity) {
        this.f14797a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvk.m23049a(z);
        fii.m19295a(this.f14797a, z ? "AutoPlayMusicOn" : "AutoPlayMusicOff");
    }
}
