package com.ushareit.listenit;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.text.TextUtils;
import com.mopub.mobileads.GooglePlayServicesInterstitial;

public class gbo extends gbz {
    private String f13866d;
    private LocationManager f13867e;
    private gbt f13868f;
    private AlertDialog f13869g;
    private final LocationListener f13870h = new gbr(this);
    private final gbi f13871i = new gbs(this);

    public void mo2638a() {
        super.mo2638a();
        this.f13867e = (LocationManager) this.a.getSystemService(GooglePlayServicesInterstitial.LOCATION_KEY);
    }

    public void mo2639b() {
        super.mo2639b();
        this.f13869g = null;
        this.f13871i.m21575a();
        if (this.f13868f != null) {
            this.f13868f.m21636c();
            this.f13868f = null;
        }
        if (this.f13867e != null) {
            this.f13867e.removeUpdates(this.f13870h);
            this.f13867e = null;
        }
    }

    public void mo2640c() {
        m21606a(true);
        if (m21629k()) {
            exw.m18443a("LOC.DefaultProvider", "GPS is already enabled, getting location...");
            m21619a("gps");
        } else if (this.b.m21547h()) {
            exw.m18443a("LOC.DefaultProvider", "GPS is not enabled, asking user to enable it...");
            m21625g();
        } else {
            exw.m18443a("LOC.DefaultProvider", "GPS is not enabled, moving on with Network...");
            m21626h();
        }
    }

    public void mo2641d() {
        if (this.f13868f != null) {
            this.f13868f.m21635b();
        }
        this.f13871i.m21575a();
    }

    private void m21625g() {
        if (TextUtils.isEmpty(this.b.m21550k())) {
            throw new IllegalArgumentException("You need to set a gpsMessage in order to display to user");
        }
        this.f13869g = new Builder(this.a).setMessage(this.b.m21550k()).setCancelable(false).setPositiveButton(17039370, new gbq(this)).setNegativeButton(17039360, new gbp(this)).create();
        if (!this.a.isFinishing()) {
            this.f13869g.show();
        }
    }

    private void m21626h() {
        if (m21628j() && gbj.m21593a(this.a)) {
            exw.m18443a("LOC.DefaultProvider", "Network is enabled, getting location...");
            m21619a("network");
            return;
        }
        exw.m18443a("LOC.DefaultProvider", "Network is not enabled, calling fail...");
        m21612a(4);
    }

    private void m21619a(String str) {
        boolean z;
        boolean z2 = true;
        this.f13871i.m21575a();
        this.f13866d = str;
        Location lastKnownLocation = this.f13867e.getLastKnownLocation(str);
        if (gbj.m21594a(this.b, lastKnownLocation)) {
            exw.m18443a("LOC.DefaultProvider", "LastKnowLocation is usable.");
            m21614a(lastKnownLocation);
            z = true;
        } else {
            exw.m18443a("LOC.DefaultProvider", "LastKnowLocation is not usable.");
            z = false;
        }
        if (this.b.m21544e() || !z) {
            exw.m18443a("LOC.DefaultProvider", "Ask for location update...");
            if (z) {
                z2 = false;
            }
            m21613a(0, z2);
            return;
        }
        exw.m18443a("LOC.DefaultProvider", "We got location, no need to ask for location updates.");
    }

    private void m21613a(long j, boolean z) {
        if (z) {
            this.f13871i.m21576a(m21627i());
        }
        this.f13868f = new gbt(this, this.f13866d, j, 0.0f, this.f13870h);
        this.f13868f.m21634a();
    }

    private long m21627i() {
        return this.f13866d.equals("gps") ? this.b.m21554o() : this.b.m21555p();
    }

    private boolean m21628j() {
        return this.f13867e.isProviderEnabled("network");
    }

    private boolean m21629k() {
        return this.f13867e.isProviderEnabled("gps");
    }

    private void m21614a(Location location) {
        if (this.c != null) {
            this.c.mo2637a(location);
        }
        m21606a(false);
    }

    private void m21612a(int i) {
        if (this.c != null) {
            this.c.mo2636a(i);
        }
        m21606a(false);
    }
}
