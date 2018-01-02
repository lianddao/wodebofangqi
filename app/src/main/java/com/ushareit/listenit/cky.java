package com.ushareit.listenit;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.iid.MessengerCompat;

public final class cky extends cla {
    Handler f8399a;
    final /* synthetic */ MessengerCompat f8400b;

    public cky(MessengerCompat messengerCompat, Handler handler) {
        this.f8400b = messengerCompat;
        this.f8399a = handler;
    }

    public void mo1391a(Message message) {
        message.arg2 = Binder.getCallingUid();
        this.f8399a.dispatchMessage(message);
    }
}
