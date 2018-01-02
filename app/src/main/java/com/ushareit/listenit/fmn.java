package com.ushareit.listenit;

class fmn implements ecy {
    final /* synthetic */ fjz f12991a;
    final /* synthetic */ fno f12992b;
    final /* synthetic */ fmm f12993c;

    fmn(fmm com_ushareit_listenit_fmm, fjz com_ushareit_listenit_fjz, fno com_ushareit_listenit_fno) {
        this.f12993c = com_ushareit_listenit_fmm;
        this.f12991a = com_ushareit_listenit_fjz;
        this.f12992b = com_ushareit_listenit_fno;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Integer num = (Integer) com_ushareit_listenit_ecb.m16701a(Integer.class);
        if (num == null || num.intValue() != 1) {
            this.f12993c.m19914a(this.f12992b, this.f12991a);
            return;
        }
        exw.m18443a("UserDeviceSync", "SYNC OK, version=" + num);
        if (this.f12991a != null) {
            this.f12991a.m19582a(-1);
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f12991a != null) {
            this.f12991a.m19580a();
        }
    }
}
