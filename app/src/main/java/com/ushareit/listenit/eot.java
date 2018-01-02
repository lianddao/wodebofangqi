package com.ushareit.listenit;

import android.os.Handler;
import com.mopub.volley.ExecutorDelivery;
import java.util.concurrent.Executor;

public class eot implements Executor {
    final /* synthetic */ Handler f11403a;
    final /* synthetic */ ExecutorDelivery f11404b;

    public eot(ExecutorDelivery executorDelivery, Handler handler) {
        this.f11404b = executorDelivery;
        this.f11403a = handler;
    }

    public void execute(Runnable runnable) {
        this.f11403a.post(runnable);
    }
}
