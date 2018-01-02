package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

class wv<K, V> {
    wv<K, V> f17493a;
    wv<K, V> f17494b;
    private final K f17495c;
    private List<V> f17496d;

    public wv() {
        this(null);
    }

    public wv(K k) {
        this.f17494b = this;
        this.f17493a = this;
        this.f17495c = k;
    }

    public V m27158a() {
        int b = m27160b();
        return b > 0 ? this.f17496d.remove(b - 1) : null;
    }

    public int m27160b() {
        return this.f17496d != null ? this.f17496d.size() : 0;
    }

    public void m27159a(V v) {
        if (this.f17496d == null) {
            this.f17496d = new ArrayList();
        }
        this.f17496d.add(v);
    }
}
