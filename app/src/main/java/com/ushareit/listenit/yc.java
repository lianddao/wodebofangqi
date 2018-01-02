package com.ushareit.listenit;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class yc extends ThreadPoolExecutor {
    private final AtomicInteger f17557a;
    private final yh f17558b;

    public yc(int i) {
        this(i, yh.LOG);
    }

    public yc(int i, yh yhVar) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new ye(), yhVar);
    }

    public yc(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, yh yhVar) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f17557a = new AtomicInteger();
        this.f17558b = yhVar;
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new yg(runnable, t, this.f17557a.getAndIncrement());
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    this.f17558b.mo3148a(e);
                } catch (Throwable e2) {
                    this.f17558b.mo3148a(e2);
                }
            }
        }
    }
}
