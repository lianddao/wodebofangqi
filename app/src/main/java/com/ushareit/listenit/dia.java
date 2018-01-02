package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class dia implements dhy {
    private IBinder f9818a;

    dia(IBinder iBinder) {
        this.f9818a = iBinder;
    }

    public void mo1812a(dhp com_ushareit_listenit_dhp, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            obtain.writeStrongBinder(com_ushareit_listenit_dhp != null ? com_ushareit_listenit_dhp.asBinder() : null);
            obtain.writeString(str);
            this.f9818a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9818a;
    }
}
