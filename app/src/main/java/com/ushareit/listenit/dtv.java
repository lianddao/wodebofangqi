package com.ushareit.listenit;

import com.google.android.gms.location.LocationSettingsResult;

final class dtv extends dto {
    private dlv<LocationSettingsResult> f10329a;

    public dtv(dlv<LocationSettingsResult> com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult) {
        cfi.m11090b(com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult != null, "listener can't be null.");
        this.f10329a = com_ushareit_listenit_dlv_com_google_android_gms_location_LocationSettingsResult;
    }

    public void mo2071a(LocationSettingsResult locationSettingsResult) {
        this.f10329a.mo1274a(locationSettingsResult);
        this.f10329a = null;
    }
}
