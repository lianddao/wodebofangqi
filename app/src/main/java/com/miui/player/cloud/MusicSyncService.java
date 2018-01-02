package com.miui.player.cloud;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MusicSyncService extends Service {
    private static MusicSyncAdapter sSyncAdapter = null;
    private static final Object sSyncAdapterLock = new Object();

    public void onCreate() {
        super.onCreate();
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = new MusicSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
