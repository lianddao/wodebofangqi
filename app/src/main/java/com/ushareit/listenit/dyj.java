package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class dyj implements dwq {
    dru f10690a;
    List<Long> f10691b;
    List<drr> f10692c;
    long f10693d;
    final /* synthetic */ dyf f10694e;

    private dyj(dyf com_ushareit_listenit_dyf) {
        this.f10694e = com_ushareit_listenit_dyf;
    }

    private long m16478a(drr com_ushareit_listenit_drr) {
        return ((com_ushareit_listenit_drr.f10227c.longValue() / 1000) / 60) / 60;
    }

    public void mo2108a(dru com_ushareit_listenit_dru) {
        cfi.m11080a((Object) com_ushareit_listenit_dru);
        this.f10690a = com_ushareit_listenit_dru;
    }

    boolean m16480a() {
        return this.f10692c == null || this.f10692c.isEmpty();
    }

    public boolean mo2109a(long j, drr com_ushareit_listenit_drr) {
        cfi.m11080a((Object) com_ushareit_listenit_drr);
        if (this.f10692c == null) {
            this.f10692c = new ArrayList();
        }
        if (this.f10691b == null) {
            this.f10691b = new ArrayList();
        }
        if (this.f10692c.size() > 0 && m16478a((drr) this.f10692c.get(0)) != m16478a(com_ushareit_listenit_drr)) {
            return false;
        }
        long g = this.f10693d + ((long) com_ushareit_listenit_drr.m13475g());
        if (g >= ((long) this.f10694e.m16452d().m16024W())) {
            return false;
        }
        this.f10693d = g;
        this.f10692c.add(com_ushareit_listenit_drr);
        this.f10691b.add(Long.valueOf(j));
        return this.f10692c.size() < this.f10694e.m16452d().m16025X();
    }
}
