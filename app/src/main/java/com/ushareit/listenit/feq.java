package com.ushareit.listenit;

import java.util.List;

class feq implements eso {
    final /* synthetic */ fen f12552a;
    final /* synthetic */ ffl f12553b;
    final /* synthetic */ ffk f12554c;
    final /* synthetic */ fep f12555d;

    feq(fep com_ushareit_listenit_fep, fen com_ushareit_listenit_fen, ffl com_ushareit_listenit_ffl, ffk com_ushareit_listenit_ffk) {
        this.f12555d = com_ushareit_listenit_fep;
        this.f12552a = com_ushareit_listenit_fen;
        this.f12553b = com_ushareit_listenit_ffl;
        this.f12554c = com_ushareit_listenit_ffk;
    }

    public void mo2356a(String str, List<esi> list) {
        if (this.f12552a == null) {
            return;
        }
        if (!this.f12552a.mo2362f() || this.f12552a.m18994b()) {
            esf.m17738a((List) list);
            return;
        }
        esi a = this.f12555d.m19001a((List) list);
        if (a != null && a.m17769c() != null) {
            this.f12552a.m18992a(this.f12553b, a);
        } else if (this.f12554c == null || !this.f12554c.m19106b(this.f12553b)) {
            this.f12552a.m18991a();
        } else {
            this.f12555d.m19006a(this.f12554c.m19103a(this.f12553b), this.f12552a, this.f12554c);
        }
    }

    public void mo2355a(String str, String str2, esd com_ushareit_listenit_esd) {
        if (this.f12554c == null || !this.f12554c.m19106b(this.f12553b)) {
            this.f12552a.m18991a();
        } else {
            this.f12555d.m19006a(this.f12554c.m19103a(this.f12553b), this.f12552a, this.f12554c);
        }
    }

    public void mo2354a(String str, esi com_ushareit_listenit_esi) {
    }

    public void mo2357b(String str, esi com_ushareit_listenit_esi) {
    }
}
