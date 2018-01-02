package com.ushareit.listenit;

class gfs implements get {
    final /* synthetic */ gfr f14047a;

    gfs(gfr com_ushareit_listenit_gfr) {
        this.f14047a = com_ushareit_listenit_gfr;
    }

    public void mo2405a() {
        fiw.m19469c(this.f14047a.m1326l(), "email");
        this.f14047a.aj.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_success, 0).show();
        this.f14047a.aj.finish();
    }

    public void mo2406a(String str) {
        fiw.m19471d(eys.m18562a(), "email invalid password");
        this.f14047a.f14045h.setVisibility(0);
        this.f14047a.f14045h.setText(C0349R.string.email_error_info_password_validator_3);
        this.f14047a.aj.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_fail, 0).show();
    }
}
