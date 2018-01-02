package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwh implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14819a;

    public gwh(UserSettingsActivity userSettingsActivity) {
        this.f14819a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14819a.f16459D.setChecked(!this.f14819a.f16459D.isChecked());
    }
}
