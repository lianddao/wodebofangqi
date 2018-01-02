package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class cms implements Executor {
    private static cms f8470a = new cms();
    private Handler f8471b = new Handler(Looper.getMainLooper());

    private cms() {
    }

    public static cms m11756a() {
        return f8470a;
    }

    public void execute(Runnable runnable) {
        this.f8471b.post(runnable);
    }
}
