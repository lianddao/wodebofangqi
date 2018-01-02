package com.ushareit.listenit;

import android.support.v4.widget.ContentLoadingProgressBar;

public class nz implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f16050a;

    public nz(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f16050a = contentLoadingProgressBar;
    }

    public void run() {
        this.f16050a.f132c = false;
        if (!this.f16050a.f133d) {
            this.f16050a.f130a = System.currentTimeMillis();
            this.f16050a.setVisibility(0);
        }
    }
}
