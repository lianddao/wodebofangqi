package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class dpr extends cha<dpv> {
    public dpr(Context context, Looper looper, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 39, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    protected dpv m15248a(IBinder iBinder) {
        return dpw.m15254a(iBinder);
    }

    public String mo1243a() {
        return "com.google.android.gms.common.service.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m15248a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
