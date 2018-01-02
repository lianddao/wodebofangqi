package com.ushareit.listenit;

import android.app.Activity;
import android.app.Dialog;

public class gaz {
    private int f13829a = 0;
    private Activity f13830b;
    private Dialog f13831c;
    private gbd f13832d;
    private gay f13833e;
    private gbz f13834f;
    private final gbi f13835g = new gbb(this);
    private final gbn f13836h = new gbc(this);

    public gaz(gay com_ushareit_listenit_gay) {
        this.f13833e = com_ushareit_listenit_gay;
    }

    public gaz m21566a(Activity activity) {
        this.f13830b = activity;
        return this;
    }

    public gaz m21567a(gbd com_ushareit_listenit_gbd) {
        this.f13832d = com_ushareit_listenit_gbd;
        return this;
    }

    public gaz m21568a(gbz com_ushareit_listenit_gbz) {
        if (com_ushareit_listenit_gbz != null) {
            com_ushareit_listenit_gbz.m21604a(this.f13830b, this.f13833e);
        }
        this.f13834f = com_ushareit_listenit_gbz;
        return this;
    }

    public void m21569a() {
        if (this.f13834f != null) {
            this.f13834f.mo2639b();
        }
        this.f13835g.m21575a();
        this.f13831c = null;
        this.f13830b = null;
        this.f13834f = null;
        this.f13833e = null;
        this.f13832d = null;
    }

    public void m21570b() {
        m21560a(true);
    }

    public void m21571c() {
        if (this.f13834f != null) {
            this.f13834f.mo2641d();
        }
    }

    private void m21560a(boolean z) {
        if (this.f13830b == null) {
            throw new RuntimeException("You must specify on which activity this manager runs!");
        } else if (this.f13833e.m21542c()) {
            exw.m18443a("LOC.LocationManager", "Configuration requires not to use Google Play Services, so skipping that step to Default Location Providers");
            m21564d();
        } else {
            int a = cdd.m10887a().mo1287a(this.f13830b);
            if (a == 0) {
                exw.m18443a("LOC.LocationManager", "GooglePlayServices is available on device.");
                m21558a(3);
                return;
            }
            exw.m18443a("LOC.LocationManager", "GooglePlayServices is NOT available on device.");
            if (!z) {
                exw.m18443a("LOC.LocationManager", "GooglePlayServices is NOT available and even though we ask user to handle error, it is still NOT available.");
                m21564d();
            } else if (this.f13833e.m21540a() && cdd.m10887a().mo1291a(a)) {
                exw.m18443a("LOC.LocationManager", "Asking user to handle GooglePlayServices error...");
                this.f13831c = cdd.m10887a().m10889a(this.f13830b, a, 258, new gba(this));
                this.f13831c.show();
            } else {
                exw.m18443a("LOC.LocationManager", "Either GooglePlayServices error is not resolvable or the configuration doesn't wants us to bother user.");
                m21564d();
            }
        }
    }

    private void m21564d() {
        if (this.f13833e.m21543d()) {
            exw.m18443a("LOC.LocationManager", "Because the configuration, we can only use GooglePlayServices, so we abort.");
            m21561b(2);
            return;
        }
        exw.m18443a("LOC.LocationManager", "Attempting to get location from default providers...");
        m21558a(4);
    }

    private void m21558a(int i) {
        this.f13829a = i;
        if (gbk.m21599a(this.f13830b, this.f13833e.m21548i())) {
            m21563b(true);
            return;
        }
        exw.m18443a("LOC.LocationManager", "Asking for Runtime Permissions...");
        gbk.m21597a(this.f13830b, this.f13836h, this.f13833e.m21549j(), this.f13833e.m21548i());
    }

    private void m21563b(boolean z) {
        exw.m18443a("LOC.LocationManager", "We got permission, getting location...");
        if (this.f13832d != null) {
            this.f13832d.m21583a(z);
        }
        if (this.f13829a == 3) {
            m21568a(new gbu());
            this.f13835g.m21576a(this.f13833e.m21556q());
        } else {
            m21568a(null);
        }
        m21565e().m21605a(this.f13832d);
        m21565e().mo2640c();
    }

    private gbz m21565e() {
        if (this.f13834f == null) {
            m21568a(new gbo());
        }
        return this.f13834f;
    }

    private void m21561b(int i) {
        if (this.f13832d != null) {
            this.f13832d.mo2636a(i);
        }
    }
}
