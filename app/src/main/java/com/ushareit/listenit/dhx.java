package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dhx implements dhv {
    private IBinder f9817a;

    dhx(IBinder iBinder) {
        this.f9817a = iBinder;
    }

    public void mo1811a(dhl com_ushareit_listenit_dhl) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dhl != null ? com_ushareit_listenit_dhl.asBinder() : null);
            this.f9817a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9817a;
    }
}
