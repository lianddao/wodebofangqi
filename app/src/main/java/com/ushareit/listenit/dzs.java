package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class dzs implements Executor {
    private final Handler f10729a = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.f10729a.post(runnable);
    }
}
