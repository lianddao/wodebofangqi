package com.ushareit.listenit;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class cnk {
    private static final cnm f8515a = new cnl();

    public static <K, V> cnj<K, V> m11905a(Comparator<K> comparator) {
        return new cnh(comparator);
    }

    public static <A, B, C> cnj<A, C> m11906a(List<A> list, Map<B, C> map, cnm<A, B> com_ushareit_listenit_cnm_A__B, Comparator<A> comparator) {
        return list.size() < 25 ? cnh.m11882a(list, map, com_ushareit_listenit_cnm_A__B, comparator) : cnx.m11976a(list, map, com_ushareit_listenit_cnm_A__B, comparator);
    }

    public static <A, B> cnj<A, B> m11907a(Map<A, B> map, Comparator<A> comparator) {
        return map.size() < 25 ? cnh.m11883a((Map) map, (Comparator) comparator) : cnx.m11977a((Map) map, (Comparator) comparator);
    }

    public static <A> cnm<A, A> m11908a() {
        return f8515a;
    }
}
