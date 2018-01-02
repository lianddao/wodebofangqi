package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.List;

final class agh extends Handler implements afx {
    private final String f4331a;
    private final List<afx> f4332b;

    public agh(String str, List<afx> list) {
        super(Looper.getMainLooper());
        this.f4331a = str;
        this.f4332b = list;
    }

    public void mo617a(File file, String str, int i) {
        Message obtainMessage = obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = file;
        sendMessage(obtainMessage);
    }

    public void handleMessage(Message message) {
        for (afx a : this.f4332b) {
            a.mo617a((File) message.obj, this.f4331a, message.arg1);
        }
    }
}
