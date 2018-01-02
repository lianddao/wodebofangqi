package com.ushareit.listenit;

import android.content.ComponentName;

class dvq implements Runnable {
    final /* synthetic */ ComponentName f10432a;
    final /* synthetic */ dvo f10433b;

    dvq(dvo com_ushareit_listenit_dvo, ComponentName componentName) {
        this.f10433b = com_ushareit_listenit_dvo;
        this.f10432a = componentName;
    }

    public void run() {
        this.f10433b.f10427a.m15785a(this.f10432a);
    }
}
