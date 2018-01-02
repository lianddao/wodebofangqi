package com.ushareit.listenit;

import android.os.Process;

class hhl extends Thread {
    final /* synthetic */ hhk f15463a;

    hhl(hhk com_ushareit_listenit_hhk, Runnable runnable, String str) {
        this.f15463a = com_ushareit_listenit_hhk;
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
