package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dke implements dkc {
    private IBinder f9865a;

    dke(IBinder iBinder) {
        this.f9865a = iBinder;
    }

    public IBinder mo1926a(ckg com_ushareit_listenit_ckg) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            this.f9865a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9865a;
    }
}
