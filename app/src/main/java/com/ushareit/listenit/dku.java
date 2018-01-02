package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class dku extends cha<dky> {
    public dku(Context context, Looper looper, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 74, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    protected dky m14737a(IBinder iBinder) {
        return dkz.m14745a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.auth.api.accountactivationstate.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m14737a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
    }
}
