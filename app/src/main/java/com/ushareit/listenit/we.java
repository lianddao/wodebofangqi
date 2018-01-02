package com.ushareit.listenit;

import android.os.Looper;

class we<Z> implements wk<Z> {
    private final wk<Z> f17113a;
    private final boolean f17114b;
    private wf f17115c;
    private uv f17116d;
    private int f17117e;
    private boolean f17118f;

    we(wk<Z> wkVar, boolean z) {
        if (wkVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f17113a = wkVar;
        this.f17114b = z;
    }

    void m26769a(uv uvVar, wf wfVar) {
        this.f17116d = uvVar;
        this.f17115c = wfVar;
    }

    boolean m26770a() {
        return this.f17114b;
    }

    public Z mo553b() {
        return this.f17113a.mo553b();
    }

    public int mo554c() {
        return this.f17113a.mo554c();
    }

    public void mo555d() {
        if (this.f17117e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.f17118f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.f17118f = true;
            this.f17113a.mo555d();
        }
    }

    void m26774e() {
        if (this.f17118f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f17117e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    void m26775f() {
        if (this.f17117e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f17117e - 1;
            this.f17117e = i;
            if (i == 0) {
                this.f17115c.mo3111b(this.f17116d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }
}
