package com.ushareit.listenit;

import java.util.Iterator;

class ecc implements Iterable<ecb> {
    final /* synthetic */ Iterator f10811a;
    final /* synthetic */ ecb f10812b;

    ecc(ecb com_ushareit_listenit_ecb, Iterator it) {
        this.f10812b = com_ushareit_listenit_ecb;
        this.f10811a = it;
    }

    public Iterator<ecb> iterator() {
        return new ecd(this);
    }
}
