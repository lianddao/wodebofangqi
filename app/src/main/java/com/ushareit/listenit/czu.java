package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class czu {
    private final Handler f9440a;
    private final Executor f9441b;

    public czu(Executor executor) {
        this.f9441b = executor;
        if (this.f9441b != null) {
            this.f9440a = null;
        } else if (Looper.myLooper() != null) {
            this.f9440a = new Handler();
        } else {
            this.f9440a = null;
        }
    }

    public void m13543a(Runnable runnable) {
        cfi.m11080a((Object) runnable);
        if (this.f9440a != null) {
            this.f9440a.post(runnable);
        } else if (this.f9441b != null) {
            this.f9441b.execute(runnable);
        } else {
            efy.m17045a().m17049d(runnable);
        }
    }
}
