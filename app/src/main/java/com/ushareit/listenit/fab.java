package com.ushareit.listenit;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class fab implements IInterface {
    private IBinder f12300a;

    public fab(IBinder iBinder) {
        this.f12300a = iBinder;
    }

    public IBinder asBinder() {
        return this.f12300a;
    }

    public String m18681a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f12300a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
