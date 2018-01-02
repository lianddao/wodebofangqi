package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dpu implements dps {
    private IBinder f10138a;

    dpu(IBinder iBinder) {
        this.f10138a = iBinder;
    }

    public void mo2018a(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            obtain.writeInt(i);
            this.f10138a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10138a;
    }
}
