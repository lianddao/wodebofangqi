package com.ushareit.listenit;

import java.util.Iterator;
import java.util.NoSuchElementException;

class cqr implements Iterator<cwc> {
    int f8731a = this.f8732b.f8729c;
    final /* synthetic */ cqq f8732b;

    cqr(cqq com_ushareit_listenit_cqq) {
        this.f8732b = com_ushareit_listenit_cqq;
    }

    public cwc m12349a() {
        if (hasNext()) {
            cwc com_ushareit_listenit_cwc = this.f8732b.f8728b[this.f8731a];
            this.f8731a++;
            return com_ushareit_listenit_cwc;
        }
        throw new NoSuchElementException("No more elements.");
    }

    public boolean hasNext() {
        return this.f8731a < this.f8732b.f8730d;
    }

    public /* synthetic */ Object next() {
        return m12349a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Can't remove component from immutable Path!");
    }
}
