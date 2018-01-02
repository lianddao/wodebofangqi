package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;

class gtr implements TextWatcher {
    final /* synthetic */ gta f14716a;

    gtr(gta com_ushareit_listenit_gta) {
        this.f14716a = com_ushareit_listenit_gta;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f14716a.m22747c(charSequence.toString());
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
