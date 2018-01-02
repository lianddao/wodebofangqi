package com.ushareit.listenit;

import android.support.v4.widget.ContentLoadingProgressBar;

public class ny implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f16049a;

    public ny(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f16049a = contentLoadingProgressBar;
    }

    public void run() {
        this.f16049a.f131b = false;
        this.f16049a.f130a = -1;
        this.f16049a.setVisibility(8);
    }
}
