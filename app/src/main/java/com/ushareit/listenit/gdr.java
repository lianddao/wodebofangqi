package com.ushareit.listenit;

import com.facebook.login.C0143x;

class gdr implements aic<C0143x> {
    final /* synthetic */ gdq f13970a;

    gdr(gdq com_ushareit_listenit_gdq) {
        this.f13970a = com_ushareit_listenit_gdq;
    }

    public void m21779a(C0143x c0143x) {
        exw.m18454c("LOGIN.FACEBOOK", "Facebook Login success");
        eat a = eax.m16645a(c0143x.m1944a().m678b());
        if (this.f13970a.f13968c != null) {
            this.f13970a.f13968c.mo2666a(a);
        }
        this.f13970a.f13968c = null;
    }

    public void mo2661a() {
        if (this.f13970a.f13968c != null) {
            this.f13970a.f13968c.mo2667a("facebook cancelled");
        }
        this.f13970a.f13968c = null;
    }

    public void mo2662a(aif com_ushareit_listenit_aif) {
        if (this.f13970a.f13968c != null) {
            this.f13970a.f13968c.mo2667a("facebook error " + (com_ushareit_listenit_aif != null ? com_ushareit_listenit_aif.getMessage() : ""));
        }
        this.f13970a.f13968c = null;
    }
}
