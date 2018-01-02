package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dkk implements dki {
    private IBinder f9867a;

    dkk(IBinder iBinder) {
        this.f9867a = iBinder;
    }

    public void mo1932a(dkf com_ushareit_listenit_dkf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dkf != null ? com_ushareit_listenit_dkf.asBinder() : null);
            this.f9867a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo1933a(String str) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            obtain.writeString(str);
            this.f9867a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9867a;
    }
}
