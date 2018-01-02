package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class adk extends BroadcastReceiver {
    final /* synthetic */ adj f4163a;

    adk(adj com_ushareit_listenit_adj) {
        this.f4163a = com_ushareit_listenit_adj;
    }

    public void onReceive(Context context, Intent intent) {
        boolean a = this.f4163a.f4160c;
        this.f4163a.f4160c = this.f4163a.m5276a(context);
        if (a != this.f4163a.f4160c) {
            this.f4163a.f4159b.mo3089a(this.f4163a.f4160c);
        }
    }
}
