package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dpx implements dpv {
    private IBinder f10139a;

    dpx(IBinder iBinder) {
        this.f10139a = iBinder;
    }

    public void mo2020a(dps com_ushareit_listenit_dps) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
            if (com_ushareit_listenit_dps != null) {
                iBinder = com_ushareit_listenit_dps.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f10139a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10139a;
    }
}
