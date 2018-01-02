package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class bwy implements bww {
    private IBinder f7927a;

    bwy(IBinder iBinder) {
        this.f7927a = iBinder;
    }

    public void mo1170a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdClickListener");
            this.f7927a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7927a;
    }
}
