package com.ushareit.listenit;

class fnc implements ecy {
    final /* synthetic */ fjz f13026a;
    final /* synthetic */ long f13027b;
    final /* synthetic */ fmp f13028c;

    fnc(fmp com_ushareit_listenit_fmp, fjz com_ushareit_listenit_fjz, long j) {
        this.f13028c = com_ushareit_listenit_fmp;
        this.f13026a = com_ushareit_listenit_fjz;
        this.f13027b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        fnq com_ushareit_listenit_fnq = (fnq) com_ushareit_listenit_ecb.m16701a(fnq.class);
        exw.m18443a("UserInfoSync", "syncAll, cloudUserSyncTime=" + com_ushareit_listenit_fnq + ", localUserSyncTime=" + fle.m19717b().m19741g());
        if (com_ushareit_listenit_fnq != null) {
            this.f13028c.m19924a(com_ushareit_listenit_fnq, this.f13026a, this.f13027b);
        } else if (this.f13026a != null) {
            this.f13026a.m19580a();
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        this.f13026a.m19580a();
    }
}
