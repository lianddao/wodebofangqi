package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

class dub extends dsq<LocationSettingsResult> {
    final /* synthetic */ LocationSettingsRequest f10330a;
    final /* synthetic */ String f10331b;
    final /* synthetic */ dua f10332c;

    dub(dua com_ushareit_listenit_dua, cdz com_ushareit_listenit_cdz, LocationSettingsRequest locationSettingsRequest, String str) {
        this.f10332c = com_ushareit_listenit_dua;
        this.f10330a = locationSettingsRequest;
        this.f10331b = str;
        super(com_ushareit_listenit_cdz);
    }

    public LocationSettingsResult m15594a(Status status) {
        return new LocationSettingsResult(status);
    }

    protected void m15596a(dtu com_ushareit_listenit_dtu) {
        com_ushareit_listenit_dtu.m15577a(this.f10330a, this, this.f10331b);
    }

    public /* synthetic */ ceg mo1278b(Status status) {
        return m15594a(status);
    }
}
