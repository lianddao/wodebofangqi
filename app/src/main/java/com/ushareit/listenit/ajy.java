package com.ushareit.listenit;

class ajy implements Runnable {
    final /* synthetic */ asj f4569a;
    final /* synthetic */ ajx f4570b;

    ajy(ajx com_ushareit_listenit_ajx, asj com_ushareit_listenit_asj) {
        this.f4570b = com_ushareit_listenit_ajx;
        this.f4569a = com_ushareit_listenit_asj;
    }

    public void run() {
        aok b = this.f4569a.m6972b();
        if (b == null || b.m6458a() == null) {
            throw new IllegalStateException("invalid placement in response");
        }
        this.f4570b.f4560r = b;
        this.f4570b.m5858l();
    }
}
