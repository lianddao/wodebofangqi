package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(24)
class eak extends BroadcastReceiver {
    private static AtomicReference<eak> f10772a = new AtomicReference();
    private final Context f10773b;

    public eak(Context context) {
        this.f10773b = context;
    }

    private static void m16629b(Context context) {
        if (f10772a.get() == null) {
            BroadcastReceiver com_ushareit_listenit_eak = new eak(context);
            if (f10772a.compareAndSet(null, com_ushareit_listenit_eak)) {
                IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_UNLOCKED");
                intentFilter.addDataScheme("package");
                context.registerReceiver(com_ushareit_listenit_eak, intentFilter);
            }
        }
    }

    public void m16630a() {
        this.f10773b.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        synchronized (eah.f10762g) {
            for (eah a : eah.f10756a.values()) {
                a.m16617j();
            }
        }
        m16630a();
    }
}
