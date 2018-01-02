package com.ushareit.listenit;

import com.facebook.ads.C0064v;

class alz implements C0064v {
    final /* synthetic */ aly f4751a;

    alz(aly com_ushareit_listenit_aly) {
        this.f4751a = com_ushareit_listenit_aly;
    }

    public boolean mo159a() {
        if (this.f4751a.f4746v == null) {
            return false;
        }
        if (!this.f4751a.f4746v.m1031a()) {
            return true;
        }
        if (!(this.f4751a.f4746v.getSkipSeconds() == 0 || this.f4751a.a == null)) {
            this.f4751a.a.m1112f();
        }
        if (this.f4751a.a != null) {
            this.f4751a.a.m1113g();
        }
        this.f4751a.f4734j.finish();
        return false;
    }
}
