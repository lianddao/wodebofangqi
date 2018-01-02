package com.ushareit.listenit;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class dcu extends AbstractSet<Entry<K, V>> {
    final /* synthetic */ dcs f9560a;

    dcu(dcs com_ushareit_listenit_dcs) {
        this.f9560a = com_ushareit_listenit_dcs;
    }

    public void clear() {
        this.f9560a.clear();
    }

    public boolean contains(Object obj) {
        return (obj instanceof Entry) && this.f9560a.m13814a((Entry) obj) != null;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new dcv(this);
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        dcz a = this.f9560a.m13814a((Entry) obj);
        if (a == null) {
            return false;
        }
        this.f9560a.m13815a(a, true);
        return true;
    }

    public int size() {
        return this.f9560a.f9555c;
    }
}
