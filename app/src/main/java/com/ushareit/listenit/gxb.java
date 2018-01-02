package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gxb implements OnClickListener {
    final /* synthetic */ ThemeSettingsActivity f14849a;

    public gxb(ThemeSettingsActivity themeSettingsActivity) {
        this.f14849a = themeSettingsActivity;
    }

    public void onClick(View view) {
        this.f14849a.m26303u();
        ((View) this.f14849a.f16607o.get(0)).setVisibility(0);
        this.f14849a.f16598J = this.f14849a.getResources().getColor(C0349R.color.common_actionbar_color);
        this.f14849a.m26305w();
    }
}
