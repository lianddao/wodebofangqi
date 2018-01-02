package com.ushareit.listenit;

import java.util.Comparator;

final class bsy implements Comparator<bsz> {
    bsy() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9748a((bsz) obj, (bsz) obj2);
    }

    public int m9748a(bsz com_ushareit_listenit_bsz, bsz com_ushareit_listenit_bsz2) {
        if (com_ushareit_listenit_bsz.f7658c < com_ushareit_listenit_bsz2.f7658c) {
            return -1;
        }
        return com_ushareit_listenit_bsz2.f7658c < com_ushareit_listenit_bsz.f7658c ? 1 : 0;
    }
}
