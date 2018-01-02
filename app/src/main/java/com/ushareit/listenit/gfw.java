package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;

class gfw implements TextWatcher {
    final /* synthetic */ gfr f14051a;

    gfw(gfr com_ushareit_listenit_gfr) {
        this.f14051a = com_ushareit_listenit_gfr;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f14051a.f14044g.m21922b(charSequence.toString(), this.f14051a.f14045h);
    }

    public void afterTextChanged(Editable editable) {
    }
}
