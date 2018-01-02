package com.ushareit.listenit;

import android.os.IBinder;
import android.os.Parcel;

class eef implements eed {
    private IBinder f10870a;

    eef(IBinder iBinder) {
        this.f10870a = iBinder;
    }

    public void mo2149a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.firebase.database.connection.idl.IRequestResultCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f10870a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10870a;
    }
}
