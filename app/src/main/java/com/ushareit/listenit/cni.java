package com.ushareit.listenit;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Iterator;
import java.util.Map.Entry;

class cni implements Iterator<Entry<K, V>> {
    int f8511a = this.f8512b;
    final /* synthetic */ int f8512b;
    final /* synthetic */ boolean f8513c;
    final /* synthetic */ cnh f8514d;

    cni(cnh com_ushareit_listenit_cnh, int i, boolean z) {
        this.f8514d = com_ushareit_listenit_cnh;
        this.f8512b = i;
        this.f8513c = z;
    }

    public Entry<K, V> m11904a() {
        Object obj = this.f8514d.f8508a[this.f8511a];
        Object obj2 = this.f8514d.f8509b[this.f8511a];
        this.f8511a = this.f8513c ? this.f8511a - 1 : this.f8511a + 1;
        return new SimpleImmutableEntry(obj, obj2);
    }

    public boolean hasNext() {
        return this.f8513c ? this.f8511a >= 0 : this.f8511a < this.f8514d.f8508a.length;
    }

    public /* synthetic */ Object next() {
        return m11904a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }
}
