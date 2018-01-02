package com.ushareit.listenit;

import java.util.Iterator;
import java.util.Map.Entry;

final class gb implements Iterator<Entry<K, V>>, Entry<K, V> {
    int f13837a;
    int f13838b;
    boolean f13839c = false;
    final /* synthetic */ fx f13840d;

    public /* synthetic */ Object next() {
        return m21572a();
    }

    gb(fx fxVar) {
        this.f13840d = fxVar;
        this.f13837a = fxVar.mo2539a() - 1;
        this.f13838b = -1;
    }

    public boolean hasNext() {
        return this.f13838b < this.f13837a;
    }

    public Entry<K, V> m21572a() {
        this.f13838b++;
        this.f13839c = true;
        return this;
    }

    public void remove() {
        if (this.f13839c) {
            this.f13840d.mo2543a(this.f13838b);
            this.f13838b--;
            this.f13837a--;
            this.f13839c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public K getKey() {
        if (this.f13839c) {
            return this.f13840d.mo2541a(this.f13838b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.f13839c) {
            return this.f13840d.mo2541a(this.f13838b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V setValue(V v) {
        if (this.f13839c) {
            return this.f13840d.mo2542a(this.f13838b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f13839c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(fs.m20756a(entry.getKey(), this.f13840d.mo2541a(this.f13838b, 0)) && fs.m20756a(entry.getValue(), this.f13840d.mo2541a(this.f13838b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.f13839c) {
            Object a = this.f13840d.mo2541a(this.f13838b, 0);
            Object a2 = this.f13840d.mo2541a(this.f13838b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
