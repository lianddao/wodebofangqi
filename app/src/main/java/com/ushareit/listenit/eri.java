package com.ushareit.listenit;

public abstract class eri<T, V> {
    private final String f11532a;
    private final Class<V> f11533b;

    public abstract V mo2258a(T t);

    public eri(Class<V> cls, String str) {
        this.f11532a = str;
        this.f11533b = cls;
    }

    public void mo2257a(T t, V v) {
        throw new UnsupportedOperationException("Property " + m17416a() + " is read-only");
    }

    public String m17416a() {
        return this.f11532a;
    }
}
