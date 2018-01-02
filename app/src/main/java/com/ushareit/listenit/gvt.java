package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvt implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14805a;

    public gvt(UserSettingsActivity userSettingsActivity) {
        this.f14805a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvj.m22992k(this.f14805a, z);
        fii.m19295a(this.f14805a, z ? "enableReplay" : "disableReplay");
    }
}
