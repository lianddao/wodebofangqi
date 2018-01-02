package com.ushareit.listenit;

import android.app.Dialog;

class dlz extends dnv {
    final /* synthetic */ Dialog f9906a;
    final /* synthetic */ dly f9907b;

    dlz(dly com_ushareit_listenit_dly, Dialog dialog) {
        this.f9907b = com_ushareit_listenit_dly;
        this.f9906a = dialog;
    }

    public void mo1955a() {
        this.f9907b.f9905a.m14801d();
        if (this.f9906a.isShowing()) {
            this.f9906a.dismiss();
        }
    }
}
