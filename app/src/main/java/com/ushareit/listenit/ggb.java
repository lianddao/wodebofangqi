package com.ushareit.listenit;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class ggb implements OnCheckedChangeListener {
    final /* synthetic */ gfx f14061a;

    ggb(gfx com_ushareit_listenit_gfx) {
        this.f14061a = com_ushareit_listenit_gfx;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f14061a.ak.setInputType(128);
            this.f14061a.ak.setSelection(this.f14061a.ak.getText().length());
            return;
        }
        this.f14061a.ak.setInputType(129);
        this.f14061a.ak.setSelection(this.f14061a.ak.getText().length());
    }
}
