package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.settings.ProductSettingsActivity;

public class gvf implements TextWatcher {
    final /* synthetic */ ProductSettingsActivity f14794a;

    public gvf(ProductSettingsActivity productSettingsActivity) {
        this.f14794a = productSettingsActivity;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        gvj.m22901a(editable.toString());
    }
}
