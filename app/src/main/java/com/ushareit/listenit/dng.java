package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class dng extends Handler {
    final /* synthetic */ dnb f10009a;

    dng(dnb com_ushareit_listenit_dnb, Looper looper) {
        this.f10009a = com_ushareit_listenit_dnb;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f10009a.m15002t();
                return;
            case 2:
                this.f10009a.m15001s();
                return;
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
