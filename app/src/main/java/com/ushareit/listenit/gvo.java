package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvo implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14800a;

    public gvo(UserSettingsActivity userSettingsActivity) {
        this.f14800a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14800a.f16489y.setChecked(!this.f14800a.f16489y.isChecked());
    }
}
