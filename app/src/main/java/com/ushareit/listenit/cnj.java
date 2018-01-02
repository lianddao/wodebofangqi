package com.ushareit.listenit;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class cnj<K, V> implements Iterable<Entry<K, V>> {
    public abstract cnj<K, V> mo1485a(K k, V v);

    public abstract K mo1486a();

    public abstract void mo1487a(cnu<K, V> com_ushareit_listenit_cnu_K__V);

    public abstract boolean mo1488a(K k);

    public abstract K mo1489b();

    public abstract V mo1490b(K k);

    public abstract int mo1491c();

    public abstract cnj<K, V> mo1492c(K k);

    public abstract K mo1493d(K k);

    public abstract boolean mo1494d();

    public abstract Iterator<Entry<K, V>> mo1495e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cnj)) {
            return false;
        }
        cnj com_ushareit_listenit_cnj = (cnj) obj;
        if (!mo1496f().equals(com_ushareit_listenit_cnj.mo1496f())) {
            return false;
        }
        if (mo1491c() != com_ushareit_listenit_cnj.mo1491c()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = com_ushareit_listenit_cnj.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Comparator<K> mo1496f();

    public int hashCode() {
        int hashCode = mo1496f().hashCode();
        Iterator it = iterator();
        int i = hashCode;
        while (it.hasNext()) {
            i = ((Entry) it.next()).hashCode() + (i * 31);
        }
        return i;
    }

    public abstract Iterator<Entry<K, V>> iterator();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append("(");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=>");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(")");
        }
        stringBuilder.append("};");
        return stringBuilder.toString();
    }
}
