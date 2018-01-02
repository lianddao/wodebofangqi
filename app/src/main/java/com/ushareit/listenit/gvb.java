package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.ProductSettingsActivity;

public class gvb implements OnCheckedChangeListener {
    final /* synthetic */ ProductSettingsActivity f14790a;

    public gvb(ProductSettingsActivity productSettingsActivity) {
        this.f14790a = productSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            exw.m18439a(2);
        }
        gva.m22850a(this.f14790a, z);
    }
}
