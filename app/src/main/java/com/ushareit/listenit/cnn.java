package com.ushareit.listenit;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public class cnn<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<cnw<K, V>> f8516a = new Stack();
    private final boolean f8517b;

    cnn(cns<K, V> com_ushareit_listenit_cns_K__V, K k, Comparator<K> comparator, boolean z) {
        this.f8517b = z;
        cns com_ushareit_listenit_cns = com_ushareit_listenit_cns_K__V;
        while (!com_ushareit_listenit_cns.mo1503c()) {
            int compare = k != null ? z ? comparator.compare(k, com_ushareit_listenit_cns.mo1504d()) : comparator.compare(com_ushareit_listenit_cns.mo1504d(), k) : 1;
            if (compare < 0) {
                com_ushareit_listenit_cns = z ? com_ushareit_listenit_cns.mo1506f() : com_ushareit_listenit_cns.mo1507g();
            } else if (compare == 0) {
                this.f8516a.push((cnw) com_ushareit_listenit_cns);
                return;
            } else {
                this.f8516a.push((cnw) com_ushareit_listenit_cns);
                com_ushareit_listenit_cns = z ? com_ushareit_listenit_cns.mo1507g() : com_ushareit_listenit_cns.mo1506f();
            }
        }
    }

    public Entry<K, V> m11911a() {
        try {
            cnw com_ushareit_listenit_cnw = (cnw) this.f8516a.pop();
            Entry simpleEntry = new SimpleEntry(com_ushareit_listenit_cnw.mo1504d(), com_ushareit_listenit_cnw.mo1505e());
            cns f;
            if (this.f8517b) {
                for (f = com_ushareit_listenit_cnw.mo1506f(); !f.mo1503c(); f = f.mo1507g()) {
                    this.f8516a.push((cnw) f);
                }
            } else {
                for (f = com_ushareit_listenit_cnw.mo1507g(); !f.mo1503c(); f = f.mo1506f()) {
                    this.f8516a.push((cnw) f);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext() {
        return this.f8516a.size() > 0;
    }

    public /* synthetic */ Object next() {
        return m11911a();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
