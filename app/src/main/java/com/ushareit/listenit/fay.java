package com.ushareit.listenit;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class fay {
    private static AtomicInteger f11675a = new AtomicInteger(0);
    private int f11676b;
    protected boolean f11677c = false;
    protected Future<?> f11678d = null;
    protected boolean f11679e = false;
    protected Exception f11680f = null;

    public abstract void mo2280a();

    public abstract void mo2281a(Exception exception);

    public fay() {
        if (fau.f12349a) {
            this.f11676b = f11675a.incrementAndGet();
        }
    }

    public final boolean m17707b() {
        return this.f11679e;
    }
}
