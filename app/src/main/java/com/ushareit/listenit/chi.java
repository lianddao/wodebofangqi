package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class chi {
    final /* synthetic */ chg f8303a;
    private final chj f8304b = new chj(this);
    private final Set<ServiceConnection> f8305c = new HashSet();
    private int f8306d = 2;
    private boolean f8307e;
    private IBinder f8308f;
    private final chh f8309g;
    private ComponentName f8310h;

    public chi(chg com_ushareit_listenit_chg, chh com_ushareit_listenit_chh) {
        this.f8303a = com_ushareit_listenit_chg;
        this.f8309g = com_ushareit_listenit_chh;
    }

    public void m11237a(ServiceConnection serviceConnection, String str) {
        this.f8303a.f8298d.m11376a(this.f8303a.f8296b, serviceConnection, str, this.f8309g.m11231a());
        this.f8305c.add(serviceConnection);
    }

    @TargetApi(14)
    public void m11238a(String str) {
        this.f8306d = 3;
        this.f8307e = this.f8303a.f8298d.m11378a(this.f8303a.f8296b, str, this.f8309g.m11231a(), this.f8304b, 129);
        if (!this.f8307e) {
            this.f8306d = 2;
            try {
                this.f8303a.f8298d.m11375a(this.f8303a.f8296b, this.f8304b);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public boolean m11239a() {
        return this.f8307e;
    }

    public boolean m11240a(ServiceConnection serviceConnection) {
        return this.f8305c.contains(serviceConnection);
    }

    public int m11241b() {
        return this.f8306d;
    }

    public void m11242b(ServiceConnection serviceConnection, String str) {
        this.f8303a.f8298d.m11379b(this.f8303a.f8296b, serviceConnection);
        this.f8305c.remove(serviceConnection);
    }

    public void m11243b(String str) {
        this.f8303a.f8298d.m11375a(this.f8303a.f8296b, this.f8304b);
        this.f8307e = false;
        this.f8306d = 2;
    }

    public boolean m11244c() {
        return this.f8305c.isEmpty();
    }

    public IBinder m11245d() {
        return this.f8308f;
    }

    public ComponentName m11246e() {
        return this.f8310h;
    }
}
