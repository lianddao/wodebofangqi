package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gxc implements OnClickListener {
    final /* synthetic */ ThemeSettingsActivity f14850a;

    public gxc(ThemeSettingsActivity themeSettingsActivity) {
        this.f14850a = themeSettingsActivity;
    }

    public void onClick(View view) {
        this.f14850a.m26303u();
        int intValue = ((Integer) view.getTag()).intValue();
        ((View) this.f14850a.f16607o.get(intValue)).setVisibility(0);
        this.f14850a.f16598J = ((Integer) this.f14850a.f16608p.get(intValue - 1)).intValue();
        this.f14850a.m26305w();
    }
}
