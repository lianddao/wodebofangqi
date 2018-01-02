package com.ushareit.listenit;

import java.util.Iterator;
import java.util.Map.Entry;

class cnp<T> implements Iterator<T> {
    final Iterator<Entry<T, Void>> f8519a;

    public cnp(Iterator<Entry<T, Void>> it) {
        this.f8519a = it;
    }

    public boolean hasNext() {
        return this.f8519a.hasNext();
    }

    public T next() {
        return ((Entry) this.f8519a.next()).getKey();
    }

    public void remove() {
        this.f8519a.remove();
    }
}
