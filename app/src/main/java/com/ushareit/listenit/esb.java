package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class esb extends BroadcastReceiver {
    final /* synthetic */ esa f11674a;

    esb(esa com_ushareit_listenit_esa) {
        this.f11674a = com_ushareit_listenit_esa;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            faq.m18735a(new esc(this));
        }
    }
}
