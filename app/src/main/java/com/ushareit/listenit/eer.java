package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class eer extends Handler {
    final /* synthetic */ eeq f10902a;

    eer(eeq com_ushareit_listenit_eeq, Looper looper) {
        this.f10902a = com_ushareit_listenit_eeq;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.f10902a.m16873a(message);
    }
}
