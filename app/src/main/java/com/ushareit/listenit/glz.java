package com.ushareit.listenit;

final class glz implements ecy {
    final /* synthetic */ gmc f14394a;
    final /* synthetic */ long f14395b;

    glz(gmc com_ushareit_listenit_gmc, long j) {
        this.f14394a = com_ushareit_listenit_gmc;
        this.f14395b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Object com_ushareit_listenit_fri;
        if (com_ushareit_listenit_ecb.m16700a() != null) {
            Long l = (Long) com_ushareit_listenit_ecb.m16699a(fnn.KEY_BACKUP).m16701a(Long.class);
            if (l != null && l.longValue() > 0) {
                com_ushareit_listenit_fri = new fri(com_ushareit_listenit_ecb);
                this.f14394a.m22415a(com_ushareit_listenit_fri);
                if (com_ushareit_listenit_fri != null) {
                    fir.m19405i(System.currentTimeMillis() - this.f14395b);
                }
            }
        }
        com_ushareit_listenit_fri = null;
        this.f14394a.m22415a(com_ushareit_listenit_fri);
        if (com_ushareit_listenit_fri != null) {
            fir.m19405i(System.currentTimeMillis() - this.f14395b);
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        this.f14394a.m22414a();
        fir.m19400g(com_ushareit_listenit_ece.m16715b());
    }
}
