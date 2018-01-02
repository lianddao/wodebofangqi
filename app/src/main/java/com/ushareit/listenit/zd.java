package com.ushareit.listenit;

import java.util.Queue;

final class zd<A> {
    private static final Queue<zd<?>> f17613a = afu.m5496a(0);
    private int f17614b;
    private int f17615c;
    private A f17616d;

    static <A> zd<A> m27279a(A a, int i, int i2) {
        zd<A> zdVar = (zd) f17613a.poll();
        if (zdVar == null) {
            zdVar = new zd();
        }
        zdVar.m27280b(a, i, i2);
        return zdVar;
    }

    private zd() {
    }

    private void m27280b(A a, int i, int i2) {
        this.f17616d = a;
        this.f17615c = i;
        this.f17614b = i2;
    }

    public void m27281a() {
        f17613a.offer(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zd)) {
            return false;
        }
        zd zdVar = (zd) obj;
        if (this.f17615c == zdVar.f17615c && this.f17614b == zdVar.f17614b && this.f17616d.equals(zdVar.f17616d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f17614b * 31) + this.f17615c) * 31) + this.f17616d.hashCode();
    }
}
