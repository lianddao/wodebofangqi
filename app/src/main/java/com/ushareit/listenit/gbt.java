package com.ushareit.listenit;

import android.location.LocationListener;

class gbt {
    final /* synthetic */ gbo f13876a;
    private String f13877b;
    private long f13878c;
    private float f13879d;
    private LocationListener f13880e;

    public gbt(gbo com_ushareit_listenit_gbo, String str, long j, float f, LocationListener locationListener) {
        this.f13876a = com_ushareit_listenit_gbo;
        this.f13877b = str;
        this.f13878c = j;
        this.f13879d = f;
        this.f13880e = locationListener;
    }

    public void m21634a() {
        this.f13876a.f13867e.requestLocationUpdates(this.f13877b, this.f13878c, this.f13879d, this.f13880e);
    }

    public void m21635b() {
        this.f13876a.f13867e.removeUpdates(this.f13880e);
    }

    public void m21636c() {
        this.f13876a.f13867e.removeUpdates(this.f13880e);
        this.f13880e = null;
    }
}
