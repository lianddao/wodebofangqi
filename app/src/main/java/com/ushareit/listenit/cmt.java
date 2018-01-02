package com.ushareit.listenit;

import java.util.concurrent.ScheduledExecutorService;

public class cmt implements cpw {
    private final ScheduledExecutorService f8472a;
    private final eah f8473b;

    public cmt(eah com_ushareit_listenit_eah, ScheduledExecutorService scheduledExecutorService) {
        this.f8473b = com_ushareit_listenit_eah;
        this.f8472a = scheduledExecutorService;
    }

    private eai m11760b(cpy com_ushareit_listenit_cpy) {
        return new cmw(this, com_ushareit_listenit_cpy);
    }

    public void mo1445a(cpy com_ushareit_listenit_cpy) {
        this.f8473b.m16621a(m11760b(com_ushareit_listenit_cpy));
    }

    public void mo1446a(boolean z, cpx com_ushareit_listenit_cpx) {
        this.f8473b.m16623b(z).mo2128a(this.f8472a, new cmv(this, com_ushareit_listenit_cpx)).mo2127a(this.f8472a, new cmu(this, com_ushareit_listenit_cpx));
    }
}
