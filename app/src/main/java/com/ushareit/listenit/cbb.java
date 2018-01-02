package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public final class cbb extends cha<cbh> {
    private final cat f8073d;

    public cbb(Context context, Looper looper, cgs com_ushareit_listenit_cgs, cat com_ushareit_listenit_cat, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 68, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f8073d = com_ushareit_listenit_cat;
    }

    protected cbh m10658a(IBinder iBinder) {
        return cbi.m10681a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m10658a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    protected Bundle mo1246c() {
        return this.f8073d == null ? new Bundle() : this.f8073d.m10580a();
    }
}
