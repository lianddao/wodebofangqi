package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ed extends Handler {
    final /* synthetic */ ec f10847a;

    ed(ec ecVar, Looper looper) {
        this.f10847a = ecVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f10847a.m16690a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
