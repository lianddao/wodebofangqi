package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class bxz implements bxx {
    private IBinder f7936a;

    bxz(IBinder iBinder) {
        this.f7936a = iBinder;
    }

    public long mo1179a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            this.f7936a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7936a;
    }
}
