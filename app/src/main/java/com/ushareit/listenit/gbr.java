package com.ushareit.listenit;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class gbr implements LocationListener {
    final /* synthetic */ gbo f13874a;

    gbr(gbo com_ushareit_listenit_gbo) {
        this.f13874a = com_ushareit_listenit_gbo;
    }

    public void onLocationChanged(Location location) {
        this.f13874a.m21614a(location);
        this.f13874a.f13871i.m21575a();
        if (this.f13874a.b.m21544e()) {
            this.f13874a.m21613a(this.f13874a.b.m21553n(), false);
        } else {
            this.f13874a.f13867e.removeUpdates(this.f13874a.f13870h);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (this.f13874a.c != null) {
            this.f13874a.c.m21582a(str, i, bundle);
        }
    }

    public void onProviderEnabled(String str) {
        if (this.f13874a.c != null) {
            this.f13874a.c.m21581a(str);
        }
    }

    public void onProviderDisabled(String str) {
        if (this.f13874a.c != null) {
            this.f13874a.c.m21584b(str);
        }
    }
}
