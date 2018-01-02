package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class adj implements adg {
    private final Context f4158a;
    private final adh f4159b;
    private boolean f4160c;
    private boolean f4161d;
    private final BroadcastReceiver f4162e = new adk(this);

    public adj(Context context, adh com_ushareit_listenit_adh) {
        this.f4158a = context.getApplicationContext();
        this.f4159b = com_ushareit_listenit_adh;
    }

    private void m5275a() {
        if (!this.f4161d) {
            this.f4160c = m5276a(this.f4158a);
            this.f4158a.registerReceiver(this.f4162e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4161d = true;
        }
    }

    private void m5281b() {
        if (this.f4161d) {
            this.f4158a.unregisterReceiver(this.f4162e);
            this.f4161d = false;
        }
    }

    private boolean m5276a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void mo578d() {
        m5275a();
    }

    public void mo579e() {
        m5281b();
    }

    public void mo580f() {
    }
}
