package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cnh<K, V> extends cnj<K, V> {
    private final K[] f8508a;
    private final V[] f8509b;
    private final Comparator<K> f8510c;

    public cnh(Comparator<K> comparator) {
        this.f8508a = new Object[0];
        this.f8509b = new Object[0];
        this.f8510c = comparator;
    }

    private cnh(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f8508a = kArr;
        this.f8509b = vArr;
        this.f8510c = comparator;
    }

    public static <A, B, C> cnh<A, C> m11882a(List<A> list, Map<B, C> map, cnm<A, B> com_ushareit_listenit_cnm_A__B, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        size = 0;
        for (Object next : list) {
            objArr[size] = next;
            objArr2[size] = map.get(com_ushareit_listenit_cnm_A__B.mo1498a(next));
            size++;
        }
        return new cnh(comparator, objArr, objArr2);
    }

    public static <K, V> cnh<K, V> m11883a(Map<K, V> map, Comparator<K> comparator) {
        return m11882a(new ArrayList(map.keySet()), map, cnk.m11908a(), comparator);
    }

    private Iterator<Entry<K, V>> m11884a(int i, boolean z) {
        return new cni(this, i, z);
    }

    private static <T> T[] m11886a(T[] tArr, int i) {
        int length = tArr.length - 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        System.arraycopy(tArr, i + 1, obj, i, length - i);
        return obj;
    }

    private static <T> T[] m11887a(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        obj[i] = t;
        System.arraycopy(tArr, i, obj, i + 1, (length - i) - 1);
        return obj;
    }

    private static <T> T[] m11889b(T[] tArr, int i, T t) {
        int length = tArr.length;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, length);
        obj[i] = t;
        return obj;
    }

    private int m11890e(K k) {
        int i = 0;
        while (i < this.f8508a.length && this.f8510c.compare(this.f8508a[i], k) < 0) {
            i++;
        }
        return i;
    }

    private int m11891f(K k) {
        int i = 0;
        Object[] objArr = this.f8508a;
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.f8510c.compare(k, objArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    public cnj<K, V> mo1485a(K k, V v) {
        int f = m11891f(k);
        if (f != -1) {
            if (this.f8508a[f] == k && this.f8509b[f] == v) {
                return this;
            }
            return new cnh(this.f8510c, m11889b(this.f8508a, f, k), m11889b(this.f8509b, f, v));
        } else if (this.f8508a.length > 25) {
            Map hashMap = new HashMap(this.f8508a.length + 1);
            for (f = 0; f < this.f8508a.length; f++) {
                hashMap.put(this.f8508a[f], this.f8509b[f]);
            }
            hashMap.put(k, v);
            return cnx.m11977a(hashMap, this.f8510c);
        } else {
            f = m11890e(k);
            return new cnh(this.f8510c, m11887a(this.f8508a, f, k), m11887a(this.f8509b, f, v));
        }
    }

    public K mo1486a() {
        return this.f8508a.length > 0 ? this.f8508a[0] : null;
    }

    public void mo1487a(cnu<K, V> com_ushareit_listenit_cnu_K__V) {
        for (int i = 0; i < this.f8508a.length; i++) {
            com_ushareit_listenit_cnu_K__V.mo1573a(this.f8508a[i], this.f8509b[i]);
        }
    }

    public boolean mo1488a(K k) {
        return m11891f(k) != -1;
    }

    public K mo1489b() {
        return this.f8508a.length > 0 ? this.f8508a[this.f8508a.length - 1] : null;
    }

    public V mo1490b(K k) {
        int f = m11891f(k);
        return f != -1 ? this.f8509b[f] : null;
    }

    public int mo1491c() {
        return this.f8508a.length;
    }

    public cnj<K, V> mo1492c(K k) {
        int f = m11891f(k);
        if (f == -1) {
            return this;
        }
        return new cnh(this.f8510c, m11886a(this.f8508a, f), m11886a(this.f8509b, f));
    }

    public K mo1493d(K k) {
        int f = m11891f(k);
        if (f != -1) {
            return f > 0 ? this.f8508a[f - 1] : null;
        } else {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
    }

    public boolean mo1494d() {
        return this.f8508a.length == 0;
    }

    public Iterator<Entry<K, V>> mo1495e() {
        return m11884a(this.f8508a.length - 1, true);
    }

    public Comparator<K> mo1496f() {
        return this.f8510c;
    }

    public Iterator<Entry<K, V>> iterator() {
        return m11884a(0, false);
    }
}
