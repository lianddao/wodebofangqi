package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvq implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14802a;

    public gvq(UserSettingsActivity userSettingsActivity) {
        this.f14802a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14802a.f16490z.setChecked(!this.f14802a.f16490z.isChecked());
    }
}
