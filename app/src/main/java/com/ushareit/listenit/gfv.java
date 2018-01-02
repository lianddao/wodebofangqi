package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class gfv implements OnCheckedChangeListener {
    final /* synthetic */ gfr f14050a;

    gfv(gfr com_ushareit_listenit_gfr) {
        this.f14050a = com_ushareit_listenit_gfr;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f14050a.f14043f.setInputType(128);
            this.f14050a.f14043f.setSelection(this.f14050a.f14043f.getText().length());
            return;
        }
        this.f14050a.f14043f.setInputType(129);
        this.f14050a.f14043f.setSelection(this.f14050a.f14043f.getText().length());
    }
}
