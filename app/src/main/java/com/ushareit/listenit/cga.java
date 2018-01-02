package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class cga implements ServiceConnection {
    final /* synthetic */ cfs f8231a;
    private final int f8232b;

    public cga(cfs com_ushareit_listenit_cfs, int i) {
        this.f8231a = com_ushareit_listenit_cfs;
        this.f8232b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cfi.m11081a((Object) iBinder, (Object) "Expecting a valid IBinder");
        synchronized (this.f8231a.f8059n) {
            this.f8231a.f8060o = chw.m11302a(iBinder);
        }
        this.f8231a.m10608a(0, null, this.f8232b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f8231a.f8059n) {
            this.f8231a.f8060o = null;
        }
        this.f8231a.f8047a.sendMessage(this.f8231a.f8047a.obtainMessage(4, this.f8232b, 1));
    }
}
