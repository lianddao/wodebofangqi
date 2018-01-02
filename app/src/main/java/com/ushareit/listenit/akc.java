package com.ushareit.listenit;

import com.facebook.ads.C0016g;
import com.umeng.analytics.pro.C0321x;
import java.util.Map;

class akc implements amq {
    boolean f4579a = false;
    boolean f4580b = false;
    boolean f4581c = false;
    final /* synthetic */ Runnable f4582d;
    final /* synthetic */ long f4583e;
    final /* synthetic */ aog f4584f;
    final /* synthetic */ ajx f4585g;

    akc(ajx com_ushareit_listenit_ajx, Runnable runnable, long j, aog com_ushareit_listenit_aog) {
        this.f4585g = com_ushareit_listenit_ajx;
        this.f4582d = runnable;
        this.f4583e = j;
        this.f4584f = com_ushareit_listenit_aog;
    }

    public void mo93a(amp com_ushareit_listenit_amp) {
        if (com_ushareit_listenit_amp == this.f4585g.f4557o) {
            this.f4585g.f4551g.removeCallbacks(this.f4582d);
            this.f4585g.f4558p = com_ushareit_listenit_amp;
            this.f4585g.f4546a.mo78a((aku) com_ushareit_listenit_amp);
            if (!this.f4579a) {
                this.f4579a = true;
                this.f4585g.m5840a(this.f4584f.m6452a(aoq.REQUEST), this.f4585g.m5830a(this.f4583e));
            }
        }
    }

    public void mo94a(amp com_ushareit_listenit_amp, C0016g c0016g) {
        if (com_ushareit_listenit_amp == this.f4585g.f4557o) {
            this.f4585g.f4551g.removeCallbacks(this.f4582d);
            this.f4585g.m5834a((aku) com_ushareit_listenit_amp);
            if (!this.f4579a) {
                this.f4579a = true;
                Map a = this.f4585g.m5830a(this.f4583e);
                a.put(C0321x.aF, String.valueOf(c0016g.m958a()));
                a.put("msg", String.valueOf(c0016g.m959b()));
                this.f4585g.m5840a(this.f4584f.m6452a(aoq.REQUEST), a);
            }
            this.f4585g.m5858l();
        }
    }

    public void mo95b(amp com_ushareit_listenit_amp) {
        if (!this.f4580b) {
            this.f4580b = true;
            this.f4585g.m5840a(this.f4584f.m6452a(aoq.IMPRESSION), null);
        }
    }

    public void mo96c(amp com_ushareit_listenit_amp) {
        if (!this.f4581c) {
            this.f4581c = true;
            this.f4585g.m5840a(this.f4584f.m6452a(aoq.CLICK), null);
        }
        if (this.f4585g.f4546a != null) {
            this.f4585g.f4546a.mo76a();
        }
    }
}
