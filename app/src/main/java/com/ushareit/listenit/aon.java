package com.ushareit.listenit;

import android.content.Context;

class aon implements Runnable {
    final /* synthetic */ Context f5075a;
    final /* synthetic */ aom f5076b;

    aon(aom com_ushareit_listenit_aom, Context context) {
        this.f5076b = com_ushareit_listenit_aom;
        this.f5075a = context;
    }

    public void run() {
        if (aom.f5064h == null) {
            aom.f5064h = aup.m7214a(this.f5075a, this.f5075a.getPackageName());
        }
    }
}
