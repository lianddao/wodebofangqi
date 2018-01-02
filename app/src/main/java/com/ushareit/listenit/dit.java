package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dit implements dir {
    private IBinder f9826a;

    dit(IBinder iBinder) {
        this.f9826a = iBinder;
    }

    public int mo1845a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.f9826a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9826a;
    }
}
