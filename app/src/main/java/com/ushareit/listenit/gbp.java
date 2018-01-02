package com.ushareit.listenit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class gbp implements OnClickListener {
    final /* synthetic */ gbo f13872a;

    gbp(gbo com_ushareit_listenit_gbo) {
        this.f13872a = com_ushareit_listenit_gbo;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        exw.m18443a("LOC.DefaultProvider", "User didn't want to enable GPS, so continue with Network Provider");
        this.f13872a.m21626h();
    }
}
