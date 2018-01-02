package com.ushareit.listenit;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class ga implements Set<K> {
    final /* synthetic */ fx f13804a;

    ga(fx fxVar) {
        this.f13804a = fxVar;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f13804a.mo2547c();
    }

    public boolean contains(Object obj) {
        return this.f13804a.mo2540a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return fx.m20504a(this.f13804a.mo2546b(), (Collection) collection);
    }

    public boolean isEmpty() {
        return this.f13804a.mo2539a() == 0;
    }

    public Iterator<K> iterator() {
        return new fy(this.f13804a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f13804a.mo2540a(obj);
        if (a < 0) {
            return false;
        }
        this.f13804a.mo2543a(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return fx.m20506b(this.f13804a.mo2546b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return fx.m20507c(this.f13804a.mo2546b(), collection);
    }

    public int size() {
        return this.f13804a.mo2539a();
    }

    public Object[] toArray() {
        return this.f13804a.m20517b(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f13804a.m20514a((Object[]) tArr, 0);
    }

    public boolean equals(Object obj) {
        return fx.m20505a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f13804a.mo2539a() - 1; a >= 0; a--) {
            Object a2 = this.f13804a.mo2541a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }
}
