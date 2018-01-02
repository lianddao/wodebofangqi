package com.ushareit.listenit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class gbq implements OnClickListener {
    final /* synthetic */ gbo f13873a;

    gbq(gbo com_ushareit_listenit_gbo) {
        this.f13873a = com_ushareit_listenit_gbo;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13873a.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 259);
    }
}
