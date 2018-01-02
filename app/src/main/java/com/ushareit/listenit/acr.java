package com.ushareit.listenit;

public class acr implements wk<acq> {
    private final acq f4130a;

    public /* synthetic */ Object mo553b() {
        return m5231a();
    }

    public acr(acq com_ushareit_listenit_acq) {
        if (com_ushareit_listenit_acq == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f4130a = com_ushareit_listenit_acq;
    }

    public acq m5231a() {
        return this.f4130a;
    }

    public int mo554c() {
        return this.f4130a.m5228a();
    }

    public void mo555d() {
        wk b = this.f4130a.m5229b();
        if (b != null) {
            b.mo555d();
        }
        b = this.f4130a.m5230c();
        if (b != null) {
            b.mo555d();
        }
    }
}
