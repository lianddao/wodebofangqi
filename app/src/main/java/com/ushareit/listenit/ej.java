package com.ushareit.listenit;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ej extends FutureTask<Result> {
    final /* synthetic */ eg f11109a;

    ej(eg egVar, Callable callable) {
        this.f11109a = egVar;
        super(callable);
    }

    protected void done() {
        try {
            this.f11109a.m15723c(get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.f11109a.m15723c(null);
        } catch (Throwable e4) {
            RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
        }
    }
}
