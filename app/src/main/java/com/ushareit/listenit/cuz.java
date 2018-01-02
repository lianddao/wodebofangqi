package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class cuz {
    private final cvg f9175a;
    private final cws f9176b;

    public cuz(cvg com_ushareit_listenit_cvg) {
        this.f9175a = com_ushareit_listenit_cvg;
        this.f9176b = com_ushareit_listenit_cvg.m13004c();
    }

    private cuw m12966a(cuv com_ushareit_listenit_cuv, cqh com_ushareit_listenit_cqh, cwt com_ushareit_listenit_cwt) {
        if (!(com_ushareit_listenit_cuv.m12960b().equals(cuy.VALUE) || com_ushareit_listenit_cuv.m12960b().equals(cuy.CHILD_REMOVED))) {
            com_ushareit_listenit_cuv = com_ushareit_listenit_cuv.m12958a(com_ushareit_listenit_cwt.m13245a(com_ushareit_listenit_cuv.m12959a(), com_ushareit_listenit_cuv.m12961c().m13247a(), this.f9176b));
        }
        return com_ushareit_listenit_cqh.mo1581a(com_ushareit_listenit_cuv, this.f9175a);
    }

    private Comparator<cuv> m12968a() {
        return new cva(this);
    }

    private void m12969a(List<cuw> list, cuy com_ushareit_listenit_cuy, List<cuv> list2, List<cqh> list3, cwt com_ushareit_listenit_cwt) {
        List<cuv> arrayList = new ArrayList();
        for (cuv com_ushareit_listenit_cuv : list2) {
            if (com_ushareit_listenit_cuv.m12960b().equals(com_ushareit_listenit_cuy)) {
                arrayList.add(com_ushareit_listenit_cuv);
            }
        }
        Collections.sort(arrayList, m12968a());
        for (cuv com_ushareit_listenit_cuv2 : arrayList) {
            for (cqh com_ushareit_listenit_cqh : list3) {
                if (com_ushareit_listenit_cqh.mo1586a(com_ushareit_listenit_cuy)) {
                    list.add(m12966a(com_ushareit_listenit_cuv2, com_ushareit_listenit_cqh, com_ushareit_listenit_cwt));
                }
            }
        }
    }

    public List<cuw> m12970a(List<cuv> list, cwt com_ushareit_listenit_cwt, List<cqh> list2) {
        List<cuw> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (cuv com_ushareit_listenit_cuv : list) {
            if (com_ushareit_listenit_cuv.m12960b().equals(cuy.CHILD_CHANGED) && this.f9176b.m13239a(com_ushareit_listenit_cuv.m12962d().m13247a(), com_ushareit_listenit_cuv.m12961c().m13247a())) {
                arrayList2.add(cuv.m12957c(com_ushareit_listenit_cuv.m12959a(), com_ushareit_listenit_cuv.m12961c()));
            }
        }
        m12969a(arrayList, cuy.CHILD_REMOVED, list, list2, com_ushareit_listenit_cwt);
        m12969a(arrayList, cuy.CHILD_ADDED, list, list2, com_ushareit_listenit_cwt);
        m12969a(arrayList, cuy.CHILD_MOVED, arrayList2, list2, com_ushareit_listenit_cwt);
        m12969a(arrayList, cuy.CHILD_CHANGED, list, list2, com_ushareit_listenit_cwt);
        m12969a(arrayList, cuy.VALUE, list, list2, com_ushareit_listenit_cwt);
        return arrayList;
    }
}
