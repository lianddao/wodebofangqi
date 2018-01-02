package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ett extends BroadcastReceiver {
    final /* synthetic */ ets f11845a;

    ett(ets com_ushareit_listenit_ets) {
        this.f11845a = com_ushareit_listenit_ets;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.f11845a.m17955a(eua.CONNECTED);
        }
    }
}
