package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class akm extends BroadcastReceiver {
    final /* synthetic */ ajx f4597a;

    private akm(ajx com_ushareit_listenit_ajx) {
        this.f4597a = com_ushareit_listenit_ajx;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            this.f4597a.m5865o();
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            this.f4597a.m5863n();
        }
    }
}
