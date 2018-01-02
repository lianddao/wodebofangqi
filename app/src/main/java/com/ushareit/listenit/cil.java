package com.ushareit.listenit;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class cil<E> extends AbstractSet<E> {
    private final fq<E, E> f8353a = new fq();

    public boolean m11383a(cil<? extends E> com_ushareit_listenit_cil__extends_E) {
        int size = size();
        this.f8353a.m20342a(com_ushareit_listenit_cil__extends_E.f8353a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f8353a.containsKey(e)) {
            return false;
        }
        this.f8353a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof cil ? m11383a((cil) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f8353a.clear();
    }

    public boolean contains(Object obj) {
        return this.f8353a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f8353a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f8353a.containsKey(obj)) {
            return false;
        }
        this.f8353a.remove(obj);
        return true;
    }

    public int size() {
        return this.f8353a.size();
    }
}
