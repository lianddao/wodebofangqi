package com.ushareit.listenit;

import android.os.Handler.Callback;
import android.os.Message;

class acg implements Callback {
    final /* synthetic */ acc f4111a;

    private acg(acc com_ushareit_listenit_acc) {
        this.f4111a = com_ushareit_listenit_acc;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            this.f4111a.m5164a((ace) message.obj);
            return true;
        }
        if (message.what == 2) {
            tt.m26452a((ace) message.obj);
        }
        return false;
    }
}
