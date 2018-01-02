package com.ushareit.listenit;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class dtt extends dul {
    private Handler f10327a;

    dtt(dsm com_ushareit_listenit_dsm, Looper looper) {
        if (looper == null) {
            cfi.m11086a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        this.f10327a = looper == null ? new dts(com_ushareit_listenit_dsm) : new dts(com_ushareit_listenit_dsm, looper);
    }

    public synchronized void m15574a() {
        this.f10327a = null;
    }

    public synchronized void mo2074a(Location location) {
        if (this.f10327a == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        } else {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f10327a.sendMessage(obtain);
        }
    }
}
