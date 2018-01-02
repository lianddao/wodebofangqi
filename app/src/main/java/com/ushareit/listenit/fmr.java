package com.ushareit.listenit;

class fmr extends fjz {
    final /* synthetic */ long f12999a;
    final /* synthetic */ fjz f13000b;
    final /* synthetic */ fmp f13001c;

    fmr(fmp com_ushareit_listenit_fmp, long j, fjz com_ushareit_listenit_fjz) {
        this.f13001c = com_ushareit_listenit_fmp;
        this.f12999a = j;
        this.f13000b = com_ushareit_listenit_fjz;
    }

    public void mo2390a(boolean z, long j) {
        if (z) {
            fle.m19717b().m19739e(false);
            fle.m19717b().m19738e(this.f12999a);
            if (this.f13000b != null) {
                this.f13000b.m19587c();
            }
        } else if (this.f13000b != null) {
            fle.m19717b().m19738e(this.f12999a);
            this.f13000b.m19588d();
        }
    }
}
