package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvp implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14801a;

    public gvp(UserSettingsActivity userSettingsActivity) {
        this.f14801a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvj.m22975i(this.f14801a, z);
        if (gyp.m23285b()) {
            gyp.m23290d(z);
        }
        fii.m19295a(this.f14801a, z ? "enableFade" : "disableFade");
    }
}
