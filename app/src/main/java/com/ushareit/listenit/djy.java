package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class djy implements djw {
    private IBinder f9863a;

    djy(IBinder iBinder) {
        this.f9863a = iBinder;
    }

    public void mo1922a(djt com_ushareit_listenit_djt) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            obtain.writeStrongBinder(com_ushareit_listenit_djt != null ? com_ushareit_listenit_djt.asBinder() : null);
            this.f9863a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9863a;
    }
}
