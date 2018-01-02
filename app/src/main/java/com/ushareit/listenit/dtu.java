package com.ushareit.listenit;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

public class dtu extends dsu {
    private final dtq f10328e;

    public dtu(Context context, Looper looper, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec, String str, cgs com_ushareit_listenit_cgs) {
        super(context, looper, com_ushareit_listenit_ceb, com_ushareit_listenit_cec, str, com_ushareit_listenit_cgs);
        this.f10328e = new dtq(context, this.d);
    }

    public void m15576a(LocationRequest locationRequest, dsm com_ushareit_listenit_dsm, Looper looper, dte com_ushareit_listenit_dte) {
        synchronized (this.f10328e) {
            this.f10328e.m15560a(locationRequest, com_ushareit_listenit_dsm, looper, com_ushareit_listenit_dte);
        }
    }

    public void m15577a(LocationSettingsRequest locationSettingsRequest, dlv<LocationSettingsResult> com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult, String str) {
        boolean z = true;
        m10633s();
        cfi.m11090b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult == null) {
            z = false;
        }
        cfi.m11090b(z, "listener can't be null.");
        ((dtk) m10635u()).mo2052a(locationSettingsRequest, new dtv(com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public void m15578a(dsm com_ushareit_listenit_dsm, dte com_ushareit_listenit_dte) {
        this.f10328e.m15561a(com_ushareit_listenit_dsm, com_ushareit_listenit_dte);
    }

    public Location mo1281f() {
        return this.f10328e.m15559a();
    }

    public void mo2075g() {
        synchronized (this.f10328e) {
            if (m10623h()) {
                try {
                    this.f10328e.m15564c();
                    this.f10328e.m15565d();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.mo2075g();
        }
    }

    public LocationAvailability m15581y() {
        return this.f10328e.m15563b();
    }
}
