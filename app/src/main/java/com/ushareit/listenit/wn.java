package com.ushareit.listenit;

import android.os.Handler.Callback;
import android.os.Message;

class wn implements Callback {
    private wn() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((wk) message.obj).mo555d();
        return true;
    }
}
