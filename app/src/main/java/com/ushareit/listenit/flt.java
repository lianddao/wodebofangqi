package com.ushareit.listenit;

class flt implements ecy {
    final /* synthetic */ fnl f12942a;
    final /* synthetic */ fjz f12943b;
    final /* synthetic */ flr f12944c;

    flt(flr com_ushareit_listenit_flr, fnl com_ushareit_listenit_fnl, fjz com_ushareit_listenit_fjz) {
        this.f12944c = com_ushareit_listenit_flr;
        this.f12942a = com_ushareit_listenit_fnl;
        this.f12943b = com_ushareit_listenit_fjz;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Integer num = (Integer) com_ushareit_listenit_ecb.m16701a(Integer.class);
        if (num == null || num.intValue() != this.f12942a.getSgN()) {
            fjy.m19571a().m16736a("sharelists").m16736a(this.f12942a.getId()).m16733a(this.f12942a.toMap()).mo2124a(new flu(this));
        } else {
            this.f12943b.m19582a(-1);
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        this.f12943b.m19580a();
    }
}
