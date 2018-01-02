package com.ushareit.listenit;

class apc extends anp<String> {
    final /* synthetic */ aov f5132a;
    final /* synthetic */ apb f5133b;

    apc(apb com_ushareit_listenit_apb, aov com_ushareit_listenit_aov) {
        this.f5133b = com_ushareit_listenit_apb;
        this.f5132a = com_ushareit_listenit_aov;
    }

    public void mo750a(int i, String str) {
        super.mo750a(i, str);
        if (!(this.f5132a instanceof aou)) {
            this.f5133b.m6579b(str);
        }
    }

    public void m6589a(String str) {
        super.mo751a(str);
        if (this.f5132a.m6499i()) {
            this.f5133b.f5129e.m6518a();
        } else {
            this.f5133b.f5129e.m6519b();
        }
    }
}
