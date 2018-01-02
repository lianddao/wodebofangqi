package com.ushareit.listenit;

import android.location.Location;

class gbf extends gbd {
    final /* synthetic */ gbe f13853a;

    gbf(gbe com_ushareit_listenit_gbe) {
        this.f13853a = com_ushareit_listenit_gbe;
    }

    public void mo2637a(Location location) {
        if (location != null) {
            gvj.m23005m(eys.m18562a(), 0);
            gvj.m22893a(eys.m18562a(), location.getLongitude(), location.getLatitude());
            fir.m19387c(true);
            fir.m19381b(System.currentTimeMillis() - gbe.f13850c);
            exw.m18457e("LocationRequster", "onLocationChanged: longitude=" + location.getLongitude() + ", latitude=" + location.getLatitude());
            m21589a(location.getLatitude(), location.getLongitude());
        }
    }

    public void mo2636a(int i) {
        exw.m18457e("LocationRequster", "onLocationFailed: type=" + i);
        fir.m19387c(false);
    }

    private void m21589a(double d, double d2) {
        hhx.m23867a(new gbg(this, d, d2));
    }
}
