package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ushareit.listenit.main.MainActivity;

public class giu extends BroadcastReceiver {
    final /* synthetic */ MainActivity f14179a;

    public giu(MainActivity mainActivity) {
        this.f14179a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            hhx.m23867a(new giv(this));
        }
    }
}
