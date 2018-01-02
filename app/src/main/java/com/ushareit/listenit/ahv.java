package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.AccessToken;
import com.facebook.internal.cj;

public abstract class ahv {
    private final BroadcastReceiver f4396a;
    private final ec f4397b;
    private boolean f4398c = false;

    protected abstract void mo821a(AccessToken accessToken, AccessToken accessToken2);

    public ahv() {
        cj.m1643b();
        this.f4396a = new ahx();
        this.f4397b = ec.m16689a(ail.m5715f());
        m5674a();
    }

    public void m5674a() {
        if (!this.f4398c) {
            m5673d();
            this.f4398c = true;
        }
    }

    public void m5676b() {
        if (this.f4398c) {
            this.f4397b.m16692a(this.f4396a);
            this.f4398c = false;
        }
    }

    public boolean m5677c() {
        return this.f4398c;
    }

    private void m5673d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.f4397b.m16693a(this.f4396a, intentFilter);
    }
}
