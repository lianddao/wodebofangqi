package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvu implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14806a;

    public gvu(UserSettingsActivity userSettingsActivity) {
        this.f14806a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14806a.f16457B.setChecked(!this.f14806a.f16457B.isChecked());
    }
}
