package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

public class dmc<R extends ceg> extends Handler {
    public dmc() {
        this(Looper.getMainLooper());
    }

    public dmc(Looper looper) {
        super(looper);
    }

    public void m14821a() {
        removeMessages(2);
    }

    public void m14822a(ceh<? super R> com_ushareit_listenit_ceh__super_R, R r) {
        sendMessage(obtainMessage(1, new Pair(com_ushareit_listenit_ceh__super_R, r)));
    }

    protected void m14823b(ceh<? super R> com_ushareit_listenit_ceh__super_R, R r) {
        try {
            com_ushareit_listenit_ceh__super_R.mo2008a(r);
        } catch (RuntimeException e) {
            dma.m10788c(r);
            throw e;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Pair pair = (Pair) message.obj;
                m14823b((ceh) pair.first, (ceg) pair.second);
                return;
            case 2:
                ((dma) message.obj).m10794d(Status.f1689d);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
