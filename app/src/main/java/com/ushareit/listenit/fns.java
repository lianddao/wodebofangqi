package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;

class fns extends Handler {
    final /* synthetic */ fnr f13066a;

    fns(fnr com_ushareit_listenit_fnr) {
        this.f13066a = com_ushareit_listenit_fnr;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f13066a.f13051j.m23799d();
                break;
            case 1:
                this.f13066a.f13051j.m23803h();
                break;
        }
        super.handleMessage(message);
    }
}
