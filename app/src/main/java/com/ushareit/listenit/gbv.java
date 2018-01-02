package com.ushareit.listenit;

import android.location.Location;

class gbv implements dsm {
    final /* synthetic */ gbu f13887a;

    gbv(gbu com_ushareit_listenit_gbu) {
        this.f13887a = com_ushareit_listenit_gbu;
    }

    public void mo2642a(Location location) {
        if (this.f13887a.c != null) {
            this.f13887a.c.mo2637a(location);
        }
        this.f13887a.m21606a(false);
        if (this.f13887a.b != null && !this.f13887a.b.m21544e() && this.f13887a.f13881d != null && this.f13887a.f13881d.mo1980i()) {
            exw.m18443a("LOC.GPServicesProvider", "We got location and no need to keep tracking, so location update is removed.");
            dso.f10298b.mo2031a(this.f13887a.f13881d, this);
        }
    }
}
