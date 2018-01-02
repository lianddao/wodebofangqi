package com.ushareit.listenit;

class fob extends hhv {
    final /* synthetic */ fnr f13079a;

    fob(fnr com_ushareit_listenit_fnr, String str) {
        this.f13079a = com_ushareit_listenit_fnr;
        super(str);
    }

    public void e_() {
        hgw l = this.f13079a.f13050i.mo2499l();
        if (l != null) {
            int a = fof.m20203a(l.mo2558g());
            hgw l2 = this.f13079a.f13050i.mo2499l();
            if (l2 != null && l2.equals(l)) {
                this.f13079a.f13051j.m23783a(a);
                exw.m18443a(hhw.TAG, "setSkip=" + a + ", path=" + l2.mo2558g());
            }
        }
    }
}
