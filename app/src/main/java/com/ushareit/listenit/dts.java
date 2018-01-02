package com.ushareit.listenit;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class dts extends Handler {
    private final dsm f10326a;

    public dts(dsm com_ushareit_listenit_dsm) {
        this.f10326a = com_ushareit_listenit_dsm;
    }

    public dts(dsm com_ushareit_listenit_dsm, Looper looper) {
        super(looper);
        this.f10326a = com_ushareit_listenit_dsm;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f10326a.mo2642a(new Location((Location) message.obj));
                return;
            default:
                Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                return;
        }
    }
}
