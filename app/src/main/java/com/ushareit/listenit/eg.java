package com.ushareit.listenit;

import android.os.Handler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class eg<Params, Progress, Result> {
    private static final ThreadFactory f10367a = new eh();
    private static final BlockingQueue<Runnable> f10368b = new LinkedBlockingQueue(10);
    public static final Executor f10369c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f10368b, f10367a);
    private static em f10370d;
    private static volatile Executor f10371e = f10369c;
    private final eo<Params, Result> f10372f = new ei(this);
    private final FutureTask<Result> f10373g = new ej(this, this.f10372f);
    private volatile en f10374h = en.PENDING;
    private final AtomicBoolean f10375i = new AtomicBoolean();

    protected abstract Result mo2077a(Params... paramsArr);

    private static Handler m15724d() {
        Handler handler;
        synchronized (eg.class) {
            if (f10370d == null) {
                f10370d = new em();
            }
            handler = f10370d;
        }
        return handler;
    }

    private void m15723c(Result result) {
        if (!this.f10375i.get()) {
            m15725d(result);
        }
    }

    private Result m15725d(Result result) {
        m15724d().obtainMessage(1, new el(this, result)).sendToTarget();
        return result;
    }

    protected void m15729a() {
    }

    protected void mo2078a(Result result) {
    }

    protected void m15734b(Progress... progressArr) {
    }

    protected void mo2079b(Result result) {
        m15732b();
    }

    protected void m15732b() {
    }

    public final boolean m15735c() {
        return this.f10373g.isCancelled();
    }

    public final boolean m15731a(boolean z) {
        return this.f10373g.cancel(z);
    }

    public final eg<Params, Progress, Result> m15727a(Executor executor, Params... paramsArr) {
        if (this.f10374h != en.PENDING) {
            switch (ek.f11166a[this.f10374h.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f10374h = en.RUNNING;
        m15729a();
        this.f10372f.f11071b = paramsArr;
        executor.execute(this.f10373g);
        return this;
    }

    private void m15726e(Result result) {
        if (m15735c()) {
            mo2079b((Object) result);
        } else {
            mo2078a((Object) result);
        }
        this.f10374h = en.FINISHED;
    }
}
