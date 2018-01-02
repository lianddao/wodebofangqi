package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class gzg extends Handler {
    private WeakReference<gze> f14953a;

    public gzg(gze com_ushareit_listenit_gze) {
        super(Looper.getMainLooper());
        this.f14953a = new WeakReference(com_ushareit_listenit_gze);
    }

    public void m23370a(Object obj) {
        Message obtainMessage = obtainMessage(1);
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    public void m23371b(Object obj) {
        Message obtainMessage = obtainMessage(2);
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    public void m23372c(Object obj) {
        Message obtainMessage = obtainMessage(3);
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    public void m23373d(Object obj) {
        Message obtainMessage = obtainMessage(4);
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    public void handleMessage(Message message) {
        gze com_ushareit_listenit_gze = (gze) this.f14953a.get();
        if (com_ushareit_listenit_gze != null) {
            int i = message.what;
            Object obj = message.obj;
            if (obj != null) {
                switch (i) {
                    case 1:
                        com_ushareit_listenit_gze.mo2398a(obj);
                        break;
                    case 2:
                        com_ushareit_listenit_gze.mo2400b(obj);
                        break;
                    case 3:
                        com_ushareit_listenit_gze.mo2401c(obj);
                        break;
                    case 4:
                        com_ushareit_listenit_gze.mo2403d(obj);
                        break;
                }
                super.handleMessage(message);
            }
        }
    }
}
