package com.ushareit.listenit;

class geo implements dzk<eau> {
    final /* synthetic */ gef f14008a;

    geo(gef com_ushareit_listenit_gef) {
        this.f14008a = com_ushareit_listenit_gef;
    }

    public void mo2397a(dzo<eau> com_ushareit_listenit_dzo_com_ushareit_listenit_eau) {
        if (com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2130b()) {
            exw.m18454c("LOGIN.CONTROLLER", "Firebase login success.");
            this.f14008a.f13985a = ((eau) com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2131c()).mo1427a();
            this.f14008a.m21811b("");
            if (this.f14008a.f13986b != null) {
                this.f14008a.f13986b.mo2405a();
            }
            fiw.m19469c(eys.m18562a(), this.f14008a.f13988d);
            return;
        }
        exw.m18457e("LOGIN.CONTROLLER", "Firebase login failure.");
        if (this.f14008a.f13986b != null) {
            String message = (com_ushareit_listenit_dzo_com_ushareit_listenit_eau == null || com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2132d() == null) ? "" : com_ushareit_listenit_dzo_com_ushareit_listenit_eau.mo2132d().getMessage();
            this.f14008a.f13986b.mo2406a(this.f14008a.f13988d + " " + "signin firebase error " + message);
        }
    }
}
