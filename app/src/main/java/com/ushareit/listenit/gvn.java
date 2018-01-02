package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvn implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14799a;

    public gvn(UserSettingsActivity userSettingsActivity) {
        this.f14799a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvj.m22967h(this.f14799a, z);
        if (gyp.m23285b()) {
            gyp.m23288c(z);
        }
        fii.m19295a(this.f14799a, z ? "enableCrossFade" : "disableCrossFade");
    }
}
