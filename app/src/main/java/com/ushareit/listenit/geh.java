package com.ushareit.listenit;

class geh implements dzk<eau> {
    final /* synthetic */ String f13993a;
    final /* synthetic */ get f13994b;
    final /* synthetic */ gef f13995c;

    geh(gef com_ushareit_listenit_gef, String str, get com_ushareit_listenit_get) {
        this.f13995c = com_ushareit_listenit_gef;
        this.f13993a = str;
        this.f13994b = com_ushareit_listenit_get;
    }

    public void mo2397a(dzo<eau> com_ushareit_listenit_dzo_com_ushareit_listenit_eau) {
        if (com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2130b()) {
            exw.m18454c("LOGIN.CONTROLLER", "Firebase login success.");
            this.f13995c.f13985a = ((eau) com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2131c()).mo1427a();
            this.f13995c.f13988d = "email";
            this.f13995c.m21811b(this.f13993a);
            this.f13994b.mo2405a();
            return;
        }
        exw.m18451b("LOGIN.CONTROLLER", "Firebase login failure.", com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2132d());
        this.f13994b.mo2406a(eys.m18562a().getResources().getString(C0349R.string.email_login_toast_fail));
    }
}
