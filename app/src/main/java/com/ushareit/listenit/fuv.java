package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class fuv extends Handler {
    final /* synthetic */ fus f13550a;

    fuv(fus com_ushareit_listenit_fus, Looper looper) {
        this.f13550a = com_ushareit_listenit_fus;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (this.f13550a.f13537b != null && this.f13550a.f13537b.m23891b()) {
            this.f13550a.f13537b.m23886a();
        }
        this.f13550a.f13537b = null;
    }
}
