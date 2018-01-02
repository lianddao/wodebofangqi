package com.ushareit.listenit;

import android.os.Process;

class dqa implements Runnable {
    private final Runnable f10148a;
    private final int f10149b;

    public dqa(Runnable runnable, int i) {
        this.f10148a = runnable;
        this.f10149b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f10149b);
        this.f10148a.run();
    }
}
