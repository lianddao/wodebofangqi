package com.ushareit.listenit;

import java.lang.ref.WeakReference;

public abstract class ato<T> implements Runnable {
    private final WeakReference<T> f4596a;

    public ato(T t) {
        this.f4596a = new WeakReference(t);
    }

    public T m5924a() {
        return this.f4596a.get();
    }
}
