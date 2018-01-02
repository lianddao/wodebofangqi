package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import com.ushareit.listenit.main.MainActivity;

public class gim extends Handler {
    final /* synthetic */ MainActivity f14167a;

    public gim(MainActivity mainActivity) {
        this.f14167a = mainActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 4096:
                hjb.m23924a(this.f14167a);
                return;
            default:
                return;
        }
    }
}
