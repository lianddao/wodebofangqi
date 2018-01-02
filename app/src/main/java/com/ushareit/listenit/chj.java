package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class chj implements ServiceConnection {
    final /* synthetic */ chi f8311a;

    public chj(chi com_ushareit_listenit_chi) {
        this.f8311a = com_ushareit_listenit_chi;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f8311a.f8303a.f8295a) {
            this.f8311a.f8308f = iBinder;
            this.f8311a.f8310h = componentName;
            for (ServiceConnection onServiceConnected : this.f8311a.f8305c) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f8311a.f8306d = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f8311a.f8303a.f8295a) {
            this.f8311a.f8308f = null;
            this.f8311a.f8310h = componentName;
            for (ServiceConnection onServiceDisconnected : this.f8311a.f8305c) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f8311a.f8306d = 2;
        }
    }
}
