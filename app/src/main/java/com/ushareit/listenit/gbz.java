package com.ushareit.listenit;

import android.app.Activity;
import com.google.android.gms.location.LocationRequest;

public abstract class gbz {
    protected Activity f13861a;
    protected gay f13862b;
    protected gbd f13863c;
    private LocationRequest f13864d;
    private boolean f13865e = false;

    public abstract void mo2640c();

    public abstract void mo2641d();

    public void m21604a(Activity activity, gay com_ushareit_listenit_gay) {
        this.f13861a = activity;
        this.f13862b = com_ushareit_listenit_gay;
        mo2638a();
    }

    public void m21606a(boolean z) {
        this.f13865e = z;
    }

    public boolean m21610e() {
        return this.f13865e;
    }

    public void m21605a(gbd com_ushareit_listenit_gbd) {
        this.f13863c = com_ushareit_listenit_gbd;
    }

    public void mo2638a() {
    }

    public void mo2639b() {
        this.f13861a = null;
        this.f13862b = null;
        this.f13863c = null;
    }

    protected LocationRequest m21611f() {
        if (this.f13864d == null) {
            this.f13864d = LocationRequest.m2372a();
            this.f13864d.m2376a(102);
            this.f13864d.m2377a(300000);
            this.f13864d.m2379b(60000);
        }
        return this.f13864d;
    }
}
