package com.ushareit.listenit;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

class cyk extends ScheduledThreadPoolExecutor {
    final /* synthetic */ cyj f9361a;

    cyk(cyj com_ushareit_listenit_cyj, int i, ThreadFactory threadFactory) {
        this.f9361a = com_ushareit_listenit_cyj;
        super(i, threadFactory);
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            try {
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException e) {
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            this.f9361a.mo1461a(th);
        }
    }
}
