package com.ushareit.listenit;

class gbs extends gbi {
    final /* synthetic */ gbo f13875a;

    gbs(gbo com_ushareit_listenit_gbo) {
        this.f13875a = com_ushareit_listenit_gbo;
    }

    public void run() {
        if (this.f13875a.f13868f != null) {
            this.f13875a.f13868f.m21635b();
        }
        if (this.f13875a.f13866d.equals("gps")) {
            exw.m18443a("LOC.DefaultProvider", "We waited enough for GPS, switching to network provider...");
            this.f13875a.m21626h();
            return;
        }
        exw.m18443a("LOC.DefaultProvider", "Network Provider is not provide location in required period, calling fail...");
        this.f13875a.m21612a(5);
    }
}
