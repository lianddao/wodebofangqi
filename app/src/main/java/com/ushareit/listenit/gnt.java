package com.ushareit.listenit;

class gnt implements Runnable {
    final /* synthetic */ gns f14482a;

    gnt(gns com_ushareit_listenit_gns) {
        this.f14482a = com_ushareit_listenit_gns;
    }

    public void run() {
        int indexOf = this.f14482a.f14481a.f16115a.indexOf(this.f14482a.f14481a.f16122h.mo2465v());
        this.f14482a.f14481a.f16117c.setSelection(indexOf + -2 > 0 ? indexOf - 2 : 0);
    }
}
