package com.ushareit.listenit;

import com.umeng.analytics.pro.C0321x;
import java.util.Map;

class akb implements Runnable {
    final /* synthetic */ amp f4575a;
    final /* synthetic */ long f4576b;
    final /* synthetic */ aog f4577c;
    final /* synthetic */ ajx f4578d;

    akb(ajx com_ushareit_listenit_ajx, amp com_ushareit_listenit_amp, long j, aog com_ushareit_listenit_aog) {
        this.f4578d = com_ushareit_listenit_ajx;
        this.f4575a = com_ushareit_listenit_amp;
        this.f4576b = j;
        this.f4577c = com_ushareit_listenit_aog;
    }

    public void run() {
        this.f4578d.m5834a(this.f4575a);
        if (this.f4575a instanceof amn) {
            atz.m7169a(this.f4578d.f4547c, aut.m7225a(((amn) this.f4575a).mo699z()) + " Failed. Ad request timed out");
        }
        Map a = this.f4578d.m5830a(this.f4576b);
        a.put(C0321x.aF, "-1");
        a.put("msg", "timeout");
        this.f4578d.m5840a(this.f4577c.m6452a(aoq.REQUEST), a);
        this.f4578d.m5858l();
    }
}
