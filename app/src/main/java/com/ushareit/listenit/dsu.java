package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class dsu extends cha<dtk> {
    protected final dtz<dtk> f10306d = new dsv(this);
    private final String f10307e;

    public dsu(Context context, Looper looper, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec, String str, cgs com_ushareit_listenit_cgs) {
        super(context, looper, 23, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f10307e = str;
    }

    protected dtk m15449a(IBinder iBinder) {
        return dtl.m15520a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m15449a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle mo1246c() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f10307e);
        return bundle;
    }
}
