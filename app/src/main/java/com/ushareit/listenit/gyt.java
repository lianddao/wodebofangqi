package com.ushareit.listenit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class gyt implements ServiceConnection {
    gyt() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        exw.m18443a("UI.ServiceFactory", "onServiceConnected()");
        gys.m23315b((gum) iBinder);
        gys.m23316c();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        exw.m18443a("UI.ServiceFactory", "onServiceDisconnected()");
        gys.m23315b(null);
    }
}
