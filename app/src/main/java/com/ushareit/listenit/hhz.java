package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class hhz extends Handler {
    hhz(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        hhw com_ushareit_listenit_hhw = (hhw) message.obj;
        if (com_ushareit_listenit_hhw != null) {
            switch (message.what) {
                case 1:
                    hhx.m23879d(com_ushareit_listenit_hhw, message.arg1);
                    return;
                case 2:
                    hhx.m23880e(com_ushareit_listenit_hhw);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }
}
