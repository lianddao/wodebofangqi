package com.ushareit.listenit;

import android.content.Intent;

class eem implements Runnable {
    final /* synthetic */ Intent f10874a;
    final /* synthetic */ Intent f10875b;
    final /* synthetic */ eek f10876c;

    eem(eek com_ushareit_listenit_eek, Intent intent, Intent intent2) {
        this.f10876c = com_ushareit_listenit_eek;
        this.f10874a = intent;
        this.f10875b = intent2;
    }

    public void run() {
        this.f10876c.mo292b(this.f10874a);
        this.f10876c.mo294d(this.f10875b);
    }
}
