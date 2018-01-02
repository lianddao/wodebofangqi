package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvs implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14804a;

    public gvs(UserSettingsActivity userSettingsActivity) {
        this.f14804a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14804a.f16456A.setChecked(!this.f14804a.f16456A.isChecked());
    }
}
