package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class far extends Handler {
    far(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        eyo com_ushareit_listenit_eyo = (eyo) message.obj;
        fay com_ushareit_listenit_fay = (fay) com_ushareit_listenit_eyo.m18560a();
        com_ushareit_listenit_eyo.m18561b();
        if (!com_ushareit_listenit_fay.m17707b()) {
            try {
                com_ushareit_listenit_fay.mo2281a(com_ushareit_listenit_fay.f11680f);
            } catch (Throwable e) {
                exw.m18444a("TaskHelper", e.toString(), e);
                if (exw.f12142a) {
                    e.printStackTrace();
                }
            } catch (Throwable e2) {
                esr.m17813a(eys.m18562a(), e2);
                exw.m18452b("TaskHelper", e2);
            }
            fau b = com_ushareit_listenit_fay.f11677c ? faq.f12330b : faq.f12331c;
            if (fau.f12349a) {
                b.m18743a(com_ushareit_listenit_fay.f11676b, com_ushareit_listenit_fay.f11680f);
            }
        }
    }
}
