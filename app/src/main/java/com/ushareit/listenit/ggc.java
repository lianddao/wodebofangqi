package com.ushareit.listenit;

import android.text.Editable;
import android.text.TextWatcher;

class ggc implements TextWatcher {
    final /* synthetic */ gfx f14062a;

    ggc(gfx com_ushareit_listenit_gfx) {
        this.f14062a = com_ushareit_listenit_gfx;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f14062a.f14057i.m21919a(charSequence.toString())) {
            this.f14062a.aa();
        } else {
            this.f14062a.m21902Z();
        }
    }

    public void afterTextChanged(Editable editable) {
    }
}
