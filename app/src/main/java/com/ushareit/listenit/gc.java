package com.ushareit.listenit;

import java.util.Collection;
import java.util.Iterator;

final class gc implements Collection<V> {
    final /* synthetic */ fx f13891a;

    gc(fx fxVar) {
        this.f13891a = fxVar;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f13891a.mo2547c();
    }

    public boolean contains(Object obj) {
        return this.f13891a.mo2545b(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f13891a.mo2539a() == 0;
    }

    public Iterator<V> iterator() {
        return new fy(this.f13891a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f13891a.mo2545b(obj);
        if (b < 0) {
            return false;
        }
        this.f13891a.mo2543a(b);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.f13891a.mo2539a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f13891a.mo2541a(i, 1))) {
                this.f13891a.mo2543a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.f13891a.mo2539a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f13891a.mo2541a(i, 1))) {
                this.f13891a.mo2543a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f13891a.mo2539a();
    }

    public Object[] toArray() {
        return this.f13891a.m20517b(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f13891a.m20514a((Object[]) tArr, 1);
    }
}
