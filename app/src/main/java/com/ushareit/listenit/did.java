package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class did implements dib {
    private IBinder f9819a;

    did(IBinder iBinder) {
        this.f9819a = iBinder;
    }

    public void mo1813a(dhp com_ushareit_listenit_dhp) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dhp != null ? com_ushareit_listenit_dhp.asBinder() : null);
            this.f9819a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9819a;
    }
}
