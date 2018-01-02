package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwd implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14815a;

    public gwd(UserSettingsActivity userSettingsActivity) {
        this.f14815a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvk.m23051b(z);
        fii.m19295a(this.f14815a, z ? "AutoScanFilterOn" : "AutoScanFilterOff");
    }
}
