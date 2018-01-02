package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.ushareit.listenit.settings.ProductSettingsActivity;

public class gvc implements OnCheckedChangeListener {
    final /* synthetic */ ProductSettingsActivity f14791a;

    public gvc(ProductSettingsActivity productSettingsActivity) {
        this.f14791a = productSettingsActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        fan.m18726a(this.f14791a, z);
    }
}
