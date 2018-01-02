package com.ushareit.listenit;

import java.util.List;

class gmn extends hib {
    final /* synthetic */ List f14422a;
    final /* synthetic */ gmm f14423b;

    gmn(gmm com_ushareit_listenit_gmm, List list) {
        this.f14423b = com_ushareit_listenit_gmm;
        this.f14422a = list;
    }

    public void callback() {
        this.f14423b.f14421b.f14415c.m26855a();
        this.f14423b.f14421b.m22443W();
        if (this.f14422a == null || this.f14422a.size() == 0) {
            this.f14423b.f14421b.f14415c.m26856b();
        } else if (this.f14422a != null && this.f14422a.size() > 0) {
            this.f14423b.f14421b.f14414b.m18942a(this.f14422a);
        }
    }
}
