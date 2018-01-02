package com.ushareit.listenit;

import java.util.Comparator;

final class fqy implements Comparator<gle> {
    fqy() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m20500a((gle) obj, (gle) obj2);
    }

    public int m20500a(gle com_ushareit_listenit_gle, gle com_ushareit_listenit_gle2) {
        if (com_ushareit_listenit_gle.f14298c == com_ushareit_listenit_gle2.f14298c) {
            if (com_ushareit_listenit_gle.f14297b == 2 && com_ushareit_listenit_gle2.f14297b == 1) {
                return 1;
            }
            if (com_ushareit_listenit_gle.f14297b == 1 && com_ushareit_listenit_gle2.f14297b == 2) {
                return -1;
            }
        }
        return com_ushareit_listenit_gle.f14298c - com_ushareit_listenit_gle2.f14298c;
    }
}
