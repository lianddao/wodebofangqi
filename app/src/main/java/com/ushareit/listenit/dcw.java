package com.ushareit.listenit;

import java.util.AbstractSet;
import java.util.Iterator;

final class dcw extends AbstractSet<K> {
    final /* synthetic */ dcs f9566a;

    dcw(dcs com_ushareit_listenit_dcs) {
        this.f9566a = com_ushareit_listenit_dcs;
    }

    public void clear() {
        this.f9566a.clear();
    }

    public boolean contains(Object obj) {
        return this.f9566a.containsKey(obj);
    }

    public Iterator<K> iterator() {
        return new dcx(this);
    }

    public boolean remove(Object obj) {
        return this.f9566a.m13816b(obj) != null;
    }

    public int size() {
        return this.f9566a.f9555c;
    }
}
