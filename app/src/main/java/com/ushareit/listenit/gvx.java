package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvx implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14809a;

    public gvx(UserSettingsActivity userSettingsActivity) {
        this.f14809a = userSettingsActivity;
    }

    public void onClick(View view) {
        this.f14809a.f16458C.setChecked(!this.f14809a.f16458C.isChecked());
    }
}
