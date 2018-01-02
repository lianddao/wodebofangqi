package com.ushareit.listenit;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

class eel extends Handler {
    final /* synthetic */ eek f10873a;

    eel(eek com_ushareit_listenit_eek, Looper looper) {
        this.f10873a = com_ushareit_listenit_eek;
        super(looper);
    }

    public void handleMessage(Message message) {
        int a = MessengerCompat.m2337a(message);
        eeq.m16859a(this.f10873a);
        this.f10873a.getPackageManager();
        if (a == eeq.f10889c || a == eeq.f10888b) {
            this.f10873a.mo292b((Intent) message.obj);
            return;
        }
        int i = eeq.f10888b;
        Log.w("FirebaseInstanceId", "Message from unexpected caller " + a + " mine=" + i + " appid=" + eeq.f10889c);
    }
}
