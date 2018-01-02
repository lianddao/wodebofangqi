package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cnx<K, V> extends cnj<K, V> {
    private cns<K, V> f8528a;
    private Comparator<K> f8529b;

    private cnx(cns<K, V> com_ushareit_listenit_cns_K__V, Comparator<K> comparator) {
        this.f8528a = com_ushareit_listenit_cns_K__V;
        this.f8529b = comparator;
    }

    public static <A, B, C> cnx<A, C> m11976a(List<A> list, Map<B, C> map, cnm<A, B> com_ushareit_listenit_cnm_A__B, Comparator<A> comparator) {
        return cnz.m11992a(list, map, com_ushareit_listenit_cnm_A__B, comparator);
    }

    public static <A, B> cnx<A, B> m11977a(Map<A, B> map, Comparator<A> comparator) {
        return cnz.m11992a(new ArrayList(map.keySet()), map, cnk.m11908a(), comparator);
    }

    private cns<K, V> m11978e(K k) {
        cns<K, V> com_ushareit_listenit_cns_K__V = this.f8528a;
        while (!com_ushareit_listenit_cns_K__V.mo1503c()) {
            int compare = this.f8529b.compare(k, com_ushareit_listenit_cns_K__V.mo1504d());
            if (compare < 0) {
                com_ushareit_listenit_cns_K__V = com_ushareit_listenit_cns_K__V.mo1506f();
            } else if (compare == 0) {
                return com_ushareit_listenit_cns_K__V;
            } else {
                com_ushareit_listenit_cns_K__V = com_ushareit_listenit_cns_K__V.mo1507g();
            }
        }
        return null;
    }

    public cnj<K, V> mo1485a(K k, V v) {
        return new cnx(this.f8528a.mo1500a(k, v, this.f8529b).mo1499a(null, null, cnt.BLACK, null, null), this.f8529b);
    }

    public K mo1486a() {
        return this.f8528a.mo1508h().mo1504d();
    }

    public void mo1487a(cnu<K, V> com_ushareit_listenit_cnu_K__V) {
        this.f8528a.mo1502a(com_ushareit_listenit_cnu_K__V);
    }

    public boolean mo1488a(K k) {
        return m11978e(k) != null;
    }

    public K mo1489b() {
        return this.f8528a.mo1509i().mo1504d();
    }

    public V mo1490b(K k) {
        cns e = m11978e(k);
        return e != null ? e.mo1505e() : null;
    }

    public int mo1491c() {
        return this.f8528a.mo1510j();
    }

    public cnj<K, V> mo1492c(K k) {
        if (!mo1488a((Object) k)) {
            return this;
        }
        return new cnx(this.f8528a.mo1501a(k, this.f8529b).mo1499a(null, null, cnt.BLACK, null, null), this.f8529b);
    }

    public K mo1493d(K k) {
        cns com_ushareit_listenit_cns = this.f8528a;
        cns com_ushareit_listenit_cns2 = null;
        while (!com_ushareit_listenit_cns.mo1503c()) {
            int compare = this.f8529b.compare(k, com_ushareit_listenit_cns.mo1504d());
            if (compare == 0) {
                if (com_ushareit_listenit_cns.mo1506f().mo1503c()) {
                    return com_ushareit_listenit_cns2 != null ? com_ushareit_listenit_cns2.mo1504d() : null;
                } else {
                    com_ushareit_listenit_cns2 = com_ushareit_listenit_cns.mo1506f();
                    while (!com_ushareit_listenit_cns2.mo1507g().mo1503c()) {
                        com_ushareit_listenit_cns2 = com_ushareit_listenit_cns2.mo1507g();
                    }
                    return com_ushareit_listenit_cns2.mo1504d();
                }
            } else if (compare < 0) {
                com_ushareit_listenit_cns = com_ushareit_listenit_cns.mo1506f();
            } else {
                cns com_ushareit_listenit_cns3 = com_ushareit_listenit_cns;
                com_ushareit_listenit_cns = com_ushareit_listenit_cns.mo1507g();
                com_ushareit_listenit_cns2 = com_ushareit_listenit_cns3;
            }
        }
        String valueOf = String.valueOf(k);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Couldn't find predecessor key of non-present key: ").append(valueOf).toString());
    }

    public boolean mo1494d() {
        return this.f8528a.mo1503c();
    }

    public Iterator<Entry<K, V>> mo1495e() {
        return new cnn(this.f8528a, null, this.f8529b, true);
    }

    public Comparator<K> mo1496f() {
        return this.f8529b;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new cnn(this.f8528a, null, this.f8529b, false);
    }
}
