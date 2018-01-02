package com.ushareit.listenit;

import android.os.HandlerThread;
import android.os.Process;

public final class bsv extends HandlerThread {
    private final int f7646a;

    public bsv(String str, int i) {
        super(str);
        this.f7646a = i;
    }

    public void run() {
        Process.setThreadPriority(this.f7646a);
        super.run();
    }
}
