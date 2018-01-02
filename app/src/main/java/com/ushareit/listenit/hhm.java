package com.ushareit.listenit;

import java.util.concurrent.FutureTask;

class hhm<T> extends FutureTask<T> implements Comparable<hhm<?>> {
    private final int f15464a;
    private final int f15465b;

    public /* synthetic */ int compareTo(Object obj) {
        return m23861a((hhm) obj);
    }

    public hhm(Runnable runnable, T t, int i) {
        super(runnable, t);
        if (runnable instanceof hhu) {
            this.f15464a = ((hhu) runnable).mo2786a();
            this.f15465b = i;
            return;
        }
        throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hhm)) {
            return false;
        }
        hhm com_ushareit_listenit_hhm = (hhm) obj;
        if (this.f15465b == com_ushareit_listenit_hhm.f15465b && this.f15464a == com_ushareit_listenit_hhm.f15464a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f15464a * 31) + this.f15465b;
    }

    public int m23861a(hhm<?> com_ushareit_listenit_hhm_) {
        int i = this.f15464a - com_ushareit_listenit_hhm_.f15464a;
        if (i == 0) {
            return this.f15465b - com_ushareit_listenit_hhm_.f15465b;
        }
        return i;
    }
}
