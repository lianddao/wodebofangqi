package com.ushareit.listenit;

class gbb extends gbi {
    final /* synthetic */ gaz f13847a;

    gbb(gaz com_ushareit_listenit_gaz) {
        this.f13847a = com_ushareit_listenit_gaz;
    }

    public void run() {
        if ((this.f13847a.f13834f instanceof gbu) && this.f13847a.f13834f.m21610e()) {
            exw.m18456d("LOC.LocationManager", "We couldn't receive location from GooglePlayServices, so switching default providers...");
            this.f13847a.m21571c();
            this.f13847a.m21564d();
        }
    }
}
