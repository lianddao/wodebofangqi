package com.ushareit.listenit;

import java.util.Iterator;

class ecd implements Iterator<ecb> {
    final /* synthetic */ ecc f10813a;

    ecd(ecc com_ushareit_listenit_ecc) {
        this.f10813a = com_ushareit_listenit_ecc;
    }

    public ecb m16708a() {
        cwz com_ushareit_listenit_cwz = (cwz) this.f10813a.f10811a.next();
        return new ecb(this.f10813a.f10812b.f10810b.m16736a(com_ushareit_listenit_cwz.m13267c().m13144d()), cwt.m13242a(com_ushareit_listenit_cwz.m13268d()));
    }

    public boolean hasNext() {
        return this.f10813a.f10811a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m16708a();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
