package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class gni extends Handler {
    private List<gnh> f14445a = new CopyOnWriteArrayList();
    private List<gnh> f14446b = new CopyOnWriteArrayList();
    private long f14447c = 0;
    private final int f14448d = 500;

    public gni() {
        super(Looper.getMainLooper());
    }

    public void m22495a(gnh com_ushareit_listenit_gnh) {
        if (!this.f14445a.contains(com_ushareit_listenit_gnh)) {
            this.f14445a.add(com_ushareit_listenit_gnh);
        }
    }

    public void m22497b(gnh com_ushareit_listenit_gnh) {
        if (this.f14445a.contains(com_ushareit_listenit_gnh)) {
            this.f14445a.remove(com_ushareit_listenit_gnh);
        }
    }

    public void m22498c(gnh com_ushareit_listenit_gnh) {
        if (!this.f14446b.contains(com_ushareit_listenit_gnh)) {
            this.f14446b.add(com_ushareit_listenit_gnh);
        }
    }

    public void m22499d(gnh com_ushareit_listenit_gnh) {
        if (this.f14446b.contains(com_ushareit_listenit_gnh)) {
            this.f14446b.remove(com_ushareit_listenit_gnh);
        }
    }

    public void m22494a(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i == i2 || currentTimeMillis - this.f14447c >= 500) {
            this.f14447c = currentTimeMillis;
            Message obtainMessage = obtainMessage(0);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            sendMessage(obtainMessage);
        }
    }

    public void m22496b(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i == i2 || currentTimeMillis - this.f14447c >= 500) {
            this.f14447c = currentTimeMillis;
            Message obtainMessage = obtainMessage(1);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            sendMessage(obtainMessage);
        }
    }

    public void handleMessage(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 0:
                for (gnh a : this.f14445a) {
                    a.mo2404a(i, i2);
                }
                return;
            case 1:
                for (gnh a2 : this.f14446b) {
                    a2.mo2404a(i, i2);
                }
                return;
            default:
                return;
        }
    }
}
