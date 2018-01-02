package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class byn implements byl {
    private IBinder f7949a;

    byn(IBinder iBinder) {
        this.f7949a = iBinder;
    }

    public IBinder mo1209a(ckg com_ushareit_listenit_ckg, dii com_ushareit_listenit_dii, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            if (com_ushareit_listenit_dii != null) {
                iBinder = com_ushareit_listenit_dii.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f7949a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f7949a;
    }
}
