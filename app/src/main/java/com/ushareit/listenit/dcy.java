package com.ushareit.listenit;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class dcy<T> implements Iterator<T> {
    dcz<K, V> f9561b;
    dcz<K, V> f9562c;
    int f9563d;
    final /* synthetic */ dcs f9564e;

    private dcy(dcs com_ushareit_listenit_dcs) {
        this.f9564e = com_ushareit_listenit_dcs;
        this.f9561b = this.f9564e.f9557e.f9571d;
        this.f9562c = null;
        this.f9563d = this.f9564e.f9556d;
    }

    final dcz<K, V> m13818b() {
        dcz<K, V> com_ushareit_listenit_dcz_K__V = this.f9561b;
        if (com_ushareit_listenit_dcz_K__V == this.f9564e.f9557e) {
            throw new NoSuchElementException();
        } else if (this.f9564e.f9556d != this.f9563d) {
            throw new ConcurrentModificationException();
        } else {
            this.f9561b = com_ushareit_listenit_dcz_K__V.f9571d;
            this.f9562c = com_ushareit_listenit_dcz_K__V;
            return com_ushareit_listenit_dcz_K__V;
        }
    }

    public final boolean hasNext() {
        return this.f9561b != this.f9564e.f9557e;
    }

    public final void remove() {
        if (this.f9562c == null) {
            throw new IllegalStateException();
        }
        this.f9564e.m13815a(this.f9562c, true);
        this.f9562c = null;
        this.f9563d = this.f9564e.f9556d;
    }
}
