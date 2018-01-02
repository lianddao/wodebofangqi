package com.ushareit.listenit;

class esc extends fay {
    final /* synthetic */ esb f11681a;

    esc(esb com_ushareit_listenit_esb) {
        this.f11681a = com_ushareit_listenit_esb;
    }

    public void mo2280a() {
    }

    public void mo2281a(Exception exception) {
        if (this.f11681a.f11674a.f11672h.compareAndSet(true, false)) {
            exw.m18449b("AD.Context", "onReceive() CONNECTIVITY_ACTION Ignore first");
        } else if (this.f11681a.f11674a.m17696b(true)) {
            this.f11681a.f11674a.m17703i();
            for (esj a : this.f11681a.f11674a.f11667c) {
                a.m17782a();
            }
        }
    }
}
