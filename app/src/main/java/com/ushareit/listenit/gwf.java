package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwf implements OnCheckedChangeListener {
    final /* synthetic */ UserSettingsActivity f14817a;

    public gwf(UserSettingsActivity userSettingsActivity) {
        this.f14817a = userSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        gvk.m23053c(z);
        fii.m19295a(this.f14817a, z ? "AutoMatchAlbumArtOn" : "AutoMatchAlbumArtOff");
    }
}
