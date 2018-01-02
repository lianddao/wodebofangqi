package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class dnl extends Handler {
    final /* synthetic */ dnj f10026a;

    dnl(dnj com_ushareit_listenit_dnj, Looper looper) {
        this.f10026a = com_ushareit_listenit_dnj;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((dnk) message.obj).m14917a(this.f10026a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", "Unknown message id: " + message.what);
                return;
        }
    }
}
