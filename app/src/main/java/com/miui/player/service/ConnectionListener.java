package com.miui.player.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class ConnectionListener {
    private final BroadcastReceiver mConnReceiver = new C04111();
    MediaPlaybackService mServcie;

    class C04111 extends BroadcastReceiver {
        private boolean mConnectivityInit = false;

        C04111() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            MediaPlaybackService s = ConnectionListener.this.mServcie;
            if (s != null) {
                boolean connectivityInit = this.mConnectivityInit;
                this.mConnectivityInit = true;
                if (connectivityInit) {
                    if (intent.getBooleanExtra("noConnectivity", false)) {
                        z = false;
                    }
                    s.updateMetaOnConnChanged(z);
                }
            }
        }
    }

    public void registerConnReceiver(MediaPlaybackService service) {
        IntentFilter f = new IntentFilter();
        f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        service.registerReceiver(this.mConnReceiver, f);
        this.mServcie = service;
    }

    public void unregisterConnReceiver() {
        if (this.mServcie != null) {
            this.mServcie.unregisterReceiver(this.mConnReceiver);
            this.mServcie = null;
        }
    }
}
