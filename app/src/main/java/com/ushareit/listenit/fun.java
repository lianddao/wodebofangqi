package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public class fun extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (VERSION.SDK_INT < 19) {
            return;
        }
        if ((context != null || intent != null) && !fbb.m18763c(intent.getAction()) && intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            fus.m21033b(context, m21022a(context));
            fii.m19285a();
        }
    }

    private static gum m21022a(Context context) {
        return ((ListenItApp) context.getApplicationContext()).m4930a();
    }
}
