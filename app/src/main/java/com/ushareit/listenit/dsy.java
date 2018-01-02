package com.ushareit.listenit;

import com.google.android.gms.location.LocationRequest;

class dsy extends dta {
    final /* synthetic */ LocationRequest f10309a;
    final /* synthetic */ dsm f10310b;
    final /* synthetic */ dsx f10311c;

    dsy(dsx com_ushareit_listenit_dsx, cdz com_ushareit_listenit_cdz, LocationRequest locationRequest, dsm com_ushareit_listenit_dsm) {
        this.f10311c = com_ushareit_listenit_dsx;
        this.f10309a = locationRequest;
        this.f10310b = com_ushareit_listenit_dsm;
        super(com_ushareit_listenit_cdz);
    }

    protected void m15469a(dtu com_ushareit_listenit_dtu) {
        com_ushareit_listenit_dtu.m15576a(this.f10309a, this.f10310b, null, new dtb(this));
    }
}
