package com.ushareit.listenit;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class hhi extends ThreadPoolExecutor {
    private final AtomicInteger f15460a;
    private final hhn f15461b;

    public hhi(int i) {
        this(i, hhn.LOG);
    }

    public hhi(int i, hhn com_ushareit_listenit_hhn) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new hhk(), com_ushareit_listenit_hhn);
    }

    public hhi(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, hhn com_ushareit_listenit_hhn) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f15460a = new AtomicInteger();
        this.f15461b = com_ushareit_listenit_hhn;
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new hhm(runnable, t, this.f15460a.getAndIncrement());
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    this.f15461b.mo2785a(e);
                } catch (Throwable e2) {
                    this.f15461b.mo2785a(e2);
                }
            }
        }
    }
}
