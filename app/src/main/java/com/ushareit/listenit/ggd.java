package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;

class ggd implements TextWatcher {
    final /* synthetic */ gfx f14063a;

    ggd(gfx com_ushareit_listenit_gfx) {
        this.f14063a = com_ushareit_listenit_gfx;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f14063a.f14057i.m21920a(charSequence.toString(), this.f14063a.f14055g);
    }

    public void afterTextChanged(Editable editable) {
    }
}
