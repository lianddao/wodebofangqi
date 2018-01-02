package com.ushareit.listenit;

import android.os.Handler.Callback;
import android.os.Message;

class wa implements Callback {
    private wa() {
    }

    public boolean handleMessage(Message message) {
        if (1 != message.what && 2 != message.what) {
            return false;
        }
        vx vxVar = (vx) message.obj;
        if (1 == message.what) {
            vxVar.m26752b();
        } else {
            vxVar.m26754c();
        }
        return true;
    }
}
