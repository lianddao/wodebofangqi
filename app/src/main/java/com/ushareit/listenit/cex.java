package com.ushareit.listenit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class cex<T> implements Iterator<T> {
    protected final cet<T> f8207a;
    protected int f8208b = -1;

    public cex(cet<T> com_ushareit_listenit_cet_T) {
        this.f8207a = (cet) cfi.m11080a((Object) com_ushareit_listenit_cet_T);
    }

    public boolean hasNext() {
        return this.f8208b < this.f8207a.mo1298b() + -1;
    }

    public T next() {
        if (hasNext()) {
            cet com_ushareit_listenit_cet = this.f8207a;
            int i = this.f8208b + 1;
            this.f8208b = i;
            return com_ushareit_listenit_cet.mo1301a(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f8208b);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
