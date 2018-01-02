package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class em extends Handler {
    public em() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        el elVar = (el) message.obj;
        switch (message.what) {
            case 1:
                elVar.f11193a.m15726e(elVar.f11194b[0]);
                return;
            case 2:
                elVar.f11193a.m15734b(elVar.f11194b);
                return;
            default:
                return;
        }
    }
}
