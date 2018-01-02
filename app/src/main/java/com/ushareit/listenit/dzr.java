package com.ushareit.listenit;

import java.util.concurrent.Executor;

final class dzr implements Executor {
    dzr() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
