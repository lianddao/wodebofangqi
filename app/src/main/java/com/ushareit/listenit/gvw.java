package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvw implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14808a;

    public gvw(UserSettingsActivity userSettingsActivity) {
        this.f14808a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14808a.f16482n.setChecked(!this.f14808a.f16482n.isChecked());
    }
}
