package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gwi implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14820a;

    public gwi(UserSettingsActivity userSettingsActivity) {
        this.f14820a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14820a.f16460E.setChecked(!this.f14820a.f16460E.isChecked());
    }
}
