package com.ushareit.listenit;

import java.util.concurrent.Executor;

class eew implements Executor {
    eew() {
    }

    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
