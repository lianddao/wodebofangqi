package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class dnu extends BroadcastReceiver {
    protected Context f10066a;
    private final dnv f10067b;

    public dnu(dnv com_ushareit_listenit_dnv) {
        this.f10067b = com_ushareit_listenit_dnv;
    }

    public synchronized void m15137a() {
        if (this.f10066a != null) {
            this.f10066a.unregisterReceiver(this);
        }
        this.f10066a = null;
    }

    public void m15138a(Context context) {
        this.f10066a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f10067b.mo1955a();
            m15137a();
        }
    }
}
