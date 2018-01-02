package com.ushareit.listenit;

import android.os.Process;

class yf extends Thread {
    final /* synthetic */ ye f17560a;

    yf(ye yeVar, Runnable runnable, String str) {
        this.f17560a = yeVar;
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
