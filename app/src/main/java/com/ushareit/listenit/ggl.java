package com.ushareit.listenit;

class ggl implements get {
    final /* synthetic */ ggj f14079a;

    ggl(ggj com_ushareit_listenit_ggj) {
        this.f14079a = com_ushareit_listenit_ggj;
    }

    public void mo2405a() {
        fiw.m19469c(this.f14079a.m1326l(), "email->" + this.f14079a.f14076g);
        this.f14079a.f14075f.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_success, 0).show();
        gef.m21805a().m21833c();
        if (this.f14079a.m1328m() != null) {
            this.f14079a.m1328m().finish();
        }
    }

    public void mo2406a(String str) {
        fiw.m19471d(eys.m18562a(), "email->" + this.f14079a.f14076g);
        this.f14079a.f14075f.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_fail, 0).show();
        gef.m21805a().m21833c();
    }
}
