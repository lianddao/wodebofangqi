package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;

class al extends Handler {
    final /* synthetic */ ak f4622a;

    al(ak akVar) {
        this.f4622a = akVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f4622a.f437g) {
                    this.f4622a.m703a(false);
                    return;
                }
                return;
            case 2:
                this.f4622a.mo544b();
                this.f4622a.f434d.m6553o();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
