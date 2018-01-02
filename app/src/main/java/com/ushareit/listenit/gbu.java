package com.ushareit.listenit;

import com.google.android.gms.location.LocationSettingsResult;

public class gbu extends gbz {
    private cdz f13881d;
    private boolean f13882e = false;
    private final dsm f13883f = new gbv(this);
    private final ceb f13884g = new gbw(this);
    private final cec f13885h = new gbx(this);
    private final ceh<LocationSettingsResult> f13886i = new gby(this);

    public void mo2639b() {
        super.mo2639b();
        m21648i();
    }

    public void mo2640c() {
        m21606a(true);
        this.f13881d = new cea(this.a).m10955a(dso.f10297a).m10957a(this.f13884g).m10958a(this.f13885h).m10960b();
        this.f13881d.mo1976e();
    }

    public void mo2641d() {
        exw.m18443a("LOC.GPServicesProvider", "Canceling GPServiceLocationProvider...");
        if (this.f13881d != null && this.f13881d.mo1980i()) {
            dso.f10298b.mo2031a(this.f13881d, this.f13883f);
            this.f13881d.mo1978g();
        }
    }

    private void m21646g() {
        dso.f10300d.mo2076a(this.f13881d, new dss().m15446a(m21611f()).m15445a()).mo1272a(this.f13886i);
    }

    private void m21647h() {
        dso.f10298b.mo2030a(this.f13881d, m21611f(), this.f13883f);
    }

    private void m21638a(int i) {
        if (this.b.m21546g()) {
            m21642b(i);
            return;
        }
        exw.m18457e("LOC.GPServicesProvider", "Even though settingsApi failed, configuration requires moving on, so requesting location update...");
        if (this.f13881d.mo1980i()) {
            m21647h();
            return;
        }
        exw.m18457e("LOC.GPServicesProvider", "GoogleApiClient is not connected. Aborting...");
        m21642b(i);
    }

    private void m21642b(int i) {
        if (this.c != null) {
            this.c.mo2636a(i);
        }
        m21606a(false);
    }

    private void m21648i() {
        if (this.f13881d != null) {
            this.f13881d.mo1974b(this.f13884g);
            this.f13881d.mo1975b(this.f13885h);
            if (this.f13881d.mo1980i()) {
                dso.f10298b.mo2031a(this.f13881d, this.f13883f);
                this.f13881d.mo1978g();
            }
            this.f13881d = null;
        }
    }
}
