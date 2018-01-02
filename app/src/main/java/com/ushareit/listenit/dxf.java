package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class dxf extends cfs<dxb> {
    public dxf(Context context, Looper looper, cfu com_ushareit_listenit_cfu, cfv com_ushareit_listenit_cfv) {
        super(context, looper, 93, com_ushareit_listenit_cfu, com_ushareit_listenit_cfv, null);
    }

    public dxb m16224a(IBinder iBinder) {
        return dxc.m16187a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.measurement.START";
    }

    public /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m16224a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
