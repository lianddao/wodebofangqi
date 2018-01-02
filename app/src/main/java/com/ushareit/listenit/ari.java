package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.util.List;

final class ari extends Handler implements aqw {
    private final String f5236a;
    private final List<aqw> f5237b;

    public ari(String str, List<aqw> list) {
        super(Looper.getMainLooper());
        this.f5236a = str;
        this.f5237b = list;
    }

    public void mo787a(File file, String str, int i) {
        Message obtainMessage = obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = file;
        sendMessage(obtainMessage);
    }

    public void handleMessage(Message message) {
        for (aqw a : this.f5237b) {
            a.mo787a((File) message.obj, this.f5236a, message.arg1);
        }
    }
}
