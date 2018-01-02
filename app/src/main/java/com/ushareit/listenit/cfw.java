package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class cfw extends Handler {
    final /* synthetic */ cfs f8228a;

    public cfw(cfs com_ushareit_listenit_cfs, Looper looper) {
        this.f8228a = com_ushareit_listenit_cfs;
        super(looper);
    }

    private void m11132a(Message message) {
        cfx com_ushareit_listenit_cfx = (cfx) message.obj;
        com_ushareit_listenit_cfx.mo1305b();
        com_ushareit_listenit_cfx.m11122d();
    }

    private boolean m11133b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5;
    }

    public void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.f8228a.f8048b.get() != message.arg1) {
            if (m11133b(message)) {
                m11132a(message);
            }
        } else if ((message.what == 1 || message.what == 5) && !this.f8228a.m10624i()) {
            m11132a(message);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.f8228a.f8061p.mo1310a(connectionResult);
            this.f8228a.m10612a(connectionResult);
        } else if (message.what == 4) {
            this.f8228a.m10600b(4, null);
            if (this.f8228a.f8066u != null) {
                this.f8228a.f8066u.mo1317a(message.arg2);
            }
            this.f8228a.m10607a(message.arg2);
            this.f8228a.m10597a(4, 1, null);
        } else if (message.what == 2 && !this.f8228a.m10623h()) {
            m11132a(message);
        } else if (m11133b(message)) {
            ((cfx) message.obj).m11121c();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
