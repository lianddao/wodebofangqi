package com.ushareit.listenit;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.ArrayList;

public final class dss {
    private final ArrayList<LocationRequest> f10303a = new ArrayList();
    private boolean f10304b = false;
    private boolean f10305c = false;

    public LocationSettingsRequest m15445a() {
        return new LocationSettingsRequest(this.f10303a, this.f10304b, this.f10305c);
    }

    public dss m15446a(LocationRequest locationRequest) {
        this.f10303a.add(locationRequest);
        return this;
    }
}
