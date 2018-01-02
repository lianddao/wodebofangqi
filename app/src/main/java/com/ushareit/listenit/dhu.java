package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dhu implements dhs {
    private IBinder f9816a;

    dhu(IBinder iBinder) {
        this.f9816a = iBinder;
    }

    public void mo1810a(dhh com_ushareit_listenit_dhh) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dhh != null ? com_ushareit_listenit_dhh.asBinder() : null);
            this.f9816a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9816a;
    }
}
