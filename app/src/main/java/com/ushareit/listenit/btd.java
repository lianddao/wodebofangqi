package com.ushareit.listenit;

import java.util.concurrent.ThreadFactory;

final class btd implements ThreadFactory {
    final /* synthetic */ String f7671a;

    btd(String str) {
        this.f7671a = str;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f7671a);
    }
}
