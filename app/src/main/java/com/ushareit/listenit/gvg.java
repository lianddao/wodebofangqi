package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;
import com.ushareit.listenit.settings.ProductSettingsActivity;

public class gvg implements TextWatcher {
    final /* synthetic */ ProductSettingsActivity f14795a;

    public gvg(ProductSettingsActivity productSettingsActivity) {
        this.f14795a = productSettingsActivity;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        gvj.m22913b(editable.toString());
    }
}
