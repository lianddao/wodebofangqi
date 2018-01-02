package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class cjv extends cha<ckc> {
    public cjv(Context context, Looper looper, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 64, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    protected ckc m11479a(IBinder iBinder) {
        return ckd.m11502a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.config.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m11479a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.config.internal.IConfigService";
    }
}
