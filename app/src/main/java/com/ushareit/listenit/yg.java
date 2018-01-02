package com.ushareit.listenit;

import java.util.concurrent.FutureTask;

class yg<T> extends FutureTask<T> implements Comparable<yg<?>> {
    private final int f17561a;
    private final int f17562b;

    public /* synthetic */ int compareTo(Object obj) {
        return m27237a((yg) obj);
    }

    public yg(Runnable runnable, T t, int i) {
        super(runnable, t);
        if (runnable instanceof yk) {
            this.f17561a = ((yk) runnable).mo3116b();
            this.f17562b = i;
            return;
        }
        throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yg)) {
            return false;
        }
        yg ygVar = (yg) obj;
        if (this.f17562b == ygVar.f17562b && this.f17561a == ygVar.f17561a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17561a * 31) + this.f17562b;
    }

    public int m27237a(yg<?> ygVar) {
        int i = this.f17561a - ygVar.f17561a;
        if (i == 0) {
            return this.f17562b - ygVar.f17562b;
        }
        return i;
    }
}
