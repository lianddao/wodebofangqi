package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class bvb implements buz {
    private IBinder f7788a;

    bvb(IBinder iBinder) {
        this.f7788a = iBinder;
    }

    public IBinder mo1105a(ckg com_ushareit_listenit_ckg, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeInt(i);
            this.f7788a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7788a;
    }
}
