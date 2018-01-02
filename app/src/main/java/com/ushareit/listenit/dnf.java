package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;

class dnf implements ceh<Status> {
    final /* synthetic */ dop f10005a;
    final /* synthetic */ boolean f10006b;
    final /* synthetic */ cdz f10007c;
    final /* synthetic */ dnb f10008d;

    dnf(dnb com_ushareit_listenit_dnb, dop com_ushareit_listenit_dop, boolean z, cdz com_ushareit_listenit_cdz) {
        this.f10008d = com_ushareit_listenit_dnb;
        this.f10005a = com_ushareit_listenit_dop;
        this.f10006b = z;
        this.f10007c = com_ushareit_listenit_cdz;
    }

    public void m15039a(Status status) {
        ccv.m10848a(this.f10008d.f9988n).m10858c();
        if (status.m2257f() && this.f10008d.mo1980i()) {
            this.f10008d.m15027k();
        }
        this.f10005a.m10793b((ceg) status);
        if (this.f10006b) {
            this.f10007c.mo1978g();
        }
    }

    public /* synthetic */ void mo2008a(ceg com_ushareit_listenit_ceg) {
        m15039a((Status) com_ushareit_listenit_ceg);
    }
}
