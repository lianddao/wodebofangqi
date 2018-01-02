package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvm implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14798a;

    public gvm(UserSettingsActivity userSettingsActivity) {
        this.f14798a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14798a.f16462G.setChecked(!this.f14798a.f16462G.isChecked());
    }
}
