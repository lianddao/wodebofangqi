package com.ushareit.listenit;

public class gf<T> implements ge<T> {
    private final Object[] f14016a;
    private int f14017b;

    public gf(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f14016a = new Object[i];
    }

    public T mo2669a() {
        if (this.f14017b <= 0) {
            return null;
        }
        int i = this.f14017b - 1;
        T t = this.f14016a[i];
        this.f14016a[i] = null;
        this.f14017b--;
        return t;
    }

    public boolean mo2670a(T t) {
        if (m21858b(t)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f14017b >= this.f14016a.length) {
            return false;
        } else {
            this.f14016a[this.f14017b] = t;
            this.f14017b++;
            return true;
        }
    }

    private boolean m21858b(T t) {
        for (int i = 0; i < this.f14017b; i++) {
            if (this.f14016a[i] == t) {
                return true;
            }
        }
        return false;
    }
}
