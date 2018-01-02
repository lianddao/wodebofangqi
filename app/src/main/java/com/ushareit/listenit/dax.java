package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dax extends dba implements Iterable<dba> {
    private final List<dba> f9488a = new ArrayList();

    public int m13703a() {
        return this.f9488a.size();
    }

    public dba m13704a(int i) {
        return (dba) this.f9488a.get(i);
    }

    public void m13705a(dba com_ushareit_listenit_dba) {
        Object obj;
        if (com_ushareit_listenit_dba == null) {
            obj = dbc.f9489a;
        }
        this.f9488a.add(obj);
    }

    public Number mo1702b() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1702b();
        }
        throw new IllegalStateException();
    }

    public String mo1703c() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1703c();
        }
        throw new IllegalStateException();
    }

    public double mo1704d() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1704d();
        }
        throw new IllegalStateException();
    }

    public long mo1705e() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1705e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof dax) && ((dax) obj).f9488a.equals(this.f9488a));
    }

    public int mo1706f() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1706f();
        }
        throw new IllegalStateException();
    }

    public boolean mo1707g() {
        if (this.f9488a.size() == 1) {
            return ((dba) this.f9488a.get(0)).mo1707g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f9488a.hashCode();
    }

    public Iterator<dba> iterator() {
        return this.f9488a.iterator();
    }
}
