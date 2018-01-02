package com.ushareit.listenit;

import com.ushareit.listenit.login.LoginActivity;

public class ged implements get {
    final /* synthetic */ LoginActivity f13984a;

    public ged(LoginActivity loginActivity) {
        this.f13984a = loginActivity;
    }

    public void mo2405a() {
        this.f13984a.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_success, 0).show();
        gef.m21805a().m21833c();
        fiw.m19459a(eys.m18562a(), this.f13984a.f15764F, System.currentTimeMillis() - this.f13984a.f15765G);
        this.f13984a.finish();
    }

    public void mo2406a(String str) {
        fiw.m19471d(eys.m18562a(), str);
        this.f13984a.m24640s();
        heb.m23596a((int) C0349R.string.email_login_toast_fail, 0).show();
        gef.m21805a().m21833c();
    }
}
