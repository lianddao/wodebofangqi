package com.ushareit.listenit;

import java.util.Iterator;

final class fy<T> implements Iterator<T> {
    final int f13708a;
    int f13709b;
    int f13710c;
    boolean f13711d = false;
    final /* synthetic */ fx f13712e;

    fy(fx fxVar, int i) {
        this.f13712e = fxVar;
        this.f13708a = i;
        this.f13709b = fxVar.mo2539a();
    }

    public boolean hasNext() {
        return this.f13710c < this.f13709b;
    }

    public T next() {
        T a = this.f13712e.mo2541a(this.f13710c, this.f13708a);
        this.f13710c++;
        this.f13711d = true;
        return a;
    }

    public void remove() {
        if (this.f13711d) {
            this.f13710c--;
            this.f13709b--;
            this.f13711d = false;
            this.f13712e.mo2543a(this.f13710c);
            return;
        }
        throw new IllegalStateException();
    }
}
