package com.ushareit.listenit;

class gga implements ges {
    final /* synthetic */ gfx f14060a;

    gga(gfx com_ushareit_listenit_gfx) {
        this.f14060a = com_ushareit_listenit_gfx;
    }

    public void mo2676a() {
        fiw.m19469c(this.f14060a.m1326l(), "register");
        this.f14060a.al.m24640s();
        heb.m23596a((int) C0349R.string.email_register_result_success, 0).show();
        this.f14060a.al.finish();
    }

    public void mo2677a(String str) {
        fiw.m19471d(eys.m18562a(), "register " + str);
        this.f14060a.al.m24640s();
        heb.m23597a((CharSequence) str, 0).show();
    }
}
