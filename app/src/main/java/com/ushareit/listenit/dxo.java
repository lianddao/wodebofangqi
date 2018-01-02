package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class dxo extends BroadcastReceiver {
    static final String f10581a = dxo.class.getName();
    private final dyf f10582b;
    private boolean f10583c;
    private boolean f10584d;

    dxo(dyf com_ushareit_listenit_dyf) {
        cfi.m11080a((Object) com_ushareit_listenit_dyf);
        this.f10582b = com_ushareit_listenit_dyf;
    }

    private Context m16296d() {
        return this.f10582b.m16467r();
    }

    private dxg m16297e() {
        return this.f10582b.m16455f();
    }

    public void m16298a() {
        this.f10582b.m16432a();
        this.f10582b.m16475z();
        if (!this.f10583c) {
            m16296d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f10584d = this.f10582b.m16466q().m16274f();
            m16297e().m16235E().m16264a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f10584d));
            this.f10583c = true;
        }
    }

    public void m16299b() {
        this.f10582b.m16432a();
        this.f10582b.m16475z();
        if (m16300c()) {
            m16297e().m16235E().m16263a("Unregistering connectivity change receiver");
            this.f10583c = false;
            this.f10584d = false;
            try {
                m16296d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m16297e().m16242f().m16264a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean m16300c() {
        this.f10582b.m16475z();
        return this.f10583c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f10582b.m16432a();
        String action = intent.getAction();
        m16297e().m16235E().m16264a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = this.f10582b.m16466q().m16274f();
            if (this.f10584d != f) {
                this.f10584d = f;
                this.f10582b.m16457h().m16380a(new dxp(this, f));
                return;
            }
            return;
        }
        m16297e().m16262z().m16264a("NetworkBroadcastReceiver received unknown action", action);
    }
}
