package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dhg implements dhe {
    private IBinder f9805a;

    dhg(IBinder iBinder) {
        this.f9805a = iBinder;
    }

    public IBinder mo1764a(ckg com_ushareit_listenit_ckg, ckg com_ushareit_listenit_ckg2, ckg com_ushareit_listenit_ckg3, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            obtain.writeStrongBinder(com_ushareit_listenit_ckg != null ? com_ushareit_listenit_ckg.asBinder() : null);
            obtain.writeStrongBinder(com_ushareit_listenit_ckg2 != null ? com_ushareit_listenit_ckg2.asBinder() : null);
            if (com_ushareit_listenit_ckg3 != null) {
                iBinder = com_ushareit_listenit_ckg3.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f9805a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9805a;
    }
}
