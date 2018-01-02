package com.ushareit.listenit;

import java.util.Iterator;
import java.util.Map.Entry;

class cwj implements Iterator<cwz> {
    private final Iterator<Entry<cwc, cxa>> f9264a;

    public cwj(Iterator<Entry<cwc, cxa>> it) {
        this.f9264a = it;
    }

    public cwz m13176a() {
        Entry entry = (Entry) this.f9264a.next();
        return new cwz((cwc) entry.getKey(), (cxa) entry.getValue());
    }

    public boolean hasNext() {
        return this.f9264a.hasNext();
    }

    public /* synthetic */ Object next() {
        return m13176a();
    }

    public void remove() {
        this.f9264a.remove();
    }
}
