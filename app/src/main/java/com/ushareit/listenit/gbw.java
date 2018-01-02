package com.ushareit.listenit;

import android.location.Location;
import android.os.Bundle;

class gbw implements ceb {
    final /* synthetic */ gbu f13888a;

    gbw(gbu com_ushareit_listenit_gbu) {
        this.f13888a = com_ushareit_listenit_gbu;
    }

    public void mo1957a(Bundle bundle) {
        exw.m18443a("LOC.GPServicesProvider", "GoogleApiClient is connected.");
        Object obj = null;
        if (dso.f10298b.mo2032b(this.f13888a.f13881d).m2370a()) {
            Location a = dso.f10298b.mo2029a(this.f13888a.f13881d);
            if (gbj.m21594a(this.f13888a.b, a)) {
                exw.m18443a("LOC.GPServicesProvider", "LastKnowLocation is usable.");
                this.f13888a.f13883f.mo2642a(a);
                obj = 1;
            } else {
                exw.m18443a("LOC.GPServicesProvider", "LastKnowLocation is not usable.");
            }
        }
        if (this.f13888a.b.m21544e() || r0 == null) {
            exw.m18443a("LOC.GPServicesProvider", "Ask for location update...");
            if (this.f13888a.b.m21541b()) {
                exw.m18443a("LOC.GPServicesProvider", "Asking for SettingsApi...");
                this.f13888a.m21646g();
                return;
            }
            exw.m18443a("LOC.GPServicesProvider", "SettingsApi is not enabled, requesting for location update...");
            this.f13888a.m21647h();
            return;
        }
        exw.m18443a("LOC.GPServicesProvider", "We got location, no need to ask for location updates.");
    }

    public void mo1956a(int i) {
        if (this.f13888a.b.m21545f() || this.f13888a.f13881d == null) {
            exw.m18443a("LOC.GPServicesProvider", "GoogleApiClient connection is suspended, calling fail...");
            this.f13888a.m21642b(3);
            return;
        }
        exw.m18443a("LOC.GPServicesProvider", "GoogleApiClient connection is suspended, try to connect again.");
        this.f13888a.f13881d.mo1976e();
    }
}
