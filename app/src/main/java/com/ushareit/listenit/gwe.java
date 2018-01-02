package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwe implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14816a;

    public gwe(UserSettingsActivity userSettingsActivity) {
        this.f14816a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14816a.f16483o.setChecked(!this.f14816a.f16483o.isChecked());
    }
}
