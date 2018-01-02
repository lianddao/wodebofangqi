package com.ushareit.listenit;

import android.content.Context;

final class aio implements Runnable {
    final /* synthetic */ Context f4446a;
    final /* synthetic */ String f4447b;

    aio(Context context, String str) {
        this.f4446a = context;
        this.f4447b = str;
    }

    public void run() {
        ail.m5706b(this.f4446a, this.f4447b);
    }
}
