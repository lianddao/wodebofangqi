package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

class dtr extends dui {
    private Handler f10325a;

    private synchronized void m15569a(int i, Object obj) {
        if (this.f10325a == null) {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        } else {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.f10325a.sendMessage(obtain);
        }
    }

    public void mo2072a(LocationAvailability locationAvailability) {
        m15569a(1, locationAvailability);
    }

    public void mo2073a(LocationResult locationResult) {
        m15569a(0, locationResult);
    }
}
