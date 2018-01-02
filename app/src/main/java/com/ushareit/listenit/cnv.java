package com.ushareit.listenit;

public class cnv<K, V> extends cnw<K, V> {
    cnv(K k, V v) {
        super(k, v, cnr.m11958a(), cnr.m11958a());
    }

    cnv(K k, V v, cns<K, V> com_ushareit_listenit_cns_K__V, cns<K, V> com_ushareit_listenit_cns_K__V2) {
        super(k, v, com_ushareit_listenit_cns_K__V, com_ushareit_listenit_cns_K__V2);
    }

    protected cnt mo1511a() {
        return cnt.RED;
    }

    protected cnw<K, V> mo1512a(K k, V v, cns<K, V> com_ushareit_listenit_cns_K__V, cns<K, V> com_ushareit_listenit_cns_K__V2) {
        Object d;
        Object e;
        cns f;
        cns g;
        if (k == null) {
            d = mo1504d();
        }
        if (v == null) {
            e = mo1505e();
        }
        if (com_ushareit_listenit_cns_K__V == null) {
            f = mo1506f();
        }
        if (com_ushareit_listenit_cns_K__V2 == null) {
            g = mo1507g();
        }
        return new cnv(d, e, f, g);
    }

    public boolean mo1513b() {
        return true;
    }
}
