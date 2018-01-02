package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

final class dov extends Handler {
    final /* synthetic */ dot f10114a;

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                ced com_ushareit_listenit_ced = (ced) message.obj;
                synchronized (this.f10114a.f10107e) {
                    if (com_ushareit_listenit_ced == null) {
                        this.f10114a.f10104b.m15188a(new Status(13, "Transform returned null"));
                    } else if (com_ushareit_listenit_ced instanceof don) {
                        this.f10114a.f10104b.m15188a(((don) com_ushareit_listenit_ced).m15169b());
                    } else {
                        this.f10114a.f10104b.m15200a(com_ushareit_listenit_ced);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "TransformedResultImpl";
                String str2 = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                return;
        }
    }
}
