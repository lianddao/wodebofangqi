package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class edt implements edr {
    private IBinder f10864a;

    edt(IBinder iBinder) {
        this.f10864a = iBinder;
    }

    public void mo2144a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IGetTokenCallback");
            obtain.writeString(str);
            this.f10864a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10864a;
    }

    public void mo2145b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IGetTokenCallback");
            obtain.writeString(str);
            this.f10864a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
