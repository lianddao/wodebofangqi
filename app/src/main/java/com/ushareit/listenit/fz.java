package com.ushareit.listenit;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class fz implements Set<Entry<K, V>> {
    final /* synthetic */ fx f13749a;

    fz(fx fxVar) {
        this.f13749a = fxVar;
    }

    public /* synthetic */ boolean add(Object obj) {
        return m21372a((Entry) obj);
    }

    public boolean m21372a(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int a = this.f13749a.mo2539a();
        for (Entry entry : collection) {
            this.f13749a.mo2544a(entry.getKey(), entry.getValue());
        }
        return a != this.f13749a.mo2539a();
    }

    public void clear() {
        this.f13749a.mo2547c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f13749a.mo2540a(entry.getKey());
        if (a >= 0) {
            return fs.m20756a(this.f13749a.mo2541a(a, 1), entry.getValue());
        }
        return false;
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
        return this.f13749a.mo2539a() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new gb(this.f13749a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f13749a.mo2539a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return fx.m20505a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f13749a.mo2539a() - 1;
        int i = 0;
        while (a >= 0) {
            int i2;
            Object a2 = this.f13749a.mo2541a(a, 0);
            Object a3 = this.f13749a.mo2541a(a, 1);
            int hashCode = a2 == null ? 0 : a2.hashCode();
            if (a3 == null) {
                i2 = 0;
            } else {
                i2 = a3.hashCode();
            }
            a--;
            i += i2 ^ hashCode;
        }
        return i;
    }
}
