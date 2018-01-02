package com.ushareit.listenit;

import com.mopub.common.CloseableLayout;

public final class egj implements Runnable {
    final /* synthetic */ CloseableLayout f11035a;

    private egj(CloseableLayout closeableLayout) {
        this.f11035a = closeableLayout;
    }

    public void run() {
        this.f11035a.setClosePressed(false);
    }
}
