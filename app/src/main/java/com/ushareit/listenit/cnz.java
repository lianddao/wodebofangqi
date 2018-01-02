package com.ushareit.listenit;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class cnz<A, B, C> {
    private final List<A> f8530a;
    private final Map<B, C> f8531b;
    private final cnm<A, B> f8532c;
    private cnw<A, C> f8533d;
    private cnw<A, C> f8534e;

    private cnz(List<A> list, Map<B, C> map, cnm<A, B> com_ushareit_listenit_cnm_A__B) {
        this.f8530a = list;
        this.f8531b = map;
        this.f8532c = com_ushareit_listenit_cnm_A__B;
    }

    private cns<A, C> m11991a(int i, int i2) {
        if (i2 == 0) {
            return cnr.m11958a();
        }
        if (i2 == 1) {
            Object obj = this.f8530a.get(i);
            return new cnq(obj, m11993a(obj), null, null);
        }
        int i3 = i2 / 2;
        int i4 = i + i3;
        cns a = m11991a(i, i3);
        cns a2 = m11991a(i4 + 1, i3);
        obj = this.f8530a.get(i4);
        return new cnq(obj, m11993a(obj), a, a2);
    }

    public static <A, B, C> cnx<A, C> m11992a(List<A> list, Map<B, C> map, cnm<A, B> com_ushareit_listenit_cnm_A__B, Comparator<A> comparator) {
        cnz com_ushareit_listenit_cnz = new cnz(list, map, com_ushareit_listenit_cnm_A__B);
        Collections.sort(list, comparator);
        Iterator it = new coa(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            int i;
            coc com_ushareit_listenit_coc = (coc) it.next();
            size -= com_ushareit_listenit_coc.f8540b;
            if (com_ushareit_listenit_coc.f8539a) {
                com_ushareit_listenit_cnz.m11994a(cnt.BLACK, com_ushareit_listenit_coc.f8540b, size);
                i = size;
            } else {
                com_ushareit_listenit_cnz.m11994a(cnt.BLACK, com_ushareit_listenit_coc.f8540b, size);
                size -= com_ushareit_listenit_coc.f8540b;
                com_ushareit_listenit_cnz.m11994a(cnt.RED, com_ushareit_listenit_coc.f8540b, size);
                i = size;
            }
            size = i;
        }
        return new cnx(com_ushareit_listenit_cnz.f8533d == null ? cnr.m11958a() : com_ushareit_listenit_cnz.f8533d, comparator);
    }

    private C m11993a(A a) {
        return this.f8531b.get(this.f8532c.mo1498a(a));
    }

    private void m11994a(cnt com_ushareit_listenit_cnt, int i, int i2) {
        cns a = m11991a(i2 + 1, i - 1);
        Object obj = this.f8530a.get(i2);
        cns com_ushareit_listenit_cnv = com_ushareit_listenit_cnt == cnt.RED ? new cnv(obj, m11993a(obj), null, a) : new cnq(obj, m11993a(obj), null, a);
        if (this.f8533d == null) {
            this.f8533d = com_ushareit_listenit_cnv;
            this.f8534e = com_ushareit_listenit_cnv;
            return;
        }
        this.f8534e.m11944a(com_ushareit_listenit_cnv);
        this.f8534e = com_ushareit_listenit_cnv;
    }
}
